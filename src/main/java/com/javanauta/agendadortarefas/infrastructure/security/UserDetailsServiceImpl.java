package com.javanauta.agendadortarefas.infrastructure.security;

import com.javanauta.agendadortarefas.application.dto.UsuarioDTORecord;
import com.javanauta.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosUsuario(String email, String token) {
        UsuarioDTORecord usuarioDTORecord = client.buscaUsuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTORecord.email()) // Define o nome de usuário como o e-mail
                .password(usuarioDTORecord.senha()) // Define a senha do usuário
                .build();
    }
}
