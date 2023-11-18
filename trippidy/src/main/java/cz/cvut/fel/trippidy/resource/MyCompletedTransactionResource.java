package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.CompletedTransactionDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.service.CompletedTransactionService;
import cz.cvut.fel.trippidy.service.MemberService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/v1/my/completedTransaction")
@RequestScoped
@RolesAllowed({"user"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyCompletedTransactionResource {
    @EJB
    CompletedTransactionService completedTransactionService;

    @Context
    SecurityContext securityContext;

    @POST
    public CompletedTransactionDto createCompletedTransaction(CompletedTransactionDto completedTransactionDto) {
        var completedTransaction = completedTransactionService.createCompletedTransaction(completedTransactionDto);
        return completedTransactionService.toDto(completedTransaction);
    }
}
