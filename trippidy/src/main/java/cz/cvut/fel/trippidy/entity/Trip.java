package cz.cvut.fel.trippidy.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = Trip.FIND_BY_USER_PROFILE_ID, query = "select distinct t from Trip t join t.members m join m.userProfile u left join m.items i left join i.category c where u.id = :userId"),
}
)
public class Trip {
    public static final String FIND_BY_USER_PROFILE_ID = "Trip.findByUserProfileId";
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Basic
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Collection<Member> members = new ArrayList<>();

    @Column(name = "date_from")
    private LocalDateTime dateFrom;

    @Column(name = "date_to")
    private LocalDateTime dateTo;

    @Basic
    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Collection<CompletedTransaction> completedTransactions;

    public Trip() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id && Objects.equals(name, trip.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<Member> getMembers() {
        return members;
    }

    public void setMembers(Collection<Member> members) {
        this.members = members;
    }

    public Collection<CompletedTransaction> getCompletedTransactions() {
        return completedTransactions;
    }

    public void setCompletedTransactions(Collection<CompletedTransaction> completedTransactions) {
        this.completedTransactions = completedTransactions;
    }
}
