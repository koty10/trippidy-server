package cz.cvut.fel.trippidy.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link cz.cvut.fel.trippidy.model.Item} entity
 */
public class ItemDto implements Serializable {
    private final int id;
    private final String name;
    private final boolean isChecked;
    private final int amount;
    private final boolean isPrivate;
    private final boolean isShared;
    private final int price;
    private final int memberMemberId;
    private final String categoryCategoryName;

    public ItemDto(int id, String name, boolean isChecked, int amount, boolean isPrivate, boolean isShared, int price, int memberMemberId, String categoryCategoryName) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
        this.amount = amount;
        this.isPrivate = isPrivate;
        this.isShared = isShared;
        this.price = price;
        this.memberMemberId = memberMemberId;
        this.categoryCategoryName = categoryCategoryName;
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

    public int getMemberMemberId() {
        return memberMemberId;
    }

    public String getCategoryCategoryName() {
        return categoryCategoryName;
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
                Objects.equals(this.memberMemberId, entity.memberMemberId) &&
                Objects.equals(this.categoryCategoryName, entity.categoryCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isChecked, amount, isPrivate, isShared, price, memberMemberId, categoryCategoryName);
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
                "memberMemberId = " + memberMemberId + ", " +
                "categoryCategoryName = " + categoryCategoryName + ")";
    }
}