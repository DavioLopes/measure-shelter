package com.agrotechfields.measureshelter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agrotechfields.measureshelter.dto.ListaMedicoesDto;
import com.agrotechfields.measureshelter.dto.MedicaoDto;
import com.agrotechfields.measureshelter.model.Medicao;
import com.agrotechfields.measureshelter.service.MedicaoService;


@RestController
public class MedicaoController {
  
  @Autowired
  private MedicaoService medicaoService;

  @PostMapping("/ilhas/{ilhaId}/medicoes")
  public ResponseEntity<MedicaoDto> cadastrar(@PathVariable String ilhaId, @RequestBody Medicao medicao) {
    MedicaoDto medicaoDto = medicaoService.cadastrar(ilhaId, medicao);
    
    return ResponseEntity.status(201).body(medicaoDto);
  }

  @GetMapping("/medicoes")
  public ResponseEntity<List<ListaMedicoesDto>> listar() {
    List<ListaMedicoesDto> medicoesDto = medicaoService.listar();
    
    return ResponseEntity.ok(medicoesDto);
  }

  @GetMapping("/ilhas/{ilhaId}/medicoes")
  public ResponseEntity<ListaMedicoesDto> listarMedicoesPorIlha(@PathVariable String ilhaId) {
    ListaMedicoesDto medicoesDto = medicaoService.listaMedicoesPorIlha(ilhaId);
    
    return ResponseEntity.ok(medicoesDto);
  }

  @GetMapping("/ilhas/{ilhaId}/medicoes/{id}")
  public ResponseEntity<MedicaoDto> buscaMedicaoPorId(@PathVariable("ilhaId") String ilhaId, 
    @PathVariable("id") int id) {

    MedicaoDto medicaoDto = medicaoService.buscaporId(ilhaId, id);
    
    return ResponseEntity.ok(medicaoDto);
  }

  @PutMapping("/ilhas/{ilhaId}/medicoes/{id}")
  public ResponseEntity<MedicaoDto> buscaMedicaoPorId(@PathVariable("ilhaId") String ilhaId, 
    @PathVariable("id") int id, @RequestBody Medicao medicao) {

    MedicaoDto medicoesDto = medicaoService.atualizar(ilhaId, id, medicao);
    
    return ResponseEntity.ok(medicoesDto);
  } 
}
