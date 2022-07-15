package com.agrotechfields.measureshelter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrotechfields.measureshelter.dto.ListaMedicoesDto;
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
    
    return new MedicaoDto(ilha.idDaUltimaMedicao(), medicao, id);
  }


  public List<ListaMedicoesDto> listar() {
    List<Ilha> ilhas = ilhaRepository.findAll();
    List<ListaMedicoesDto> listaMedicoes = ilhas
      .stream()
      .filter(i -> !i.getMedicoes().isEmpty())
      .map(i -> new ListaMedicoesDto(i.getId(), i.getMedicoes()))
      .collect(Collectors.toList());
    
      return listaMedicoes;
  }

  public ListaMedicoesDto listaMedicoesPorIlha(String ilhaId) {
    Ilha ilha = ilhaRepository.findById(ilhaId).get();
    
    return new ListaMedicoesDto(ilhaId, ilha.getMedicoes());
  }

  public MedicaoDto buscarporId(String ilhaId, int id) {
    Ilha ilha = ilhaRepository.findById(ilhaId).get();
    int idMedicao = id - 1;
    Medicao medicao = ilha.getMedicoes().get(idMedicao);
    
    return new MedicaoDto(id, medicao, ilhaId);
  }

  public MedicaoDto atualizar(String ilhaId, int id,Medicao medicao) {
    Ilha ilha = ilhaRepository.findById(ilhaId).get();
    int idMedicao = id - 1;
    
    ilha.atualizaMedicao(idMedicao, medicao);
    ilhaRepository.save(ilha);

    return new MedicaoDto(id, medicao, ilhaId);
  }

  public void remover(String ilhaId, int id) {
    Ilha ilha = ilhaRepository.findById(ilhaId).get();
    int idMedicao = id - 1;
    
    ilha.deletaMedicao(idMedicao);
    ilhaRepository.save(ilha);
  }
  
}
