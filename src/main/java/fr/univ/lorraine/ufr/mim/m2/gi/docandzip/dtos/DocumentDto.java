package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.dtos;

import java.util.Date;

public class DocumentDto {

    private Long documentId;
    private String nom;
    private String chemin;
    private Long typeId;
    private Date dateAjout;

    public DocumentDto() {

    }

    public DocumentDto(Long documentId, String nom, String chemin, Long typeId, Date dateAjout) {
        this.documentId = documentId;
        this.nom = nom;
        this.chemin = chemin;
        this.typeId = typeId;
        this.dateAjout = dateAjout;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }
}
