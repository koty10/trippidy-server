package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.service.ItemService;
import cz.cvut.fel.trippidy.service.TripService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Path("/v1/my/item")
@RequestScoped
@RolesAllowed({"user"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyItemResource {
    @EJB
    ItemService itemService;

    @Context
    SecurityContext securityContext;

    @POST
    public ItemDto updateItem(@Context HttpServletRequest request, ItemDto itemDto) throws AuthException {
        return itemService.updateItem(securityContext.getUserPrincipal().getName(), itemDto);
    }
}