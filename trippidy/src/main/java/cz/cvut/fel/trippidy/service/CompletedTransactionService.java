package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.CompletedTransactionDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.entity.CompletedTransaction;
import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.mappers.Mapper;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.auth.message.AuthException;

@Stateless
public class CompletedTransactionService {

    @PersistenceContext
    EntityManager entityManager;

    public CompletedTransaction createCompletedTransaction(CompletedTransactionDto completedTransactionDto) {
        CompletedTransaction completedTransaction = Mapper.MAPPER.toEntity(completedTransactionDto);

        var trip = entityManager.find(Trip.class, completedTransaction.getTrip().getId());
        var payer = entityManager.find(Member.class, completedTransaction.getPayer().getId());
        var payee = entityManager.find(Member.class, completedTransaction.getPayee().getId());

        trip.getCompletedTransactions().add(completedTransaction);
        payer.getCompletedTransactionsSent().add(completedTransaction);
        payee.getCompletedTransactionsReceived().add(completedTransaction);

        // FIXME I have to load full member object here but probably this is not the best approach
        completedTransaction.setTrip(trip);
        completedTransaction.setPayer(payer);
        completedTransaction.setPayee(payee);

        entityManager.merge(trip);
        entityManager.merge(payer);
        entityManager.merge(payee);
        entityManager.persist(completedTransaction);

        return completedTransaction;
    }

    public CompletedTransactionDto toDto(CompletedTransaction completedTransaction) {
        return Mapper.MAPPER.toDto(entityManager.find(CompletedTransaction.class, completedTransaction.getId()));
    }
}
