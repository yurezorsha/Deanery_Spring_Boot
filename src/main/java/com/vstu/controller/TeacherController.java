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

import com.vstu.entity.Teacher;
import com.vstu.service.ITeacherService;

@Controller
@RequestMapping("user")
public class TeacherController {
	@Autowired
	private ITeacherService teacherService;

	@GetMapping("teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Integer id) {
		Teacher Teacher = teacherService.getTeacherById(id);
		return new ResponseEntity<Teacher>(Teacher, HttpStatus.OK);
	}

	@GetMapping("teachers")
	public ResponseEntity<List<Teacher>> getAllTeacher() {
		List<Teacher> list = teacherService.getAllTeacher();
		return new ResponseEntity<List<Teacher>>(list, HttpStatus.OK);
	}

	@PostMapping("teacher")
	public ResponseEntity<Void> addTeacher(@RequestBody Teacher teacher, UriComponentsBuilder builder) {
		boolean flag = teacherService.addTeacher(teacher);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/teacher/{id}").buildAndExpand(teacher.getIdTeach()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("teacher")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
		teacherService.updateTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}

	@DeleteMapping("teacher/{id}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Integer id) {
		teacherService.deleteTeacher(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
