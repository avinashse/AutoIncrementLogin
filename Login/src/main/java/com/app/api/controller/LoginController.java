package com.app.api.controller;

import java.util.List;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.model.CustomSequences;
import com.app.api.model.Login;
import com.app.api.repository.LoginRepository;
import com.app.api.service.NextSequencesService;

@CrossOrigin(origins = "http://10.105.129.146:4200")
@RestController
@RequestMapping("/api/v1")
public class LoginController {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired private MongoOperations mongo;
	
	@PostMapping("/createEmployees")
	public Login createEmployee(@RequestBody Login loginDetails) {
		NextSequencesService nextSequencesService = new NextSequencesService(mongo);
		loginDetails.setId(nextSequencesService.getNextSequence(Login.SEQUENCE_NAME));
		return loginRepository.save(loginDetails);
	}
	
	@GetMapping("/login")
	public List<Login> getAll()
	{
		return loginRepository.findAll();
	}
}
