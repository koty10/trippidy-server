package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.SuggestionRequestDto;
import cz.cvut.fel.trippidy.dto.SuggestionResponseDto;
import cz.cvut.fel.trippidy.service.SuggestionService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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