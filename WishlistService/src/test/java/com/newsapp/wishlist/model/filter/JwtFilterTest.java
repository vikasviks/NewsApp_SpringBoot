//package com.newsapp.wishlist.model.filter;
//
//
//import com.newsapp.wishlist.filter.JwtFilter;
//import jakarta.servlet.ServletException;
//import org.junit.jupiter.api.Test;
//import org.springframework.mock.web.MockFilterChain;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpServletResponse;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class JwtFilterTest {
//
//    @Test
//    void testDoFilterWithMissingAuthorizationHeader() {
//        // Arrange
//        JwtFilter jwtFilter = new JwtFilter();
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        MockFilterChain filterChain = new MockFilterChain();
//
//        // Act & Assert
//        assertThrows(ServletException.class, () -> jwtFilter.doFilter(request, response, filterChain));
//    }
//
//    @Test
//    void testDoFilterWithInvalidToken() {
//        // Arrange
//        JwtFilter jwtFilter = new JwtFilter();
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        MockFilterChain filterChain = new MockFilterChain();
//
//        // Assuming you have an invalid token for testing
//        String invalidToken = "Bearer invalidToken";
//        request.addHeader("Authorization", invalidToken);
//
//        // Act & Assert
//        assertThrows(io.jsonwebtoken.MalformedJwtException.class, () -> jwtFilter.doFilter(request, response, filterChain));
//    }
//
//}
