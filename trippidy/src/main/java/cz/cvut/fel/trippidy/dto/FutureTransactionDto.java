package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.FutureTransaction;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link FutureTransaction}
 */
public class FutureTransactionDto implements Serializable {
    private UUID id;
    private UUID payerId;
    private UUID itemId;

    public FutureTransactionDto(UUID id, UUID payerId, UUID itemId) {
        this.id = id;
        this.payerId = payerId;
        this.itemId = itemId;
    }

    public FutureTransactionDto() {}

    public UUID getId() {
        return id;
    }

    public UUID getPayerId() {
        return payerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FutureTransactionDto entity = (FutureTransactionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.payerId, entity.payerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payerId);
    }

    @Override
    public String toString() {
        return "FutureTransactionDto{" +
                "id='" + id + '\'' +
                ", payerId='" + payerId + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public void setPayerId(UUID payerId) {
        this.payerId = payerId;
    }
}