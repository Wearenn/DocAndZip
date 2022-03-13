package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
