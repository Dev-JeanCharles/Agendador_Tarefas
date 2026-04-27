package com.javanauta.agendadortarefas.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTO {
    private String email;
    private String senha;
}
