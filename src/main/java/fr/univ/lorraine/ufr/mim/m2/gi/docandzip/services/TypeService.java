package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.services;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepository repository;

    public TypeService(TypeRepository repository) {
        this.repository = repository;
    }

    public List<Type> getAllType() {
        return repository.findAll();
    }

    public Type getTypeById(Long id) {
        return repository.getById(id);
    }
}