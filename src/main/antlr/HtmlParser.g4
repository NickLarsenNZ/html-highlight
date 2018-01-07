parser grammar HtmlParser;

options { tokenVocab=HtmlLexer; }

document        : tags
                ;

tags            : tag+
                ;

tag             : LT TAG GT TEXT LT CLOSE TAG GT
                ;