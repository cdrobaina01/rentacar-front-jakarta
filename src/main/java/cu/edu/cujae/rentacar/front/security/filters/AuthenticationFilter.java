package cu.edu.cujae.rentacar.front.security.filters;

import cu.edu.cujae.rentacar.front.security.view.AuthenticationManager;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/faces/*"})
public class AuthenticationFilter implements Filter {
    @Inject
    private AuthenticationManager authenticationManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String loginPage = "/faces/security/login.faces";
        if (!authenticationManager.isUserLogged() && !request.getRequestURI().equals(request.getContextPath() + loginPage)) {
            authenticationManager.setActualPage(request.getRequestURI());
            response.sendRedirect(request.getContextPath() + "/faces/security/login.faces");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
