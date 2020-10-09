package TP1;

import TP1.operators.*;
import TP1.operators.Object;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class Main {
  public static void main(String[] args) {
    // Use with a manually made AST

    //<type> <poly>
    Object polyObject = new Entity("poly");
    ArrayList<Object> typeObjectList = new ArrayList<>();
    typeObjectList.add(polyObject);
    Entity typeEntity = new Entity("type");
    Predicate typePredicate = new Predicate(typeEntity,typeObjectList);

    //<auteur> <Ridoux>, <Ferre>
    Object ridouxObject = new Entity("Ridoux");
    Object ferreObject = new Entity("Ferre");
    ArrayList<Object> auteurObjectList = new ArrayList<>();
    auteurObjectList.add(ridouxObject);
    auteurObjectList.add(ferreObject);
    Entity auteurEntity = new Entity("auteur");
    Predicate auteurPredicate = new Predicate(auteurEntity,auteurObjectList);

    //<titre> "Compilation"
    Object compilationObject = new Text("Compilation");
    ArrayList<Object> titreObjectList = new ArrayList<>();
    titreObjectList.add(compilationObject);
    Entity titreEntity = new Entity("titre");
    Predicate titrePredicate = new Predicate(titreEntity,titreObjectList);

    //<poly117>
    Entity poly117Entity = new Entity("poly117");
    ArrayList<Predicate> poly117Predicates = new ArrayList<>();
    poly117Predicates.add(typePredicate);
    poly117Predicates.add(auteurPredicate);
    poly117Predicates.add(titrePredicate);
    Statement poly117Statement = new Statement(poly117Entity,poly117Predicates);

    //<Ridoux> <type> <personne>, <professeur> .
    Object personneObject = new Entity("personne");
    Object professeurObject = new Entity("professeur");

    Entity typeEntity2 = new Entity("type");
    ArrayList<Object> typeObjectList2 = new ArrayList<>();
    typeObjectList2.add(personneObject);
    typeObjectList2.add(professeurObject);
    Predicate typePredicate2 = new Predicate(typeEntity2,typeObjectList2);

    ArrayList<Predicate> ridouxPredicates = new ArrayList<>();
    ridouxPredicates.add(typePredicate2);

    Entity ridouxEntity = new Entity("Ridoux");
    Statement ridouxStatement = new Statement(ridouxEntity,ridouxPredicates);

    //Add both Subjects to doc
    ArrayList<Statement> statementList = new ArrayList<>();
    statementList.add(poly117Statement);
    statementList.add(ridouxStatement);

    ASD.Document ast = new ASD.Document(statementList);

    System.out.println("--- toNtriple from Manual AST ---");
    System.out.println(ast.toNtriples());


    // Use with lexer and parser
    System.out.println("--- toNtriple from Parser ---");
    try {
      // Set input
      CharStream input;
      if(args.length == 0) {
        // From standard input
        input = CharStreams.fromStream(System.in);
      }
      else {
        // From file set in first argument
        input = CharStreams.fromPath(Paths.get(args[0]));
      }

      // Instantiate Lexer
      TurtleLexer lexer = new TurtleLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);

      // Instantiate Parser
      TurtleParser parser = new TurtleParser(tokens);

      // Parse
      ASD.Document ast1 = parser.document().out;

      // Print as Ntriples
      System.out.println(ast1.toNtriples());



    } catch(IOException e) {
      e.printStackTrace();
    }

  }
}
