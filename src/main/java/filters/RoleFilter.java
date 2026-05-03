package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Roles;
import entities.User;

@WebFilter("/produits/*")
public class RoleFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        boolean isAdmin = user.getRole() == Roles.ADMIN;
        String[] parts = req.getRequestURI().split("/");
        if (parts.length == 4){
        String action = parts[3];
        switch (action) {
            case "edit", "add", "update", "delete" -> {
                if (isAdmin) {
                    chain.doFilter(request, response);
                    return;
                } else {
                    resp.sendRedirect(req.getContextPath() + "/produits/list");
                    return;
                }
            }
            default -> chain.doFilter(request, response);
        }
        }
    }
        
    @Override
    public void destroy() {
    }
}