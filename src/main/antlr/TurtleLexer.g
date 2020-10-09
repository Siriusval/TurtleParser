lexer grammar TurtleLexer;

options {
  language = Java;
}

@header {
  package TP1;
}

// ignore whitespaces
WS : (' '|'\n'|'\t'|'\r'|'\u000C')+ -> skip
   ;

fragment ASCII  : ~('\n'|'"'|'<'|'>'|';'|'.'|',');

// Fill here!
//Regular expressions
//Affect type to each lexem

STRING
 :  ASCII+
 ;


 POINT_VIRGULE : ';';
 POINT : '.';
 VIRGULE : ',';

 CHEVRONG : '<';
 CHEVROND : '>';

 GUILLEMET : '"' ;