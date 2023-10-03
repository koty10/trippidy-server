package cz.cvut.fel.trippidy.entity;

import javax.persistence.*;

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
    @JoinColumn(name = "payee_id_fk", referencedColumnName = "id", nullable = false)
    private Member payee;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Member getPayee() {
        return payee;
    }

    public void setPayee(Member payee) {
        this.payee = payee;
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

}