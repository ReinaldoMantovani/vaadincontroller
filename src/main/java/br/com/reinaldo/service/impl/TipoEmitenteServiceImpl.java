package br.com.reinaldo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.reinaldo.dto.TipoEmitenteDto;
import br.com.reinaldo.entities.TipoEmitente;
import br.com.reinaldo.execption.ResourceNotFoundException;
import br.com.reinaldo.repository.TipoEmitenteRepository;
import br.com.reinaldo.service.TipoEmitenteService;

@Service
public class TipoEmitenteServiceImpl implements TipoEmitenteService{

	private TipoEmitenteRepository tipoEmitenteRepository;
	
	public TipoEmitenteServiceImpl(TipoEmitenteRepository tipoEmitenteRepository) {
		super();
		this.tipoEmitenteRepository = tipoEmitenteRepository;
	}
	
	// Create Cidade
	@Override
	public TipoEmitenteDto createTipoEmitente(TipoEmitenteDto tipoEmitenteDto) {
		TipoEmitente tipoEmitente = mapToEntity(tipoEmitenteDto);
		TipoEmitente newTipoEmitente = tipoEmitenteRepository.save(tipoEmitente);
		
		// Convert entity to Dto
		TipoEmitenteDto tipoEmitenteResponse = mapToDto(newTipoEmitente);
		
		return tipoEmitenteResponse;
	}
	
	// Get All TipoEmitente
	public List<TipoEmitenteDto> getAllTipoEmitente(){
		List<TipoEmitente> tipoEmitentes = tipoEmitenteRepository.findAll();
		
		return tipoEmitentes.stream().map(tipoEmitente -> mapToDto(tipoEmitente)).collect(Collectors.toList());
	}
	
	// Get TipoEmitente By Id
	@Override
	public TipoEmitenteDto getAllTipoEmitenteById(Long id) {
		TipoEmitente tipoEmitente = tipoEmitenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cidade", "id", id));
		return mapToDto(tipoEmitente);
	}
	
	@Override
	public void deleteTipoEmitenteById(Long id) {
		TipoEmitente tipoEmitente = tipoEmitenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoEmitente", "id", id));
		
		tipoEmitenteRepository.delete(tipoEmitente);
	}
	
	private TipoEmitenteDto mapToDto(TipoEmitente tipoEmitente) {
		TipoEmitenteDto tipoEmitenteDto = new TipoEmitenteDto();
			tipoEmitenteDto.setId(tipoEmitente.getId());
			tipoEmitenteDto.setNome(tipoEmitente.getNome());
			tipoEmitenteDto.setMomentoRegistro(tipoEmitente.getMomentoRegistro());
		
		return tipoEmitenteDto;
	}
	
	private TipoEmitente mapToEntity(TipoEmitenteDto tipoEmitenteDto) {
		TipoEmitente tipoEmitente = new TipoEmitente();
		tipoEmitente.setNome(tipoEmitenteDto.getNome());
		tipoEmitente.setMomentoRegistro(tipoEmitente.getMomentoRegistro());
	
		return tipoEmitente;
	}

}
