package de.children.agplanner.repositories;


import de.children.agplanner.model.AG;
import de.children.agplanner.model.Wunsch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WunschRepository extends JpaRepository<Wunsch, Integer> {

}
