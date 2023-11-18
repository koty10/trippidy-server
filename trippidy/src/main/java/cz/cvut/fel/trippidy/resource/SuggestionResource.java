package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.SuggestionRequestDto;
import cz.cvut.fel.trippidy.dto.SuggestionResponseDto;
import cz.cvut.fel.trippidy.service.SuggestionService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/suggest")
@RequestScoped
@RolesAllowed({"user"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SuggestionResource {

    @EJB
    SuggestionService suggestionService;

    @POST
    public SuggestionResponseDto suggestItemNamesForTripNamed(SuggestionRequestDto suggestionRequestDto) throws Exception {
        return suggestionService.suggestItems(suggestionRequestDto);
    }
}
