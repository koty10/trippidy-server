package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.Category;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link Category} entity
 */
public class CategoryDto implements Serializable {
    private UUID id;
    private String name;
    private Collection<ItemDto> items;

    public CategoryDto(UUID id, String name, Collection<ItemDto> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public CategoryDto() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<ItemDto> getItems() {
        return items;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(Collection<ItemDto> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto entity = (CategoryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.items, entity.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, items);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "items = " + items + ")";
    }
}