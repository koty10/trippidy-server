package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.FutureTransaction;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link FutureTransaction}
 */
public class FutureTransactionDto implements Serializable {
    private final String id;
    private final String payerId;
    private final String payeeId;
    private final String itemId;
    private final String itemName;
    private final boolean itemIsChecked;
    private final int itemAmount;
    private final boolean itemIsPrivate;
    private final boolean itemIsShared;
    private final int itemPrice;

    public FutureTransactionDto(String id, String payerId, String payeeId,
                                String itemId,
                                String itemName,
                                boolean itemIsChecked,
                                int itemAmount,
                                boolean itemIsPrivate,
                                boolean itemIsShared,
                                int itemPrice) {
        this.id = id;
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemIsChecked = itemIsChecked;
        this.itemAmount = itemAmount;
        this.itemIsPrivate = itemIsPrivate;
        this.itemIsShared = itemIsShared;
        this.itemPrice = itemPrice;
    }

    public String getId() {
        return id;
    }

    public String getPayerId() {
        return payerId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FutureTransactionDto entity = (FutureTransactionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.payerId, entity.payerId) &&
                Objects.equals(this.payeeId, entity.payeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payerId, payeeId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "payerId = " + payerId + ", " +
                "payeeId = " + payeeId + ")";
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isItemIsChecked() {
        return itemIsChecked;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public boolean isItemIsPrivate() {
        return itemIsPrivate;
    }

    public boolean isItemIsShared() {
        return itemIsShared;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}