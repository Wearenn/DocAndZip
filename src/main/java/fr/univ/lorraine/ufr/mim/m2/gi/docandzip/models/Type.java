package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

    public Type() {}

    public Type(Long typeId, String type) {
        this.typeId = typeId;
        this.type = type;
        this.documents = new ArrayList<>();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;
        Type type1 = (Type) o;
        return Objects.equals(getTypeId(), type1.getTypeId()) && Objects.equals(getType(), type1.getType()) && Objects.equals(getDocuments(), type1.getDocuments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeId(), getType(), getDocuments());
    }
}
