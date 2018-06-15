/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maxi
 * @param <T>
 * http://workingonbits.com/2011/05/05/effective-pattern-for-data-access-with-jpa/
 */

public abstract class IRepository<T extends IUniqueEntity> implements Serializable {
    
    @PersistenceContext(unitName="supercarPU")
    protected EntityManager em;
    
    protected Class<T> entityClass;
    
    @PostConstruct
    public void init() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }
    
    public void add(T entity) {
        em.persist(entity);
    }
    
    public T get(long id) {
        return (T)em.find(this.entityClass, id);
    }
    
    public void remove(T entity) {
        em.remove(entity);
    }
    
    public T update(T entity) {
        return em.merge(entity);
    }
    
    public Collection<T> all() {
        return em.createQuery("select e from " + this.entityClass.getSimpleName() + " e").getResultList();
    }
    
}
