package mainpackage;



import javax.persistence.*;

/**
 * Created by lrelovsky on 18.08.2015.
 */

@Entity
@Table(name = "Food")
@SequenceGenerator(name = "generator",sequenceName = "SEQ_FOOD", allocationSize = 1)
public class Food extends BaseEntity{



    @Column(nullable = false, length = 20)
    private String tittle;
    @Column(nullable = true, length = 1000)
    private String description;
    @Column(nullable = false, length = 10)
    private String type;
    @Column(nullable = false, length = 5, precision = 2)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "menu_fk")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        if (id != null ? !id.equals(this.id) : this.id != null) return false;

        if (!description.equals(food.description)) return false;
        if (!price.equals(food.price)) return false;
        if (!tittle.equals(food.tittle)) return false;
        if (!type.equals(food.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tittle.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
