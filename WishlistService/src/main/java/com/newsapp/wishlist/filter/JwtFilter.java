//package com.newsapp.wishlist.filter;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import java.io.IOException;
//
///* This class implements the custom filter by extending org.springframework.web.filter.GenericFilterBean.
// * Override the doFilter method with ServletRequest, ServletResponse and FilterChain.
// * This is used to authorize the API access for the application.
// */
//@Component
//public class JwtFilter extends GenericFilterBean {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        //expects the token to come from the header
//        final String authHeader = request.getHeader("Authorization");
//        if(request.getMethod().equals("OPTIONS")){
//            //if the method is options the request can pass through not validation of token is required
//            response.setStatus(HttpServletResponse.SC_OK);
//            filterChain.doFilter(request,response);
//        }
//        else if(authHeader == null || !authHeader.startsWith("Bearer "))
//        {
//            throw new ServletException("Missing or Invalid Token");
//        }
//        //extract token from the header
//        String token = authHeader.substring(7);//Bearer => 6+1 = 7, since token begins with Bearer
//
//        //token validation
//        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
//        request.setAttribute("claims",claims);
//
//        //pass the claims in the request, anyone wanting to
//
//        filterChain.doFilter(request,response);
//    }
//}
