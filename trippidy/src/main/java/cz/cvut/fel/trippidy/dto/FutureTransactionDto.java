package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.FutureTransaction;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link FutureTransaction}
 */
public class FutureTransactionDto implements Serializable {
    private String id;
    private String payerId;
    private String itemId;

    public FutureTransactionDto(String id, String payerId, String itemId) {
        this.id = id;
        this.payerId = payerId;
        this.itemId = itemId;
    }

    public FutureTransactionDto() {}

    public String getId() {
        return id;
    }

    public String getPayerId() {
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

    public String getItemId() {
        return itemId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }
}