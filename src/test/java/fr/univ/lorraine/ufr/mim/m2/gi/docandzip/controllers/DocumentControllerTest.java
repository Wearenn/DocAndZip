package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.controllers;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.config.ModelMapperConfig;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.dtos.DocumentDto;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Document;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services.DocumentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class DocumentControllerTest {

  @Mock
  DocumentService service;

  ModelMapper mapper = new ModelMapperConfig().modelMapper();

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {

    var docController = new DocumentController(service, mapper);
    this.mockMvc = MockMvcBuilders.standaloneSetup(docController).build();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void create() throws Exception {
    var dto = new DocumentDto();
    dto.setTypeId(1L);
    dto.setChemin("/coucou/coucou.txt");
    dto.setNom("coucou");
    dto.setDateAjout(new Date());

    var doc = new Document(1L, dto.getNom(), dto.getChemin(), dto.getDateAjout());
    doc.setType(new Type(1L, "texte"));

    when(service.create(Mockito.any(Document.class), Mockito.anyLong())).thenReturn(doc);

    String body = (new ObjectMapper()).valueToTree(dto).toString();
    mockMvc.perform(
        MockMvcRequestBuilders.post("/api/document/")
          .content(body)
          .contentType(MediaType.APPLICATION_JSON_UTF8)
      )
      .andExpect(status().isCreated());

  }

  @Test
  void get() throws Exception {
    Document doc = new Document(1L, "coucou", "/coucou/coucou.txt", new Date());

    when(service.getDocumentById(doc.getDocumentId())).thenReturn(doc);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/api/document/{id}", doc.getDocumentId()))
      .andExpect(status().isOk())
      .andExpect(content().json("{}"));

  }

  @Test
  void getAll() throws Exception {
    List<Document> docs = Arrays.asList(
      new Document(1L, "coucou", "/coucou/coucou.txt", new Date()),
      new Document(2L, "coucou2", "/coucou/coucou2.txt", new Date())
    );

    when(service.getAllDocument()).thenReturn(docs);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/api/document/"))
      .andExpect(status().isOk())
      .andExpect(content().json("[{},{}]"));
  }

  @Test
  void delete() throws Exception {
    Document doc = new Document();
    doc.setDocumentId(1L);
    mockMvc.perform(
        MockMvcRequestBuilders.delete("/api/document/{id}", doc.getDocumentId())
          .content("")
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(status().isOk());
  }
}