package mainpackage;

import javax.persistence.*;

/**
 * Created by lrelovsky on 21.08.2015.
 */

@Table
@Entity
@SequenceGenerator(name = "generator", sequenceName = "SEQ_COMMENTS")
public class Comments extends BaseEntity {

    @Column(nullable =  false)
    private String text;
    @Column(name = "is_visible", nullable = false)
    private boolean isVisible;
    @Column(name = "adding_time", nullable = false)
    private Long addedTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_fk")
    Restaurant restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    Users user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Long getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Long addedTime) {
        this.addedTime = addedTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
