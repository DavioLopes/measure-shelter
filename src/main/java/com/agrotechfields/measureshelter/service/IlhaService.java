package com.agrotechfields.measureshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrotechfields.form.IlhaForm;
import com.agrotechfields.measureshelter.dto.IlhaDto;
import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.repository.IlhaRepository;

@Service
public class IlhaService {
  @Autowired
  private IlhaRepository ilhaRepository;
  public List<Ilha> listar() {
    return ilhaRepository.findAll();
  }

  public IlhaDto cadastrar(IlhaForm ilhaForm) {
    Ilha ilha = ilhaRepository.save(ilhaForm.converter());
    return new IlhaDto(ilha);
  }
}
