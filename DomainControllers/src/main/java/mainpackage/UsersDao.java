package mainpackage;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */

public interface UsersDao extends GenericDao<User> {
    List<User> getUsersByName(String userName);
}
