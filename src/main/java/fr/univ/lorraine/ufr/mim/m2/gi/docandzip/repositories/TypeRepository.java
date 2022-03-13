package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.repositories;

import fr.univ.lorraine.ufr.mim.m2.gi.docandzip.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {

}
