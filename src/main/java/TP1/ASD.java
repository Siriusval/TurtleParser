package TP1;

import TP1.operators.Statement;

import java.util.List;

/**
 * Abstract Syntax Definition of Turtle Language
 */
public class ASD {
  /**
   * Turtle document contains all the subjects
   * document := Document(Subject*)
   */
  static public class Document {

    List<Statement> statementList;

    public Document( List<Statement> statementList){
      this.statementList = statementList;
    }


    public String toNtriples() {
      String buffer ="";

      for ( Statement statement : statementList
           ) {
        buffer+= statement.toNTriple();
      }

      return buffer;
    }
  }



}
