package mainpackage;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lrelovsky on 21.08.2015.
 */

@Entity
@Table(name = "Users")
@SequenceGenerator(name = "generator", sequenceName = "SEQ_USERS")
@NamedQuery(name = "getUsersByName", query = "SELECT u FROM User u  WHERE u.firstName = :userName")
public class User extends BaseEntity{

    public User() {
        this.comments = new HashSet<>();
        this.votes = new HashSet<>();
    }

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "acc_name", nullable = false)
    private String acountName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, name = "is_banned")
    private boolean isBanned;
    @Column(nullable = false, name = "id_active")
    private boolean isActive;

    @OneToMany(mappedBy = "user")
    private Set<Comments> comments;

    @ManyToMany(mappedBy = "user")
    private Set<Votes> votes;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAcountName() {
        return acountName;
    }

    public void setAcountName(String acountName) {
        this.acountName = acountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public Set<Votes> getVotes() {
        return votes;
    }

    public void setVotes(Set<Votes> votes) {
        this.votes = votes;
    }

    public void addComment(Comments comment){
        this.comments.add(comment);
    }
    public void addVote(Votes vote){
        this.votes.add(vote);
    }

}
