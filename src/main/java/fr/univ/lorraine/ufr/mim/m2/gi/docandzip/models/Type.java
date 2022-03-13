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
}
