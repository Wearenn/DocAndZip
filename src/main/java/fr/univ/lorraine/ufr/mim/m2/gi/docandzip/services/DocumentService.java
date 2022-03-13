package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Document;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DocumentService  {

    private final DocumentRepository repository;
    private final TypeService service;

    public DocumentService(DocumentRepository repository, TypeService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<Document> getAllDocument() {
        return repository.findAll();
    }

    public Document getDocumentById(Long id) {
        return repository.getById(id);
    }

    public Document create(Document document, Long typeId) {
        document.setType(service.getTypeById(typeId));
        return repository.save(document);
    }

    public Document update(Long id, Document document) {
        if(repository.findById(id).isPresent()) {
            document.setDocumentId(id);
            return repository.save(document);
        }
        return null;
    }

    public void delete(Long id) {
        repository.delete(repository.getById(id));
    }
}
