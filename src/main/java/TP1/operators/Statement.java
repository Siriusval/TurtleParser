package TP1.operators;

import TP1.ASD;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of Subject in Tutle language
 * A subject contains a list of Predicates
 *
 * subject  := Subject(sId,predicate+)
 */
public class Statement {

    Entity entity;
    List<Predicate> predicateList;

    public Statement(Entity entity, List<Predicate> predicateList) {
        this.entity = entity;
        this.predicateList = predicateList;
    }


    public String toNTriple() {
        String buffer = "";
        for(Predicate predicate : predicateList){
            for (Object object : predicate.getObjectList()) {
                buffer += this.toString();
                buffer += predicate.toString();
                buffer += object.toString();
                buffer +=".\n";
            }
        }
        return buffer;
    }

    @Override
    public String toString() {
        return entity.toString();
    }
}
