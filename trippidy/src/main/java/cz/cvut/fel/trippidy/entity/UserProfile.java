package cz.cvut.fel.trippidy.entity;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = UserProfile.FIND_BY_ID, query = "select u from UserProfile u where u.id = :userId"),
        @NamedQuery(name = UserProfile.FIND_BY_QUERY, query = "SELECT u FROM UserProfile u WHERE LOWER(CONCAT(u.firstname, ' ', u.lastname)) LIKE LOWER(:query) AND u.id <> :userId"),
})
public class UserProfile {
    public static final String FIND_BY_ID = "UserProfile.findById";
    public static final String FIND_BY_QUERY = "UserProfile.findByQuery";
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "firstname", nullable = false, length = 128)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = 128)
    private String lastname;

    @Basic
    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Basic
    @Column(name = "image", nullable = false, length = 1024)
    private String image;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private Collection<Member> members;

    @Basic
    @Column(name = "bankAccountNumber", nullable = false, length = 128)
    private String bankAccountNumber;

    @Basic
    @Column(name = "iban", nullable = false, length = 128)
    private String iban;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    public Collection<Member> getMembers() {
        return members;
    }

    public void setMembers(Collection<Member> members) {
        this.members = members;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
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
