package mainpackage;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */
@Repository
public class RestaurantDaoImpl extends GenericDaoImpl<Restaurant> implements RestaurantDao{
    @Override
    public List<Restaurant> getAllRestaurants() {
        return super.entityManager.createNamedQuery("allRestaurants").getResultList();
    }
}
