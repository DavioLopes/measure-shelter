package com.agrotechfields.measureshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrotechfields.measureshelter.dto.MedicaoDto;
import com.agrotechfields.measureshelter.model.Medicao;
import com.agrotechfields.measureshelter.service.MedicaoService;

@RequestMapping("/ilhas/{ilhaId}/medicoes")
@RestController
public class MedicaoController {
  
  @Autowired
  private MedicaoService medicaoService;

  @PostMapping
  public ResponseEntity<MedicaoDto> cadastrar(@PathVariable String ilhaId, @RequestBody Medicao medicao) {
    MedicaoDto medicaoDto = medicaoService.cadastrar(ilhaId, medicao);
    return ResponseEntity.status(201).body(medicaoDto);
  }
}
