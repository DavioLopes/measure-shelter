package com.agrotechfields.measureshelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agrotechfields.measureshelter.dto.MedicaoDto;
import com.agrotechfields.measureshelter.model.Ilha;
import com.agrotechfields.measureshelter.model.Medicao;
import com.agrotechfields.measureshelter.repository.IlhaRepository;

@Service
public class MedicaoService {
  
  @Autowired
  private IlhaRepository ilhaRepository;


  public MedicaoDto cadastrar(String id, Medicao medicao) {
    Ilha ilha = ilhaRepository.findById(id).get();
    ilha.adicionaMedicao(medicao);
    ilhaRepository.save(ilha);
    return new MedicaoDto(0, medicao, id);
  }

}
