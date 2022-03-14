package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories.TypeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TypeServiceTest {

  @InjectMocks
  private TypeService service;

  @Mock
  private TypeRepository repository;

  Type type;

  @BeforeEach
  void setUp() {
    this.type = new Type(1L, "texte");
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void getAll() {
    List<Type> l  = new ArrayList<>();
    l.add(this.type);
    when(repository.findAll()).thenReturn(l);

    var res = service.getAllType();

    assertNotNull(res);
    assertFalse(res.isEmpty());
  }

  @Test
  void getById() {
    when(repository.getById(1L)).thenReturn(type);

    var res = service.getTypeById(1L);
    assertNotNull(res);
    assertNotNull(res.getTypeId());
    assertEquals(1L, res.getTypeId());
  }
}