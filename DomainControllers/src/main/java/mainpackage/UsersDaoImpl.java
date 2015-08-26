package mainpackage;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */
@Repository
public class UsersDaoImpl extends GenericDaoImpl<User> implements UsersDao {

    @Override
    public List<User> getUsersByName(String userName) {
        return super.entityManager.createNamedQuery("getUsersByName")
                .setParameter("userName", userName)
                .getResultList();
    }
}
