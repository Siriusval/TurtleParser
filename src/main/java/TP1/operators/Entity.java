package TP1.operators;

/**
 *Entity is a type of Object in Turtle language
 *
 * object  := Text(string)
 *          | Entity(string)
 */
public class Entity extends Object{

    private String text;

    public Entity(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "<"+text+">";
    }
}
