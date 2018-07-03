package com.vstu.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stud")

public class Stud implements Serializable {

	private static final long serialVersionUID = 1L;
	@Transient
	private boolean a;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_stud")
	private int idstud;
	@Size(max = 45)
	@Column(name = "firstname")
	private String firstname;
	@Size(max = 45)
	@Column(name = "surname")
	private String surname;
	@Size(max = 45)
	@Column(name = "patronymic")
	private String patronymic;
	@Column(name = "course")
	private Integer course;
	@JoinColumn(name = "gr", referencedColumnName = "id_group")
	@ManyToOne

	private Gr gr;
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<Mark> markCollection;

	public Stud() {
	}

	public Stud(int idStud) {
		this.idstud = idStud;
	}

	public int getIdStud() {
		return idstud;
	}

	public void setIdStud(Integer idStud) {
		this.idstud = idStud;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getSurName() {
		return surname;
	}

	public void setSurName(String surName) {
		this.surname = surName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public Gr getGr() {
		return gr;
	}

	public void setGr(Gr gr) {
		this.gr = gr;
	}

	@XmlTransient

	public Collection<Mark> getMarkCollection() {
		return markCollection;
	}

	public void setMarkCollection(Collection<Mark> markCollection) {
		this.markCollection = markCollection;
	}

	@Override
	public String toString() {
		return idstud + " " + surname + " " + firstname + " " + patronymic;
	}

	public String getFIO() {
		return surname + " " + firstname + " " + patronymic;
	}

}
