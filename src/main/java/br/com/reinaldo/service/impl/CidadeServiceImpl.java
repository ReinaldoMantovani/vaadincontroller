package br.com.reinaldo.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.reinaldo.dto.CidadeDto;
import br.com.reinaldo.entities.Cidade;
import br.com.reinaldo.execption.ResourceNotFoundException;
import br.com.reinaldo.repository.CidadeRepository;
import br.com.reinaldo.service.CidadeService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeServiceImpl implements CidadeService{

	private CidadeRepository cidadeRepository;
	
	public CidadeServiceImpl(CidadeRepository cidadeRepository) {
		super();
		this.cidadeRepository = cidadeRepository;
	}
	
	// Create Cidade
	@Transactional
	@Override
	public CidadeDto createCidade(CidadeDto cidadeDto) {
		Cidade cidade = mapToEntity(cidadeDto);
		Cidade newCidade = cidadeRepository.save(cidade);
		
		// Convert entity to Dto
		CidadeDto cidadeResponse = mapToDto(newCidade);
		
		return cidadeResponse;
	}
	
	// Get All Cidade
	public List<CidadeDto> getAllCidades(){
		List<Cidade> cidades = cidadeRepository.findAll();
		
		return cidades.stream().map(cidade -> mapToDto(cidade)).collect(Collectors.toList());
	}
	
	// Get Cidade By Id
	@Override
	public CidadeDto getCidadeById(Long id) {
		Cidade cidade = cidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade", "id", id));
		return mapToDto(cidade);
	}
	
	@Override
	public void deleCidadeById(Long id) {
		Cidade cidade = cidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade", "id", id));
		
		cidadeRepository.delete(cidade);
	}
	
	private CidadeDto mapToDto(Cidade cidade) {
		CidadeDto cidadeDto = new CidadeDto();
		cidadeDto.setId(cidade.getId());
		cidadeDto.setNome(cidade.getNome());
		cidadeDto.setCodigoIbge(cidade.getCodigoIbge());
		cidadeDto.setUf(cidade.getUf());
		cidadeDto.setMomentoRegistro(cidade.getMomentoRegistro());
		cidadeDto.getUsuarios();
		
		return cidadeDto;
	}
	
	private Cidade mapToEntity(CidadeDto cidadeDto) {
		Cidade cidade = new Cidade();
		cidade.setNome(cidadeDto.getNome());
		cidade.setCodigoIbge(cidadeDto.getCodigoIbge());
		cidade.setUf(cidadeDto.getUf());
		cidade.setMomentoRegistro(cidadeDto.getMomentoRegistro());
		cidade.getUsuarios();
	
		
		return cidade;
	}

}
