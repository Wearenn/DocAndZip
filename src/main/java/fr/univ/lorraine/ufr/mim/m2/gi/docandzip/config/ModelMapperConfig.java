package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.config;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.dtos.DocumentDto;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Document;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {

    var mapper = new ModelMapper();

    mapper.createTypeMap(DocumentDto.class, Document.class).addMappings(
      m -> m.skip(Document::setType)
    );
    mapper.createTypeMap(Document.class, DocumentDto.class).addMappings(
      m -> m.map(src -> src.getType().getTypeId(),  DocumentDto::setTypeId)
    );

    return mapper;
  }
}
