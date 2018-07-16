/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.abstracts;

import java.io.IOException;
import java.util.function.Supplier;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maxi
 * http://www.catgovind.com/jsf/jsf-login-logout-form-authentication-example/
 */
public abstract class IFilter extends IRestrictableRepositoryAccessor implements Filter {

    protected Supplier<Boolean> filter;
<<<<<<< HEAD
    protected String redirect = "index.xhtml";

=======
    protected String redirect = "/";
    
>>>>>>> 57c2740fc24c04c6580f2a7790233597bf3dd0a6
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        LoginHandler.setSession(session);

        if (this.filter.get()) {
            chain.doFilter(request, response);
        } else {
            String needLoginUrl = request.getContextPath() + this.redirect;
            response.sendRedirect(needLoginUrl);
        }
    }

}
