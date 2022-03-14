package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories;

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

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
class TypeRepositoryTest {

  @Autowired
  TypeRepository repository;

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
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void getById() {
    var type = repository.getById(1L);
    assertNotNull(type);
    assertEquals(1L, type.getTypeId());
  }

  @Test
  void getAll() {
    var list = repository.findAll();
    assertFalse(list.isEmpty());
    assertEquals(4, list.size());
  }
}