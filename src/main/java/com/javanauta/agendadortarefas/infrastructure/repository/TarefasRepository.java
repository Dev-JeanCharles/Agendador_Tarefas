package com.javanauta.agendadortarefas.infrastructure.repository;

import com.javanauta.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefas.infrastructure.entity.enums.StatusNotificacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity> findByDataEventoBetweenAndStatus(LocalDateTime dataInicial, LocalDateTime dataFinal, StatusNotificacao status);

    List<TarefasEntity> findByEmail(String email);
}
