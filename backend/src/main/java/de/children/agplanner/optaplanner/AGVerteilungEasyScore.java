package de.children.agplanner.optaplanner;

import de.children.agplanner.model.AG;
import de.children.agplanner.model.Kind;
import de.children.agplanner.model.Wunsch;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AGVerteilungEasyScore implements EasyScoreCalculator<AGVerteilung> {

    private static final Logger LOG = LoggerFactory.getLogger(AGVerteilungEasyScore.class);


    @Override
    public Score calculateScore(AGVerteilung agVerteilung) {
        int hardScore = 0;
        int softScore = 0;
        Map<AG, Integer> keepCount = new HashMap<>();
        for (Kind kind : agVerteilung.getKindListe()) {
            AG ag = kind.getAg();
            // Kind wurde keiner AG zugeordnet
            if (ag == null) {
                hardScore -= 10;
            } else {
                if (keepCount.get(ag) == null) {
                    keepCount.put(ag, 1);
                } else {
                    keepCount.put(ag, keepCount.get(ag) + 1);
                }
               if(kind.getWunsch().size() > 0) {
                   boolean wunschFound = false;
                   for(Wunsch wunsch : kind.getWunsch()) {
                       if(wunsch.getWunschAg().getID() == ag.getID()){
                           wunschFound = true;
                           softScore -= wunsch.getPrioritaet()-1;
                       }
                   }
                   if(!wunschFound) {
                       softScore-= 10;
                   }
               }
            }
        }
        List<AG> agListe = keepCount.keySet().stream().filter(ag -> keepCount.get(ag) > ag.getGroesse()).collect(Collectors.toList());
        for (AG ag : agListe) {
                hardScore -= keepCount.get(ag) - ag.getGroesse();
        }
        return HardSoftScore.of(hardScore, softScore);
    }
}
