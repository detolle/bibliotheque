package com.bibliotheque.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.bibliotheque.util.EnumStatusExemplaire;

@Entity
public class Exemplaire {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private BigDecimal idExemplaire;

	private Date dateAchat;	
//	@Enumerated(EnumType.STRING)
//	private EnumStatusExemplaire status;
	private String status;	
	//@Pattern(regexp="\\d*")	
	private String isbn;
	
	@Transient
	public Livre livre;
	@Transient
	public EmpruntArchive empruntArchive[];
	@Transient
	public EmpruntEnCours empruntEnCours[];
	
	public Exemplaire() {
		super();		
	}
	//public Exemplaire(Integer idExemplaire, Date dateAchat, EnumStatusExemplaire status, String isbn) {
	public Exemplaire(BigDecimal idExemplaire, Date dateAchat, String status, String isbn) {
		super();
		this.idExemplaire = idExemplaire;
		this.dateAchat = dateAchat;
		this.status = status;
		this.isbn = isbn;
	}
	
	public BigDecimal getIdExemplaire() {
		return idExemplaire;
	}
	public void setIdExemplaire(BigDecimal idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	
	@Past
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
//	public EnumStatusExemplaire getStatus() {
//		return status;
//	}
//	public void setStatus(EnumStatusExemplaire status) {
//		this.status = status;
//		this.statut = status.toString();		
//	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre theLivre) {
		this.livre = livre;
	}
	public EmpruntArchive[] getEmpruntArchive() {
		return empruntArchive;
	}
	public void setEmpruntArchive(EmpruntArchive[] empruntArchive) {
		this.empruntArchive = empruntArchive;
	}	
	@NotNull
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Exemplaire [idExemplaire=" + idExemplaire + ", dateAchat=" + sdf.format(dateAchat) + ", status=" + status
				+", isbn="+ isbn + "]";
	}

	
}
