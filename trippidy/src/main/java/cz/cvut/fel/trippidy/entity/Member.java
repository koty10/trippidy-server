package cz.cvut.fel.trippidy.entity;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "role", nullable = false, length = 64)
    private String role;
    @Basic
    @Column(name = "accepted", nullable = false)
    private boolean accepted;
    @OneToMany(mappedBy = "member")
    private Collection<Item> items;
    @ManyToOne
    @JoinColumn(name = "trip_id_fk", referencedColumnName = "id", nullable = false)
    private Trip trip;
    @ManyToOne
    @JoinColumn(name = "user_id_fk", referencedColumnName = "id", nullable = false)
    private UserProfile userProfile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id && accepted == member.accepted && Objects.equals(role, member.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, accepted);
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
