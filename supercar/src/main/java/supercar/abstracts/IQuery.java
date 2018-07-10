/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.abstracts;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Maxi
 * @param <T>
 * I know this is not really abstract, but idk where to put it otherwise yet
 */
public class IQuery<T extends IUniqueEntity> {

    TypedQuery<T> query;
    String sql;

    public IQuery(EntityManager em, String sql, Class<T> entityClass, String table) {
        this.sql = sql.replace("#table", table);
        this.query = em.createQuery(this.sql, entityClass);
    }

    public IQuery<T> put(String name, Object value) {
        this.sql = sql.replace(":" + name, "\"" + value.toString() + "\"");
        this.query.setParameter(name, value);
        return this;
    }

    public T one() {
        try {
            System.out.println("SQL: " + sql);
            return query.getSingleResult();
        }
        catch (Exception ex) {
            System.out.println("SQL: " + ex);
            return null;
        }
    }

    public Collection<T> all() {
        try {
            System.out.println("SQL: " + sql);
            return query.getResultList();
        }
        catch (Exception ex) {
            System.out.println("SQL: " + ex);
            return new ArrayList<>();
        }
    }

    public int execute() {
        try {
            System.out.println("SQL: " + sql);
            return query.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println("SQL: " + ex);
            return -1;
        }
    }

 }