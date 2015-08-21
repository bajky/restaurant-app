package mainpackage;


/**
 * Created by lrelovsky on 18.08.2015.
 */
public interface GenericDao<T extends BaseEntity> {

    T findById(long id);

    T create(T entity);

    void updateObject(T object);

    void deleteObject(T object);
}
