package cz.cvut.fel.trippidy.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "completed_transaction")
public class CompletedTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "payer_id_fk", referencedColumnName = "id", nullable = false)
    private Member payer;

    @ManyToOne
    @JoinColumn(name = "payee_id_fk", referencedColumnName = "id", nullable = false)
    private Member payee;

    @ManyToOne
    @JoinColumn(name = "trip_id_fk", referencedColumnName = "id", nullable = false)
    private Trip trip;

    @Basic
    @Column(name = "price", nullable = false)
    private BigDecimal amount = BigDecimal.ZERO;

    private boolean canceled;

    public Member getPayer() {
        return payer;
    }

    public void setPayer(Member payer) {
        this.payer = payer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Member getPayee() {
        return payee;
    }

    public void setPayee(Member payee) {
        this.payee = payee;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompletedTransaction that = (CompletedTransaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
