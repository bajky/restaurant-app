package mainpackage;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by lrelovsky on 21.08.2015.
 */

@Entity
@Table
@SequenceGenerator(name = "generator", sequenceName = "SEQ_USERS")
public class Users extends BaseEntity{

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

}
