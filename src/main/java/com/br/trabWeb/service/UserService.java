package com.br.trabWeb.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getTokenFromUser() throws Exception {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // Verifica se a autenticação está presente e se o principal (usuário) está presente
            if (authentication != null && authentication.getPrincipal() != null) {
                return authentication.getName();
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
