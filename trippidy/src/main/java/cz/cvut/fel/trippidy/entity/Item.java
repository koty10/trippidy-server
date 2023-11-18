package cz.cvut.fel.trippidy.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Basic
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @Basic
    @Column(name = "isChecked", nullable = false)
    private boolean isChecked;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "isPrivate", nullable = false)
    private boolean isPrivate;
    @Basic
    @Column(name = "isShared", nullable = false)
    private boolean isShared;
    @Basic
    @Column(name = "price", nullable = false)
    private BigDecimal price = BigDecimal.ZERO;
    @ManyToOne
    @JoinColumn(name = "member_id_fk", referencedColumnName = "id", nullable = false)
    private Member member;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "category_id_fk", referencedColumnName = "id", nullable = false)
    private Category category;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Collection<FutureTransaction> futureTransactions;

    public Item(UUID id, String name, boolean isChecked, int amount, boolean isPrivate, boolean isShared, BigDecimal price, Member member, Category category, Collection<FutureTransaction> futureTransactions) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
        this.amount = amount;
        this.isPrivate = isPrivate;
        this.isShared = isShared;
        this.price = price;
        this.member = member;
        this.category = category;
        this.futureTransactions = futureTransactions;
    }

    public Item() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && isChecked == item.isChecked && amount == item.amount && isPrivate == item.isPrivate && isShared == item.isShared && price == item.price && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isChecked, amount, isPrivate, isShared, price);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<FutureTransaction> getFutureTransactions() {
        return futureTransactions;
    }

    public void setFutureTransactions(Collection<FutureTransaction> futureTransactions) {
        this.futureTransactions = futureTransactions;
    }
}
