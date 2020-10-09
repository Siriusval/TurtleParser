package TP1.operators;

import java.util.List;

/**
 * Definition of Predicate in Tutle language
 * A predicate contains a list of Objects
 *
 * predicate := Predicate(pId, object+)
 */
public class Predicate {

    private Entity entity;
    private List<Object> objectList;

    public Predicate(Entity entity, List<Object> objectList) {
        this.entity = entity;
        this.objectList = objectList;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    @Override
    public String toString() {
        return entity.toString();
    }
}
