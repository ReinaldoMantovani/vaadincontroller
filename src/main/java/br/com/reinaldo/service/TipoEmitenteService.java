package br.com.reinaldo.service;

import java.util.List;

import br.com.reinaldo.dto.TipoEmitenteDto;





public interface TipoEmitenteService  {
	TipoEmitenteDto createTipoEmitente(TipoEmitenteDto tipoEmitenteDto);
	
	List<TipoEmitenteDto> getAllTipoEmitente();
	
	TipoEmitenteDto getAllTipoEmitenteById(Long id);
	
	void deleteTipoEmitenteById(Long id);
}
