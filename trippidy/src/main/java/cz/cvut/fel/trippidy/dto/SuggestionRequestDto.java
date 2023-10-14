package cz.cvut.fel.trippidy.dto;

import java.util.List;

public class SuggestionRequestDto {
    private String tripName;
    private String itemsCategory;
    private List<String> alreadyPackedItems;

    public SuggestionRequestDto(String tripName, String itemsCategory, List<String> alreadyPackedItems) {
        this.tripName = tripName;
        this.itemsCategory = itemsCategory;
        this.alreadyPackedItems= alreadyPackedItems;
    }

    public SuggestionRequestDto() {}

    public String getTripName() {
        return tripName;
    }

    public List<String> getAlreadyPackedItems() {
        return alreadyPackedItems;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setAlreadyPackedItems(List<String> alreadyPackedItems) {
        this.alreadyPackedItems = alreadyPackedItems;
    }

    public String getItemsCategory() {
        return itemsCategory;
    }

    public void setItemsCategory(String itemsCategory) {
        this.itemsCategory = itemsCategory;
    }
}
