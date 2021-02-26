// SPDX-License-Identifier: Apache-2.0
// https://github.com/eclipse/elk/pull/106
// https://github.com/eclipse/elk/blob/master/plugins/org.eclipse.elk.graph.text/src/org/eclipse/elk/graph/text/ElkGraph.xtext

grammar ElktLanguage;

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
graph
  : layout? property* (node | edge)* EOF
  ;

layout
  : 'layout' '['(
            ('position' ':' x=Number ',' y=Number)?
            ('size' ':' width=Number ',' height=Number)?
    ) ']'
  ;

property
  : propertyKey ':' propertyValue
  ;

propertyKey
  : QualifiedId
  ;

propertyValue
  : StringLit
  | QualifiedId
  | Number
  | BooleanValue
  | 'null'
  ;

node
  : 'node' QualifiedId ('{'
    layout?
    property*
    (label | port | edge | node)*
   '}')?
  ;

port
  : 'port' QualifiedId ('{'
      layout?
      property*
      label*
   '}')?
  ;

label
  : 'label' (QualifiedId ':')? StringLit ('{'
      layout?
      property*
      label*
  '}')?
  ;

edge
  : 'edge' (QualifiedId ':')? QualifiedId (',' QualifiedId)* '->'
    QualifiedId (',' QualifiedId)* ('{'
      layout?
      property*
      label*
    '}')?
  ;

 /*------------------------------------------------------------------
  * LEXER RULES
  *------------------------------------------------------------------*/
Key_node : 'node' ;
Key_label  : 'label' ;
Key_port : 'port' ;
Key_edge : 'edge' ;
Key_layout : 'layout' ;
Key_size : 'size' ;
Key_section : 'section' ;
Key_incoming : 'incoming' ;
Key_outgoing : 'outgoing' ;
Key_start : 'start' ;
Key_end : 'end' ;
Key_bends : 'bends' ;

BooleanValue
  : 'true'
  | 'false'
  ;

QualifiedId
  : Id ('.' Id)*
  ;

StringLit
  : '"' UnquotedString? '"'
  ;

fragment
UnquotedString
  : ( ~[\r\n] )+?
  ;

fragment
Id
  : LegalStartChar (LegalIdChar)*
  ;

Number
  : UnsignedInt
  | SignedInt
  | DoubleLit
  ;

DoubleLit
  : ( '+' | '-' )? Digit+ '.' Digit+ ( 'E' ( '+' | '-' )? Digit+ )?
  ;

UnsignedInt
  : '0'
  | PosInt
  ;

SignedInt
  : ( '+' | '-' ) PosInt
  ;

fragment
PosInt
  : [1-9] ( Digit )*
  ;

fragment
Digit
  : [0-9]
  ;

fragment
LegalIdChar
  : LegalStartChar
  | Digit
  | '$'
  ;

fragment
LegalStartChar
  : [a-zA-Z_]
  ;

COMMENT
  : '//' .*? ('\n')+ -> channel(HIDDEN)
  ;

WHITESPACE
  : [ \t]+ -> channel(HIDDEN)
  ;

NEWLINE
	:'\r'? '\n' ' '* -> channel(HIDDEN)
	;

ERRCHAR
	:	.	-> channel(HIDDEN)
	;