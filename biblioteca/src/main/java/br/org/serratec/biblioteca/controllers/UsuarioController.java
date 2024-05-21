package br.org.serratec.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.biblioteca.dtos.FakeStoreUserDto;
import br.org.serratec.biblioteca.entities.Usuario;
import br.org.serratec.biblioteca.services.ClientRestService;
import br.org.serratec.biblioteca.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	ClientRestService clientRestService;
	
	@PostMapping
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id){
		Usuario usuario = usuarioService.findById(id);
		if(usuario == null) {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Usuario não encontrado'}");
	}
	
	@GetMapping("/fake-store/{id}")
	public ResponseEntity<FakeStoreUserDto> findUserByIdFromFakeApi(@PathVariable Integer id) {
		return new ResponseEntity<>(clientRestService.findByIndFromFakeApi(id),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(usuario));
	}
	
	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestBody Usuario usuario){
		if (usuarioService.findById(usuario.getUserId()) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.delete(usuario));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Usuario não encontrado'}");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer id){
		if (usuarioService.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.deleteById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'Error': 'Usuario não encontrado'}");
	}
}