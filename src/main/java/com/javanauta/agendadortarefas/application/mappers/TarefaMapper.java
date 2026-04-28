package com.javanauta.agendadortarefas.application.mappers;

import com.javanauta.agendadortarefas.application.dto.TarefasDTORecord;
import com.javanauta.agendadortarefas.domain.model.Tarefa;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    Tarefa dtoParaDomain(TarefasDTORecord dto);

    TarefasDTORecord domainParaDTO(Tarefa tarefa);

    List<Tarefa> listaDtoParaDomain(List<TarefasDTORecord> dtos);

    List<TarefasDTORecord> listaDomainParaDto(List<Tarefa> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizaDomain(TarefasDTORecord dto, @MappingTarget Tarefa entity);

}
