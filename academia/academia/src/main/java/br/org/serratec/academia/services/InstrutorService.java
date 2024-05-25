package br.org.serratec.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Instrutor;
import br.org.serratec.academia.repositories.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	InstrutorRepository instrutorRepository;
	
	public List<Instrutor> findAll() {
		return instrutorRepository.findAll();
	}
	
	public Instrutor findById(Integer id) {
		return instrutorRepository.findById(id).get();
	}
	
	public Instrutor save(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public Instrutor update(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public Instrutor update(Instrutor instrutor, Integer id) {
		Instrutor existenteInstrutor = findById(id);
		existenteInstrutor.setInstrutorId(instrutor.getInstrutorId());
		existenteInstrutor.setNomeInstrutor(instrutor.getNomeInstrutor());
		existenteInstrutor.setRg(instrutor.getRg());
		existenteInstrutor.setTelefone(instrutor.getTelefone());
		
		return instrutorRepository.save(existenteInstrutor);
	}
	
	public void delete(Instrutor instrutor) {
		instrutorRepository.delete(instrutor);
	}
	
	public void deleteById(Integer id) {
		instrutorRepository.deleteById(id);
	}
	public long count() {
		return instrutorRepository.count();
	}
	
	public boolean delete(Integer id) {
        if (instrutorRepository.existsById(id)) {
            instrutorRepository.deleteById(id);
            Instrutor instrutorDeletado = instrutorRepository.findById(id).orElse(null);
            if(instrutorDeletado == null) {
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
