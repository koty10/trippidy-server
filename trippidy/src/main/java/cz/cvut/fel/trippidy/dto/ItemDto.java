package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.Item;
import cz.cvut.fel.trippidy.serializers.BigDecimalDeserializer;
import cz.cvut.fel.trippidy.serializers.BigDecimalSerializer;

import jakarta.json.bind.annotation.JsonbNillable;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.ws.rs.DefaultValue;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link Item} entity
 */
public class ItemDto implements Serializable {
    private UUID id;
    private String name;
    private boolean isChecked;
    private int amount;
    private boolean isPrivate;
    private boolean isShared;
    private BigDecimal price;
    private UUID memberId;
    private UUID categoryId;
    private String categoryName;
    private Collection<FutureTransactionDto> futureTransactions;

    public ItemDto(UUID id, String name, boolean isChecked, int amount, boolean isPrivate, boolean isShared, BigDecimal price, UUID memberId, UUID categoryId, String categoryName,
                   Collection<FutureTransactionDto> futureTransactions) {
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
        this.futureTransactions = futureTransactions;
    }

    public ItemDto() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @JsonbTypeDeserializer(BigDecimalDeserializer.class)
    @JsonbTypeSerializer(BigDecimalSerializer.class)
    public BigDecimal getPrice() {
        return price;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @JsonbTypeDeserializer(BigDecimalDeserializer.class)
    @JsonbTypeSerializer(BigDecimalSerializer.class)
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonbProperty("isChecked")
    public boolean isChecked() {
        return isChecked;
    }

    @JsonbProperty("isChecked")
    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @JsonbProperty("isPrivate")
    public boolean isPrivate() {
        return isPrivate;
    }

    @JsonbProperty("isPrivate")
    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @JsonbProperty("isShared")
    public boolean isShared() {
        return isShared;
    }

    @JsonbProperty("isShared")
    public void setShared(boolean shared) {
        isShared = shared;
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
                Objects.equals(this.futureTransactions, entity.futureTransactions) &&
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
                "futureTransactions = " + futureTransactions + ", " +
                "categoryName = " + categoryName + ")";
    }

    public Collection<FutureTransactionDto> getFutureTransactions() {
        return futureTransactions;
    }

    public void setFutureTransactions(Collection<FutureTransactionDto> futureTransactions) {
        this.futureTransactions = futureTransactions;
    }
}
