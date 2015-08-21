package mainpackage;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lrelovsky on 21.08.2015.
 */
@Entity
@Table
@SequenceGenerator(name = "generator", sequenceName = "SEQ_VOTES")
public class Votes extends BaseEntity {

    @Column(name = "time_to", nullable = false)
    private Date timeTo;
    @Column(name = "time_from", nullable = false)
    private Date timeFrom;

    @Column(name = "adding_time", nullable = false)
    private Date addingTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_fk")
    private Restaurant restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    private Users user;

}
