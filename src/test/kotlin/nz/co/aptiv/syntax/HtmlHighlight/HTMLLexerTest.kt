package nz.co.aptiv.syntax.HtmlHighlight


import nz.co.aptiv.syntax.antlr.HtmlHighlight.HTMLLexer
import org.antlr.v4.runtime.ANTLRInputStream
import java.io.StringReader
import java.util.*
import kotlin.test.assertEquals

class HTMLLexerTest {

    fun lexString(str: String) = HTMLLexer(ANTLRInputStream(StringReader(str)))

    fun tokens(lexer: HTMLLexer): List<String> {
        val tokens = LinkedList<String>()
        do {
            val t = lexer.nextToken()
            when (t.type) {
                -1 -> tokens.add("EOF")
                else -> {
                    tokens.add(lexer.ruleNames[t.type - 1])
                    println(lexer.text)
                }
            }
        } while (t.type != -1)
        return tokens
    }

    @org.junit.Test
    fun simpleTag() {
        assertEquals(
                listOf("TAG_OPEN", "TAG_NAME", "TAG_CLOSE", "HTML_TEXT", "TAG_OPEN", "TAG_SLASH", "TAG_NAME", "TAG_CLOSE", "EOF"),
                tokens(lexString("<my-tag>text inside</my-tag>")))
    }
}