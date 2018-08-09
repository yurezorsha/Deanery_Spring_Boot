package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.vstu.entity.Gr;
import com.vstu.service.IGrService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("deanery")
public class GrController {
	@Autowired
	private IGrService grService;

	@GetMapping("gr/{id}")
	public ResponseEntity<Gr> getStudById(@PathVariable("id") Integer id) {
		Gr gr = grService.getGrById(id);
		return new ResponseEntity<Gr>(gr, HttpStatus.OK);
	}

	@GetMapping("gr")
	public ResponseEntity<List<Gr>> getAllGr() {
		List<Gr> list = grService.getAllGr();
		return new ResponseEntity<List<Gr>>(list, HttpStatus.OK);
	}

	@PostMapping("gr")
	public ResponseEntity<Void> addGr(@RequestBody Gr gr, UriComponentsBuilder builder) {
		boolean flag = grService.addGr(gr);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/gr/{id}").buildAndExpand(gr.getIdGroup()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("gr")
	public ResponseEntity<Gr> updateGr(@RequestBody Gr gr) {
		grService.updateGr(gr);
		return new ResponseEntity<Gr>(gr, HttpStatus.OK);
	}

	@DeleteMapping("gr/{id}")
	public ResponseEntity<Void> deleteGr(@PathVariable("id") Integer id) {
		grService.deleteGr(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
