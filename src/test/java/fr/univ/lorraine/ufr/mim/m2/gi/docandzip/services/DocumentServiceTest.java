package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services;


import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Document;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories.DocumentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DocumentServiceTest {

  @InjectMocks
  private DocumentService service;

  @Mock
  private DocumentRepository repository;

  @Mock
  private TypeService serviceType;

  Type type;
  Document document;
  Document doc;
  Date d = new Date();

  @BeforeEach
  void setUp() {
    this.type = new Type(1L, "texte");
    this.type.setTypeId(1L);
    this.document = new Document(1L,"Bibi", "/document/test/coucou.txt", d);
    this.document.setType(this.type);
    this.type.getDocuments().add(this.document);


    this.doc = new Document();
    doc.setNom("Bibi");
    doc.setChemin("/document/test/coucou.txt");
    doc.setDateAjout(d);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void create() {

    when(serviceType.getTypeById(1L)).thenReturn(type);
    when(repository.save(doc)).thenReturn(document);

    var res = service.create(this.doc, 1L);

    assertNotNull(res.getDocumentId());
    assertEquals(res.getDateAjout(), doc.getDateAjout());
    assertEquals(res.getNom(), doc.getNom());
    assertEquals(res.getChemin(), doc.getChemin());
    assertEquals(1L, res.getType().getTypeId());
  }

  @Test
  void getById() {

    when(repository.getById(1L)).thenReturn(document);

    var res = service.getDocumentById(1L);
    assertNotNull(res);
    assertNotNull(res.getDocumentId());
    assertEquals(1L, res.getDocumentId());
  }

  @Test
  void getAll() {
    List<Document> l  = new ArrayList<>();
    l.add(document);
    when(repository.findAll()).thenReturn(l);

    var res = service.getAllDocument();

    assertNotNull(res);
    assertFalse(res.isEmpty());
  }

  @Test
  void delete() {
    when(repository.findById(1L)).thenReturn(Optional.of(document));
    when(repository.getById(1L)).thenReturn(document);

    var res = service.delete(1L);

    assertTrue(res);
  }
}