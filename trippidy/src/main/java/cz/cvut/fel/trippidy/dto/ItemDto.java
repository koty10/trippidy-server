package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.Item;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Item} entity
 */
public class ItemDto implements Serializable {
    private int id;
    private String name;
    private boolean isChecked;
    private int amount;
    private boolean isPrivate;
    private boolean isShared;
    private int price;
    private int memberId;
    private int categoryId;
    private String categoryName;

    public ItemDto(int id, String name, boolean isChecked, int amount, boolean isPrivate, boolean isShared, int price, int memberId, int categoryId, String categoryName) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
        this.amount = amount;
        this.isPrivate = isPrivate;
        this.isShared = isShared;
        this.price = price;
        this.memberId = memberId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public ItemDto() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public boolean getIsShared() {
        return isShared;
    }

    public int getPrice() {
        return price;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto entity = (ItemDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.isChecked, entity.isChecked) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.isPrivate, entity.isPrivate) &&
                Objects.equals(this.isShared, entity.isShared) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.memberId, entity.memberId) &&
                Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.categoryName, entity.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isChecked, amount, isPrivate, isShared, price, memberId, categoryId, categoryName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "isChecked = " + isChecked + ", " +
                "amount = " + amount + ", " +
                "isPrivate = " + isPrivate + ", " +
                "isShared = " + isShared + ", " +
                "price = " + price + ", " +
                "memberId = " + memberId + ", " +
                "categoryId = " + categoryId + ", " +
                "categoryName = " + categoryName + ")";
    }
}