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

/**
 *
 * @author Maxi
 * http://www.catgovind.com/jsf/jsf-login-logout-form-authentication-example/
 */
public abstract class IFilter extends IRestrictableRepositoryAccessor implements Filter {
    
    protected Supplier<Boolean> filter;
    protected String redirect = "/";
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        
        if (this.filter.get()) {
            chain.doFilter(request, response);
        } else {
            String needLoginUrl = request.getContextPath() + this.redirect;
            response.sendRedirect(needLoginUrl);
        }
    }
    
}
