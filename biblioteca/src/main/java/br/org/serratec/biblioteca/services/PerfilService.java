package br.org.serratec.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.biblioteca.dtos.PerfilResumidoDto;
import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	EmailService emailService;
	
	public List<Perfil> findAll() { //Pode utilizar também o recuperarTodos()
		return perfilRepository.findAll();
	}
	
	public List<PerfilResumidoDto> findAllPerfilResumido() {
		List<Perfil> perfis = perfilRepository.findAll();
		List<PerfilResumidoDto> perfisDto = new ArrayList<>();
		
		for(Perfil perfil : perfis) {
			PerfilResumidoDto perfilDto = new PerfilResumidoDto();
			perfilDto.setNome(perfil.getNome());
			perfilDto.setDescricao(perfil.getDescricao());
			
			perfisDto.add(perfilDto);
		}
		return perfisDto;
	}
	
	public Perfil findById(Integer id) {
		return perfilRepository.findById(id).get();
		//return perfilRepository.findById(id).orElse(null);
		
	}
	
	public PerfilResumidoDto findByIdResumido(Integer id) {
		Perfil perfil = perfilRepository.findById(id).orElse(null);
		PerfilResumidoDto perfilDto = null;
		
		//if(perfil != null)
		perfilDto = modelMapper.map(perfil, PerfilResumidoDto.class);
		
		emailService.enviarEmail("endereco@email.com", 
				"Cadastro de Perfil", perfilDto.toString());
		//try {
			//perfilDto = modelMapper.map(perfil, PerfilResumidoDto.class);
		//}catch(IllegalArgumentException e) {
			//throw new IllegalArgumentException("Ocorreu uma exceção: " + e);
		//}
				
		return perfilDto;
		
		
	}
	

	/*
	 Perfil perfil = new Perfil();
	 perfil.setNome("Admin");
	 perfil.setDescricao("Perfil de Admin");
	 */
	
	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	/*
	 Perfil perfil = new Perfil();
	 perfil.setNome("Admin");
	 */
	
	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public Perfil update(Perfil perfil, Integer id) {
		Perfil existentePerfil = findById(id);
		existentePerfil.setDescricao(perfil.getDescricao());
		existentePerfil.setNome(perfil.getNome());
		
		return perfilRepository.save(existentePerfil);
	}
	
	//Exercício para casa: Implementar uma forma de retornar o resultado
	// da deleção, retornando se o perfil foi deletado com sucesso ou não
	
	public void delete(Perfil perfil) {
		perfilRepository.delete(perfil);
	}
	
	public void deleteById(Integer id) {
		perfilRepository.deleteById(id);
	}
	public long count() {
		return perfilRepository.count();
	}
	
	public boolean delete(Integer id) {
        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
            Perfil perfilDeletado = perfilRepository.findById(id).orElse(null);
            if(perfilDeletado == null) {
            	return true;
            }
            else {
            	return false;
            }
		        }
		        else {
		            return false;
		        }
		}

}
