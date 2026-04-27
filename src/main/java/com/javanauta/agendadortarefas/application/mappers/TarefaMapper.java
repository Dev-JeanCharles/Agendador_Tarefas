package com.javanauta.agendadortarefas.application.mappers;

import com.javanauta.agendadortarefas.application.dto.TarefasDTO;
import com.javanauta.agendadortarefas.domain.model.Tarefa;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    Tarefa dtoParaDomain(TarefasDTO dto);

    TarefasDTO domainParaDTO(Tarefa tarefa);

    List<Tarefa> listaDtoParaDomain(List<TarefasDTO> dtos);

    List<TarefasDTO> listaDomainParaDto(List<Tarefa> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizaDomain(TarefasDTO dto, @MappingTarget Tarefa entity);

}
