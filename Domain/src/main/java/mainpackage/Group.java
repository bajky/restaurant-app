package mainpackage;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by lrelovsky on 21.08.2015.
 */

@Entity
@Table(name = "R_GROUP")
@SequenceGenerator(name = "generator", sequenceName = "SEQ_R_GROUP")
public class Group extends BaseEntity{

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 1000)
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", nullable = false)
    private Date createdTime;
    @Column(name = "creator",nullable = false, length = 30)
    private String creatorName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "User_Group", joinColumns = {
            @JoinColumn(name = "r_group_fk",nullable = false)
    }, inverseJoinColumns = @JoinColumn(name = "r_user_fk", nullable = false))
    private Set<User> users;




}
