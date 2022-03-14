package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.controllers;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.dtos.TypeDto;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5075")
@RestController
@RequestMapping(value = "/api/type")
public class TypeController {

    private final TypeService service;

    private final ModelMapper mapper;

    public TypeController(TypeService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TypeDto get(@PathVariable("id") Long id) {
        var model = service.getTypeById(id);
        return mapper.map(model, TypeDto.class);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TypeDto> get() {
        var models = service.getAllType();
        return models.stream()
                .map(model -> mapper.map(model, TypeDto.class))
                .collect(Collectors.toList());
    }
}
