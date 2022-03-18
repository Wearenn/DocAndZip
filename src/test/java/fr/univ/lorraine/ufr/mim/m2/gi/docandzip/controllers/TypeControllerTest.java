package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.controllers;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.config.ModelMapperConfig;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services.TypeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TypeControllerTest {

  @Mock
  TypeService service;

  ModelMapper mapper = new ModelMapperConfig().modelMapper();

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    var controller = new TypeController(service, mapper);
    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void get() throws Exception {
    var type = new Type(1L, "texte");

    when(service.getTypeById(type.getTypeId())).thenReturn(type);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/api/type/{id}", type.getTypeId()))
      .andExpect(status().isOk())
      .andExpect(content().json("{}"));

  }

  @Test
  void getAll() throws Exception {
    List<Type> types = Arrays.asList(
      new Type(1L, "texte"),
      new Type(2L, "audio"),
      new Type(3L, "video"),
      new Type(4L, "binaire")
    );

    when(service.getAllType()).thenReturn(types);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/api/type/"))
      .andExpect(status().isOk())
      .andExpect(content().json("[{},{},{},{}]"));
  }

}