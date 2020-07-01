package de.children.agplanner.service;

import de.children.agplanner.repositories.AGRepository;
import de.children.agplanner.repositories.WunschRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WunschService {
    @Autowired
    private WunschRepository wunschRepository;

    public List getAllWuensche(){
        return wunschRepository.findAll();
    }

}
