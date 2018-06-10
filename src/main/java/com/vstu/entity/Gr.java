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
@Table(name = "gr")
public class Gr implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_group")
	private Integer idGroup;
	@Size(max = 45)
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "gr")
	@JsonIgnore
	private Collection<Stud> studCollection;

	public Gr() {
	}

	public Gr(Integer idGroup) {
		this.idGroup = idGroup;
	}

	public Integer getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public Collection<Stud> getStudCollection() {
		return studCollection;
	}

	public void setStudCollection(Collection<Stud> studCollection) {
		this.studCollection = studCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idGroup != null ? idGroup.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Gr)) {
			return false;
		}
		Gr other = (Gr) object;
		if ((this.idGroup == null && other.idGroup != null)
				|| (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return idGroup + " " + name;
	}

}
