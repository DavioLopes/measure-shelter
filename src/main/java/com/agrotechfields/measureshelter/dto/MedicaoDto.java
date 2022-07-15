package com.agrotechfields.measureshelter.dto;

import com.agrotechfields.measureshelter.model.Medicao;

public class MedicaoDto {
  private int id;
  private float temperatura;
  private float umidadeAr;
  private float umidadeSolo;
  private String ilhaId;
  
  public MedicaoDto(int id, Medicao medicao, String ilhaId) {
    this.id = id;
    this.temperatura = medicao.getTemperatura();
    this.umidadeAr = medicao.getUmidadeAr();
    this.umidadeSolo = medicao.getUmidadeSolo();
    this.ilhaId = ilhaId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public float getTemperatura() {
    return temperatura;
  }

  public void setTemperatura(float temperatura) {
    this.temperatura = temperatura;
  }

  public float getUmidadeAr() {
    return umidadeAr;
  }

  public void setUmidadeAr(float umidadeAr) {
    this.umidadeAr = umidadeAr;
  }

  public float getUmidadeSolo() {
    return umidadeSolo;
  }

  public void setUmidadeSolo(float umidadeSolo) {
    this.umidadeSolo = umidadeSolo;
  }

  public String getIlhaId() {
    return ilhaId;
  }

  public void setIlhaId(String ilhaId) {
    this.ilhaId = ilhaId;
  }

  
}
