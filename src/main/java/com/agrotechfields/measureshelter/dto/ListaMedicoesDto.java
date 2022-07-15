package com.agrotechfields.measureshelter.dto;

import java.util.List;

import com.agrotechfields.measureshelter.model.Medicao;

public class ListaMedicoesDto {
  private String ilhaId;
  private List<Medicao> medicoes;
  public ListaMedicoesDto(String ilhaId, List<Medicao> medicoes) {
    this.ilhaId = ilhaId;
    this.medicoes = medicoes;
  }
  public String getIlhaId() {
    return ilhaId;
  }
  public void setIlhaId(String ilhaId) {
    this.ilhaId = ilhaId;
  }
  public List<Medicao> getMedicoes() {
    return medicoes;
  }
  public void setMedicoes(List<Medicao> medicoes) {
    this.medicoes = medicoes;
  }
  
}