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

import com.vstu.entity.Subject;
import com.vstu.service.ISubjectService;

@Controller
@RequestMapping("user")
public class SubjectController {
	@Autowired
	private ISubjectService subjectService;

	@GetMapping("subject/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Integer id) {
		Subject subject = subjectService.getSubjectById(id);
		return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	}

	@GetMapping("subjects")
	public ResponseEntity<List<Subject>> getAllSubject() {
		List<Subject> list = subjectService.getAllSubject();
		return new ResponseEntity<List<Subject>>(list, HttpStatus.OK);
	}

	@PostMapping("subject")
	public ResponseEntity<Void> addSubject(@RequestBody Subject subject, UriComponentsBuilder builder) {
		boolean flag = subjectService.addSubject(subject);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subject/{id}").buildAndExpand(subject.getIdSubj()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("subject")
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
		subjectService.updateSubject(subject);
		return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	}

	@DeleteMapping("subject/{id}")
	public ResponseEntity<Void> deleteSubject(@PathVariable("id") Integer id) {
		subjectService.deleteSubject(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
