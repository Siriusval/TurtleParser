package TP1.operators;

/**
 *Text is a type of Object in Turtle language
 *
 * object  := Text(string)
 *          | Entity(string)
 */
public class Text extends Object{

    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "\""+text+"\"";
    }
}
