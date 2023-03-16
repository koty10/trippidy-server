package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.Member;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link Member} entity
 */
public class MemberDto implements Serializable {
    private int id;
    private String role;
    private boolean accepted;
    private Collection<ItemDto> items;
    private int tripId;
    private String userProfileId;
    private String userProfileFirstname;
    private String userProfileLastname;

    public MemberDto(int id, String role, boolean accepted, Collection<ItemDto> items, int tripId, String userProfileId, String userProfileFirstname, String userProfileLastname) {
        this.id = id;
        this.role = role;
        this.accepted = accepted;
        this.items = items;
        this.tripId = tripId;
        this.userProfileId = userProfileId;
        this.userProfileFirstname = userProfileFirstname;
        this.userProfileLastname = userProfileLastname;
    }

    public MemberDto() {
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public boolean getAccepted() {
        return accepted;
    }

    public Collection<ItemDto> getItems() {
        return items;
    }

    public int getTripId() {
        return tripId;
    }

    public String getUserProfileId() {
        return userProfileId;
    }

    public String getUserProfileFirstname() {
        return userProfileFirstname;
    }

    public String getUserProfileLastname() {
        return userProfileLastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto entity = (MemberDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.role, entity.role) &&
                Objects.equals(this.accepted, entity.accepted) &&
                Objects.equals(this.items, entity.items) &&
                Objects.equals(this.tripId, entity.tripId) &&
                Objects.equals(this.userProfileId, entity.userProfileId) &&
                Objects.equals(this.userProfileFirstname, entity.userProfileFirstname) &&
                Objects.equals(this.userProfileLastname, entity.userProfileLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, accepted, items, tripId, userProfileId, userProfileFirstname, userProfileLastname);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "role = " + role + ", " +
                "accepted = " + accepted + ", " +
                "items = " + items + ", " +
                "tripId = " + tripId + ", " +
                "userProfileId = " + userProfileId + ", " +
                "userProfileFirstname = " + userProfileFirstname + ", " +
                "userProfileLastname = " + userProfileLastname + ")";
    }
}