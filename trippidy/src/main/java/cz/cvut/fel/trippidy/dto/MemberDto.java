package cz.cvut.fel.trippidy.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link cz.cvut.fel.trippidy.model.Member} entity
 */
public class MemberDto implements Serializable {
    private final int id;
    private final String role;
    private final boolean accepted;
    private final Collection<ItemDto> items;
    private final int tripTripId;
    private final String userProfileUserProfileId;
    private final String userProfileFirstname;
    private final String userProfileLastname;

    public MemberDto(int id, String role, boolean accepted, Collection<ItemDto> items, int tripTripId, String userProfileUserProfileId, String userProfileFirstname, String userProfileLastname) {
        this.id = id;
        this.role = role;
        this.accepted = accepted;
        this.items = items;
        this.tripTripId = tripTripId;
        this.userProfileUserProfileId = userProfileUserProfileId;
        this.userProfileFirstname = userProfileFirstname;
        this.userProfileLastname = userProfileLastname;
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

    public int getTripTripId() {
        return tripTripId;
    }

    public String getUserProfileUserProfileId() {
        return userProfileUserProfileId;
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
                Objects.equals(this.tripTripId, entity.tripTripId) &&
                Objects.equals(this.userProfileUserProfileId, entity.userProfileUserProfileId) &&
                Objects.equals(this.userProfileFirstname, entity.userProfileFirstname) &&
                Objects.equals(this.userProfileLastname, entity.userProfileLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, accepted, items, tripTripId, userProfileUserProfileId, userProfileFirstname, userProfileLastname);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "role = " + role + ", " +
                "accepted = " + accepted + ", " +
                "items = " + items + ", " +
                "tripTripId = " + tripTripId + ", " +
                "userProfileUserProfileId = " + userProfileUserProfileId + ", " +
                "userProfileFirstname = " + userProfileFirstname + ", " +
                "userProfileLastname = " + userProfileLastname + ")";
    }
}