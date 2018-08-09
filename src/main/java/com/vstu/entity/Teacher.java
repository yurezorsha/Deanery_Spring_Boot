package com.vstu.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_teach")
	private Integer idteach;
	@Size(max = 45)
	@Column(name = "firstname")
	private String firstname;
	@Size(max = 45)
	@Column(name = "surname")
	private String surname;
	@Size(max = 45)
	@Column(name = "patronymic")
	private String patronymic;
	@OneToMany(mappedBy = "teacher")
	@JsonIgnore
	private Collection<Subject> subjectCollection;

	public Teacher() {
	}

	public Teacher(Integer idteach) {
		this.idteach = idteach;
	}

	public Integer getIdTeach() {
		return idteach;
	}

	public void setIdTeach(Integer idteach) {
		this.idteach = idteach;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getSurName() {
		return surname;
	}

	public void setSurName(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	@XmlTransient
	public Collection<Subject> getSubjectCollection() {
		return subjectCollection;
	}

	public void setSubjectCollection(Collection<Subject> subjectCollection) {
		this.subjectCollection = subjectCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idteach != null ? idteach.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) object;
		if ((this.idteach == null && other.idteach != null)
				|| (this.idteach != null && !this.idteach.equals(other.idteach))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return idteach + " " + surname + " " + firstname + " " + patronymic;
	}

	public String getFIO() {
		return surname + " " + firstname + " " + patronymic;
	}

}
