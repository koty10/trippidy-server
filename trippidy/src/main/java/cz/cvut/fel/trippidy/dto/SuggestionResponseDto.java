package cz.cvut.fel.trippidy.dto;

import java.util.ArrayList;
import java.util.List;

public class SuggestionResponseDto {
    private List<String> suggestedItems;

    public SuggestionResponseDto(List<String> suggestedItems) {
        this.suggestedItems = suggestedItems;
    }

    public SuggestionResponseDto() {
        suggestedItems = new ArrayList<>();
    }


    public List<String> getSuggestedItems() {
        return suggestedItems;
    }

    public void setSuggestedItems(List<String> suggestedItems) {
        this.suggestedItems = suggestedItems;
    }
}
