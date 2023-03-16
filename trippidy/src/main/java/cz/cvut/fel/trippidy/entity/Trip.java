package cz.cvut.fel.trippidy.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        //@NamedQuery(name = "Trip.findByUserProfileId", query = "select t from Trip t join Member m on t.id = m.trip.id join UserProfile u where u.id = :userId"),
        @NamedQuery(name = Trip.FIND_BY_USER_PROFILE_ID, query = "select m from Member m join UserProfile u on m.userProfile.id = u.id where u.id = :userId"),
        //@NamedQuery(name = Trip.FIND_BY_USER_PROFILE_ID, query = "select m from Member m join UserProfile m.userProfile u where u.id = :userId"),
}
)
public class Trip {
    public static final String FIND_BY_USER_PROFILE_ID = "Trip.findByUserProfileId";
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    @OneToMany(mappedBy = "trip")
    private Collection<Member> members;

    @Column(name = "date_from", nullable = false)
    private LocalDateTime dateFrom;

    @Column(name = "date_to", nullable = false)
    private LocalDateTime dateTo;

    public Trip() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
