package TP1.operators;

/**
 *  NOT USED ANYMORE
 *
 * Id type for the Subject
 *
 * sId := Ident(string)
 */
public class SId {

    private String name;

    public SId(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "<"+name+">";
    }
}
