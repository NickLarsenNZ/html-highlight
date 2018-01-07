lexer grammar HtmlLexer;

// Whitespace
NL          : '\r\n' | '\r' | '\n';
WS          : [\t ]+ -> skip;

// Gonna test with a simple tag and close tag and content
// <tag>text</tag> or <tag></tag>

LT          : '<';
GT          : '>';
CLOSE       : '/';
TAG         : [a-zA-Z0-9\-];

TEXT        : [^\<\>]
            | /* epsilon */
            ;