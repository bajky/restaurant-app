package mainpackage;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lrelovsky on 20.08.2015.
 */

@Entity
@Table(name = "R_MENU")
@SequenceGenerator(name = "generator", sequenceName = "SEQ_R_MENU")
public class Menu extends BaseEntity {

    public Menu() {
        foods = new HashSet<>();
    }

    @Column
    private Short day;

    @Column
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "menu")
    private Set<Food> foods;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "r_restaurant_fk")
    private Restaurant restaurant;

    public Short getDay() {
        return day;
    }

    public void setDay(Short day) {
        this.day = day;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        foods = foods;
    }

    public void addFood(Food food){
        foods.add(food);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;

        Menu menu = (Menu) o;

        if (foods != null ? !foods.equals(menu.foods) : menu.foods != null) return false;
        if (!day.equals(menu.day)) return false;
        if (!price.equals(menu.price)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = day.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + (foods != null ? foods.hashCode() : 0);
        return result;
    }
}
