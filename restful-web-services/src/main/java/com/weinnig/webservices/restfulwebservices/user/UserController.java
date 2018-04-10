package com.weinnig.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.weinnig.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
	private UserDoaService service;
	
	@GetMapping(path="/users")
	public List<User> findAll() {
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> findById(@PathVariable int id) {
		User user = service.findById(id);
		
		if(user == null) {
			throw new UserNotFoundException("id=" + id);
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@PutMapping(path="/users/{num}")
	public User save(@PathVariable int num, @RequestBody User user) {
		user.setId(num);
		return service.save(user);
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> create(@Valid @RequestBody User user) {
		User savedUser = service.create(user);
				
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId().intValue())
			.toUri();
		
		return ResponseEntity
			.created(location)
			.body(savedUser);
	}
	
	@DeleteMapping(path="/users/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		User deletedUser = service.deleteById(id);
		
		if(deletedUser == null) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return ResponseEntity
				.noContent()
				.build();
		
	}
}
