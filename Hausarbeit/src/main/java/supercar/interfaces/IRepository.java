/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maxi
 * @param <T>
 */
@ApplicationScoped
public abstract class IRepository<T extends IUniqueEntity> implements Serializable {
    
    @PersistenceContext(unitName="supercarPU")
    protected EntityManager em;
    protected Class<T> type;
    
    /*  -- Prof of concept of the following implementation
        import java.lang.reflect.ParameterizedType;

        public class HelloWorld{
            public static void main(String[] args) {
                new Repo().print();
            }
        }

        abstract class IEntity { }
        class Entity extends IEntity { }
        class Repo extends IRepo<Entity> { }

        abstract class IRepo<T extends IEntity> {
          Class<T> type;
          public IRepo() {
                this.type = (Class<T>)
                    ((ParameterizedType)getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
          }
          public void print() {	System.out.println(this.type.getName()); }
        }
    */
    
    public IRepository() {
        this.type = (Class<T>)
            ((ParameterizedType)getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
    
    public void add(T entity) {
        em.persist(entity);
    }
    
    public T get(long id) {
        return (T)em.find(this.type, id);
    }
    
    public void remove(T entity) {
        em.remove(entity);
    }
    
    public T update(T entity) {
        return em.merge(entity);
    }
    
    public Collection<T> all() {
        return em.createQuery("select e from " + this.type.getSimpleName() + " e").getResultList();
    }
    
}
