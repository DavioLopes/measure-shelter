package com.agrotechfields.measureshelter.model;

public class Medicao {

  private float temperatura;
  private float umidadeAr;
  private float umidadeSolo;

  public Medicao(float temperatura, float umidadeAr, float umidadeSolo) {
    this.temperatura = temperatura;
    this.umidadeAr = umidadeAr;
    this.umidadeSolo = umidadeSolo;
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
}