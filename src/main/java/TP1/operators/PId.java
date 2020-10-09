package TP1.operators;

/**
 * NOT USED ANYMORE
 *
 * Id type for the Predicate
 *
 * pId := Ident(string)
 */
public class PId {

    private String name;

    public PId(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "<"+name+">";
    }
}
