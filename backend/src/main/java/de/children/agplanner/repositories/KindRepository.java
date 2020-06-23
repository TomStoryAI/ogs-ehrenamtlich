package de.children.agplanner.repositories;

import de.children.agplanner.model.Kind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindRepository extends CrudRepository<Kind, Integer>
{
}
