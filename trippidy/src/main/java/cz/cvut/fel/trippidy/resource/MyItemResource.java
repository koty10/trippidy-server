package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.service.ItemService;
import cz.cvut.fel.trippidy.service.TripService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
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

    @PUT
    public ItemDto updateItem(@Context HttpServletRequest request, ItemDto itemDto) throws AuthException {
        return itemService.updateItem(securityContext.getUserPrincipal().getName(), itemDto);
    }

    @POST
    public ItemDto createItem(@Context HttpServletRequest request, ItemDto itemDto) throws Exception {
        return itemService.createItem(securityContext.getUserPrincipal().getName(), itemDto);
    }
}
