package mainpackage;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */
public interface RestaurantDao extends GenericDao<Restaurant> {
    List<Restaurant> getAllRestaurants();
}
