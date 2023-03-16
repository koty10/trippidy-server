package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.UserProfile;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link UserProfile} entity
 */
public class UserProfileDto implements Serializable {
    private String id;
    private String firstname;
    private String lastname;
    private Collection<MemberDto> members;

    public UserProfileDto(String id, String firstname, String lastname, Collection<MemberDto> members) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.members = members;
    }

    public UserProfileDto() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMembers(Collection<MemberDto> members) {
        this.members = members;
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