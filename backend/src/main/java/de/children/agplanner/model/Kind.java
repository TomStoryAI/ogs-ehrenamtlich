package de.children.agplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kind {
    @Id
    @Seq
    private int ID;
    private String name;
    private int schuljahr;
}
