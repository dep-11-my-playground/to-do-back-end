package lk.ijse.dep11.todoapp.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CorsFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

            List<String> origins = List.of("http://127.0.0.1:5500", "http://localhost:1234");
            String origin = req.getHeader("Origin");
            if (origin != null && origins.stream().anyMatch(o -> o.equalsIgnoreCase(origin) )){
                res.setHeader("Access-Control-Allow-Origin", origin);
            }

            String method = req.getMethod();
            if (method.equalsIgnoreCase("OPTIONS")){
                res.setHeader("Access-Control-Allow-Headers", "Content-Type");
                res.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, PATCH, DELETE");
            }
        chain.doFilter(req, res);
    }

}
