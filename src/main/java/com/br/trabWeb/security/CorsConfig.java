// package com.br.trabWeb.security;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// @EnableWebMvc
// public class CorsConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/api/**")
//                 .allowedOrigins("http://localhost:3000") // Replace with your frontend URL
//                 .allowedMethods("GET", "POST", "PUT", "DELETE")
//                 .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization", "Referer")
//                 .allowCredentials(true);
//     }
// }