package de.children.agplanner.service;

import de.children.agplanner.repositories.AGRepository;
import de.children.agplanner.repositories.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AGService {
    @Autowired
    private AGRepository agRepository;

    public List getAllChildren(){
        return agRepository.findAll();
    }
}
