package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.model.CustomSequences;
import com.app.api.repository.CustomerSequencesRepository;

@CrossOrigin(origins = "http://10.105.129.146:4200")
@RestController
@RequestMapping("/api/v1")
public class CustomSequencesController {

	@Autowired
	private CustomerSequencesRepository customerSequencesRepository;
	
	@PostMapping("/createSequence")
	public CustomSequences createEmployee(@RequestBody CustomSequences customSequencesDetails) {
		return customerSequencesRepository.save(customSequencesDetails);
	}
	
}
