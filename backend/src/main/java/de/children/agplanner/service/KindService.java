package de.children.agplanner.service;

import de.children.agplanner.repositories.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindService {
    @Autowired
    private KindRepository kindRepository;

    public List getAllChildren(){
        return kindRepository.findAll();
    }
}
