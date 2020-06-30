package de.children.agplanner.repositories;


import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AGRepository extends JpaRepository<AG, Integer> { }
