package cz.cvut.fel.trippidy.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "future_transaction")
public class FutureTransaction {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "payer_id_fk", referencedColumnName = "id", nullable = false)
    private Member payer;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Member getPayer() {
        return payer;
    }

    public void setPayer(Member payer) {
        this.payer = payer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FutureTransaction that = (FutureTransaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
