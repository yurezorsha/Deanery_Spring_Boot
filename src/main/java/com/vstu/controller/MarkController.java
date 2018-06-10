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

import com.vstu.entity.Mark;
import com.vstu.service.IMarkService;

@Controller
@RequestMapping("user")
public class MarkController {

	@Autowired
	private IMarkService markService;

	@GetMapping("mark/{id}")
	public ResponseEntity<Mark> getMarkById(@PathVariable("id") Integer id) {
		Mark Mark = markService.getMarkById(id);
		return new ResponseEntity<Mark>(Mark, HttpStatus.OK);
	}

	@GetMapping("marks")
	public ResponseEntity<List<Mark>> getAllMark() {
		List<Mark> list = markService.getAllMark();
		return new ResponseEntity<List<Mark>>(list, HttpStatus.OK);
	}

	@PostMapping("mark")
	public ResponseEntity<Void> addMark(@RequestBody Mark mark, UriComponentsBuilder builder) {
		boolean flag = markService.addMark(mark);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/mark/{id}").buildAndExpand(mark.getIdMark()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("mark")
	public ResponseEntity<Mark> updateMark(@RequestBody Mark mark) {
		markService.updateMark(mark);
		return new ResponseEntity<Mark>(mark, HttpStatus.OK);
	}

	@DeleteMapping("mark/{id}")
	public ResponseEntity<Void> deleteMark(@PathVariable("id") Integer id) {
		markService.deleteMark(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
