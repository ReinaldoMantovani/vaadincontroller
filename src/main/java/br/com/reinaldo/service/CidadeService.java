package br.com.reinaldo.service;

import java.util.List;

import br.com.reinaldo.dto.CidadeDto;
import org.springframework.stereotype.Service;

@Service
public interface CidadeService {
	CidadeDto createCidade(CidadeDto cidadeDto);
	
	List<CidadeDto> getAllCidades();
	
	CidadeDto getCidadeById(Long id);
	
	void deleCidadeById(Long id);
}
