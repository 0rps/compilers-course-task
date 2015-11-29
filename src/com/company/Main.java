package com.company;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input

        FileReader fileStream = new FileReader("d:\\example.txt");

        ANTLRInputStream input = new ANTLRInputStream(fileStream);

        // create a lexer that feeds off of input CharStream
        decafLexer lexer = new decafLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        decafParser parser = new decafParser(tokens);

        ParseTreeWalker walker = new ParseTreeWalker();
        decafBaseListener listener = new decafBaseListener();
        walker.walk(listener, parser.program());
        //listener.storage.printStorage();

    }


}
