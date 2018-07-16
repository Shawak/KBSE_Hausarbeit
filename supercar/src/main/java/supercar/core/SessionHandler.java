/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Patrick
 */
@ApplicationScoped
public class SessionHandler {

    private static final Map<Long, HttpSession> logins = new ConcurrentHashMap<>();

    public static void deleteSession(Long id) {
        HttpSession session = logins.get(id);
        if (session != null) {
            logins.remove(id);
            session.invalidate();
        }
    }
    
     public static void removeSession(Long id){
        HttpSession session =logins.get(id);
        if(session!=null){
            logins.remove(id); 
        }
    }
    
    public static void put(Long id, HttpSession session){
        HttpSession session_old =logins.get(id);
        
        logins.put(id, session);
    }

}
