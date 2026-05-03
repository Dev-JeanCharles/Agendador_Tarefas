package com.javanauta.agendadortarefas.adapters.in.controller;

import com.javanauta.agendadortarefas.application.dto.TarefasDTORecord;
import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;
import com.javanauta.agendadortarefas.domain.ports.in.TarefaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefaUseCase tarefaUseCase;

    @PostMapping
    public ResponseEntity<TarefasDTORecord> criarTarefa(@RequestBody TarefasDTORecord dto,
                                                  @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaUseCase.gravarTarefas(token, dto));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTORecord>> buscaListaTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

        return ResponseEntity.ok(tarefaUseCase.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDTORecord>> buscaTarefaPorEmail(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaUseCase.buscaTarefaPorEmail(token));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id) {
        tarefaUseCase.deletaTarefaPorId(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefasDTORecord> alteraStatusNotificacao(@RequestParam("status") StatusNotificacao status,
                                                              @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefaUseCase.alteraStatus(status, id));
    }

    @PutMapping
    public ResponseEntity<TarefasDTORecord> atualizaTarefas(@RequestBody TarefasDTORecord dto,
                                                      @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefaUseCase.atualizaTarefas(dto, id));
    }
}
