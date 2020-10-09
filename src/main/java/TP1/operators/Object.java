package TP1.operators;

/**
 * Definition for an Object in Tutle language
 * An object can be a text or an Entity (see children classes)
 *
 * object  := Text(string)
 *          | Entity(string)
 */
public abstract class Object {

    public abstract String toString();
}
