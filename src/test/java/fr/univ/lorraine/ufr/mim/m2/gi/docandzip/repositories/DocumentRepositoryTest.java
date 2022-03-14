package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Document;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
class DocumentRepositoryTest {

  @Autowired
  DocumentRepository repository;

  Type type;
  Document document;
  Document doc;
  Date d = new Date();

  @Container
  public static PostgreSQLContainer container = new PostgreSQLContainer("postgres:12-alpine")
    .withUsername("admin").withPassword("admin").withDatabaseName("DocAndZip");

  @DynamicPropertySource
  static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", container::getJdbcUrl);
    registry.add("spring.datasource.username", container::getUsername);
    registry.add("spring.datasource.password", container::getPassword);
  }

  @BeforeEach
  void setUp() {
    this.type = new Type(1L, "texte");
    this.type.setTypeId(1L);
    this.document = new Document();
    this.document.setNom("Bibi");
    this.document.setChemin("/document/test/coucou.txt");
    this.document.setDateAjout(d);
    this.document.setType(this.type);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void create() {
    var doc = repository.save(document);
    assertNotNull(doc);
    assertNotNull(doc.getDocumentId());
    assertEquals(doc.getNom(), document.getNom());
    assertEquals(doc.getDateAjout(), document.getDateAjout());
    assertEquals(doc.getChemin(), document.getChemin());
    assertEquals(doc.getType(), document.getType());
  }

  @Test
  void getById() {
    var doc = repository.getById(1L);
    assertNotNull(doc);
    assertNotNull(doc.getDocumentId());
  }

  @Test
  void getAll() {
    var list = repository.findAll();
    assertFalse(list.isEmpty());
    assertEquals(6, list.size());
  }
}