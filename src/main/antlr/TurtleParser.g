parser grammar TurtleParser;

options {
  language = Java;
  tokenVocab = TurtleLexer;
}

@header {
  package TP1;
  import TP1.operators.Statement;
  import TP1.operators.Predicate;
  import TP1.operators.Object;
  import TP1.operators.Text;
  import TP1.operators.Entity;
}

document returns [ASD.Document out]
  : s=statements EOF { $out = new ASD.Document($s.out); }
  ;

// Fill here!


statement returns [Statement out]
  :  e = entity p = predicates {$out = new Statement($e.out, $p.out); }
  ;

statements returns [List<Statement> out]
//  :  list += statement ( list += statement)*  { $out = $list ;}
//  : list += statement ( statement)* {$out = $list; }
    : {List<Statement> statements = new ArrayList<Statement>();}
       ( s = statement POINT {statements.add($s.out);} )*
       {$out = statements;}
    ;


predicate returns [Predicate out]
  : e = entity o = objects {$out = new Predicate($e.out, $o.out); }
  ;

predicates returns [List<Predicate> out]
//  : list += predicate (POINT_VIRGULE list += predicate)* { $out = $list; }
// : list += predicate (POINT_VIRGULE predicate)* {$out = $list; }
  : {List<Predicate> predicates = new ArrayList<Predicate>();}
        (p1 = predicate  {predicates.add($p1.out);})
        (POINT_VIRGULE p2 = predicate {predicates.add($p2.out);})*
        {$out = predicates;}
  ;

object returns [Object out]
  : t = text {$out = $t.out;}
  | e = entity {$out = $e.out;}
  ;

objects returns [List<Object> out]
//  :  list += object (VIRGULE list += object)* { $out = $list; }
//  :  list += object (VIRGULE list += object)* {$out = $list; }
   : {List<Object> objects = new ArrayList<Object>();}
         (o1 = object {objects.add($o1.out);})*
         (VIRGULE o2 = object {objects.add($o2.out);})*
         {$out = objects;}
  ;

text returns [Text out]
  : GUILLEMET t = STRING GUILLEMET {$out = new Text($t.text); }
  ;

entity returns [Entity out]
  : CHEVRONG e = STRING CHEVROND {$out = new Entity($e.text); }
  ;
