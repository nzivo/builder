package com.example.api_gateway.filter;

import com.example.api_gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JwtUtil jwtUtil;

    // The configuration class
    public static class Config {
        // Configuration properties
    }

    // Constructor
    public AuthFilter() {
        super(Config.class);
    }

    // Implement the necessary methods for the filter
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // The filter logic
            if(routeValidator.isSecured.test(exchange.getRequest())) {
                // check if header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Missing authorization header");
                }
                String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                if (token !=null && token.startsWith("Bearer ")) {
                    token = token.substring(7);
                }
                try {
                    jwtUtil.validateToken(token);
                }catch (Exception e) {
                    throw new RuntimeException("Invalid token");
                }
            }
            return chain.filter(exchange);
        };
    }
}
