package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.controllers;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.dtos.DocumentDto;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Document;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5075")
@RestController
@RequestMapping(value = "/api/document")
public class DocumentController {

    private final DocumentService service;

    private final ModelMapper mapper;

    public DocumentController(DocumentService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DocumentDto get(@PathVariable("id") Long id) {
        var model = service.getDocumentById(id);
        return mapper.map(model, DocumentDto.class);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<DocumentDto> get() {
        var models = service.getAllDocument();
        return models.stream()
                .map(model -> mapper.map(model, DocumentDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DocumentDto create(@RequestBody DocumentDto documentDto) {
        var model = mapper.map(documentDto, Document.class);
        var result = service.create(model, documentDto.getTypeId());
        return mapper.map(result, DocumentDto.class);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
