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
    private String image;
    private Collection<MemberDto> members;
    private String bankAccountNumber;
    private String iban;
    private String email;

    public UserProfileDto(String id, String firstname, String lastname, String image, Collection<MemberDto> members,
                          String bankAccountNumber,
                          String iban,
                          String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.members = members;
        this.bankAccountNumber = bankAccountNumber;
        this.iban = iban;
        this.email = email;
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

    public String getImage() {
        return image;
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

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDto entity = (UserProfileDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstname, entity.firstname) &&
                Objects.equals(this.lastname, entity.lastname) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.image, entity.image) &&
                Objects.equals(this.members, entity.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, image, members, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstname = " + firstname + ", " +
                "lastname = " + lastname + ", " +
                "email = " + email + ", " +
                "image = " + image + ", " +
                "members = " + members + ")";
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}