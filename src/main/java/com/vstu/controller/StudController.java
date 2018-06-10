package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.vstu.entity.Stud;
import com.vstu.service.IStudService;

@Controller
@RequestMapping("user")
public class StudController {
	@Autowired
	private IStudService studService;

	@GetMapping("stud/{id}")
	public ResponseEntity<Stud> getStudById(@PathVariable("id") Integer id) {
		Stud stud = studService.getStudById(id);
		return new ResponseEntity<Stud>(stud, HttpStatus.OK);
	}

	@GetMapping("studs")
	public ResponseEntity<List<Stud>> getAllStud() {
		List<Stud> list = studService.getAllStud();
		return new ResponseEntity<List<Stud>>(list, HttpStatus.OK);
	}

	@PostMapping("stud")
	public ResponseEntity<Void> addStud(@RequestBody Stud stud, UriComponentsBuilder builder) {
		boolean flag = studService.addStud(stud);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/stud/{id}").buildAndExpand(stud.getIdStud()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("stud")
	public ResponseEntity<Stud> updateStud(@RequestBody Stud stud) {
		studService.updateStud(stud);
		return new ResponseEntity<Stud>(stud, HttpStatus.OK);
	}

	@DeleteMapping("stud/{id}")
	public ResponseEntity<Void> deleteStud(@PathVariable("id") Integer id) {
		studService.deleteStud(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
