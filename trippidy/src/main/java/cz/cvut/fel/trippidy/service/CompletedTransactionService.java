package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.CompletedTransactionDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.entity.CompletedTransaction;
import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.mappers.Mapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.message.AuthException;

@Stateless
public class CompletedTransactionService {

    @PersistenceContext
    EntityManager entityManager;

    public CompletedTransactionDto createCompletedTransaction(String userId, CompletedTransactionDto completedTransactionDto) throws Exception { //todo remove userId
        if (entityManager.find(CompletedTransaction.class, completedTransactionDto.getId()) != null) throw new Exception("Element already exists");

        CompletedTransaction completedTransaction = Mapper.MAPPER.toEntity(completedTransactionDto);
        entityManager.persist(completedTransaction);

        var trip = entityManager.find(Trip.class, completedTransaction.getTrip().getId());
        var payer = entityManager.find(Member.class, completedTransaction.getPayer().getId());
        var payee = entityManager.find(Member.class, completedTransaction.getPayee().getId());

        trip.getCompletedTransactions().add(completedTransaction);
        payer.getCompletedTransactionsSent().add(completedTransaction);
        payee.getCompletedTransactionsReceived().add(completedTransaction);
        entityManager.persist(trip);
        entityManager.persist(payer);
        entityManager.persist(payee);
        // FIXME I have to load full member object here but probably this is not the best approach
        completedTransaction.setTrip(trip);
        completedTransaction.setPayer(payer);
        completedTransaction.setPayee(payee);
        return Mapper.MAPPER.toDto(completedTransaction);
    }
}
