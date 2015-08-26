package mainpackage;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lrelovsky on 21.08.2015.
 */
@Entity
@Table
@SequenceGenerator(name = "generator", sequenceName = "SEQ_VOTES")
@NamedQuery(name = Votes.SELECT_VOTES_BY_USERS, query = "SELECT new mainpackage.VotesVO(v.timeFrom, v.restaurant.tittle)" +
        " FROM Votes v WHERE v.user.id = :userID")
public class Votes extends BaseEntity {
    public static final String SELECT_VOTES_BY_USERS = "Votes.SELECT_VOTES_BY_USERS";

    @Column(name = "time_to", nullable = false)
    private Date timeTo;
    @Column(name = "time_from", nullable = false)
    private Date timeFrom;

    @Column(name = "adding_time", nullable = false)
    private Date addingTime;

    public User getUser() {
        return user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_fk")
    private Restaurant restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(Date addingTime) {
        this.addingTime = addingTime;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Date getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Date timeTo) {
        this.timeTo = timeTo;
    }



}
