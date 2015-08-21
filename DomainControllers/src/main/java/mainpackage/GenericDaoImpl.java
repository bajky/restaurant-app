package mainpackage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by lrelovsky on 18.08.2015.
 */

@Transactional
public abstract class GenericDaoImpl<T extends BaseEntity> implements GenericDao<T> {


    @PersistenceContext(unitName = "restaurant-db")
    protected EntityManager entityManager;
    protected Class<T> thisClass;


    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        thisClass = (Class) pt.getActualTypeArguments()[0];

    }

    @Override
    public T findById(long id) {
        return entityManager.find(thisClass, id);
    }

    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void updateObject(T object) {
        entityManager.merge(object);
    }

    public void deleteObject(T object) {
        entityManager.remove(object);
    }

}
