package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.model.UserProfile;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link UserProfile} entity
 */
public class UserProfileDto implements Serializable {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final Collection<MemberDto> members;

    public UserProfileDto(String id, String firstname, String lastname, Collection<MemberDto> members) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Collection<MemberDto> getMembers() {
        return members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDto entity = (UserProfileDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstname, entity.firstname) &&
                Objects.equals(this.lastname, entity.lastname) &&
                Objects.equals(this.members, entity.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, members);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstname = " + firstname + ", " +
                "lastname = " + lastname + ", " +
                "members = " + members + ")";
    }
}