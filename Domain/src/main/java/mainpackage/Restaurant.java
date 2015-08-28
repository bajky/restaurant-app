package mainpackage;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lrelovsky on 17.08.2015.
 */

@Entity
@Table(name = "R_RESTAURANT")
@SequenceGenerator(name = "generator" , sequenceName = "SEQ_R_RESTAURANT")
@NamedQuery(name = "allRestaurants", query = "SELECT r FROM Restaurant r")
public class Restaurant extends BaseEntity{

    public Restaurant() {
        this.menuSet = new HashSet<>();
    }

    @Column(nullable = false, length = 35)
    private String tittle;

    @Column(name= "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 30)
    private String web;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String Type;

    @Column
    private String description;

    @OneToMany(mappedBy = "restaurant")
    private Set<Menu> menuSet;

    @OneToMany(mappedBy = "restaurant")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "restaurant")
    private Set<Vote> votes;

    public void addMenu(Menu menu){
        menuSet.add(menu);
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (!getTittle().equals(that.getTittle())) return false;
        if (!getPhoneNumber().equals(that.getPhoneNumber())) return false;
        if (getWeb() != null ? !getWeb().equals(that.getWeb()) : that.getWeb() != null) return false;
        if (!getAddress().equals(that.getAddress())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        if (!getType().equals(that.getType())) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        return !(getMenuSet() != null ? !getMenuSet().equals(that.getMenuSet()) : that.getMenuSet() != null);

    }

    @Override
    public int hashCode() {
        int result = getTittle().hashCode();
        result = 31 * result + getPhoneNumber().hashCode();
        result = 31 * result + (getWeb() != null ? getWeb().hashCode() : 0);
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getMenuSet() != null ? getMenuSet().hashCode() : 0);
        return result;
    }
}
