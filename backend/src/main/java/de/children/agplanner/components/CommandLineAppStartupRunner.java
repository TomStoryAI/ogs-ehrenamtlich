package de.children.agplanner.components;

import de.children.agplanner.model.Kind;
import de.children.agplanner.repositories.KindRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    KindRepository kindRepository;
    private static final Logger LOG =
      LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
 

    @Override
    public void run(String...args) throws Exception {
        LOG.info("Was ein fantastischer Dienstag <3 <3 ");
        Kind kind = new Kind();
        kind.setName("thomaso");
        kindRepository.save(kind);
        Optional<Kind> kindAusFile = kindRepository.findById(0);
        LOG.info(kindAusFile.get().getName());
    }
}