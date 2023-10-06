package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.CompletedTransactionDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.service.CompletedTransactionService;
import cz.cvut.fel.trippidy.service.MemberService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

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
    public CompletedTransactionDto createCompletedTransaction(@Context HttpServletRequest request, CompletedTransactionDto completedTransactionDto) throws Exception {
        return completedTransactionService.createCompletedTransaction(securityContext.getUserPrincipal().getName(), completedTransactionDto);
    }
}