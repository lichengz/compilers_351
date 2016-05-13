/* *********************************************************************
 * ECE351 
 * Department of Electrical and Computer Engineering 
 * University of Waterloo 
 * Term: Summer 2016 (1165)
 *
 * The base version of this file is the intellectual property of the
 * University of Waterloo. Redistribution is prohibited.
 *
 * By pushing changes to this file I affirm that I am the author of
 * all changes. I affirm that I have complied with the course
 * collaboration policy and have not plagiarized my work. 
 *
 * I understand that redistributing this file might expose me to
 * disciplinary action under UW Policy 71. I understand that Policy 71
 * allows for retroactive modification of my final grade in a course.
 * For example, if I post my solutions to these labs on GitHub after I
 * finish ECE351, and a future student plagiarizes them, then I too
 * could be found guilty of plagiarism. Consequently, my final grade
 * in ECE351 could be retroactively lowered. This might require that I
 * repeat ECE351, which in turn might delay my graduation.
 *
 * https://uwaterloo.ca/secretariat-general-counsel/policies-procedures-guidelines/policy-71
 * 
 * ********************************************************************/

package ece351.w.rdescent;

import ece351.util.Lexer;

public final class WRecursiveDescentRecognizer {
    private final Lexer lexer;
    

    public WRecursiveDescentRecognizer(final Lexer lexer) {
        this.lexer = lexer;
    }

    public static void recognize(final String input) {
    	final WRecursiveDescentRecognizer r = new WRecursiveDescentRecognizer(new Lexer(input));
        r.recognize();
    }

    /**
     * Throws an exception to reject.
     */
    public void recognize() {
        program();
    }

    /**
     * What is the termination condition of the loop in program()?
     * Will this condition be met if the waveform() method does nothing?
     */
    public void program() {
        waveform();
        while (!lexer.inspectEOF()) {
            waveform();
//            System.out.println(lexer.debugState());
        }
        lexer.consumeEOF();
    }

    public void waveform() {
// TODO: longer code snippet
// throw new ece351.util.Todo351Exception();
    	final String[] bit_tokens = {"0","1"};
    	double id_counter = 0;
    	double bit_counter = 0;
    	
//    	lexer.consumeID();
    	while (lexer.inspectID()) {
    		lexer.consumeID();
    		id_counter++;
//			System.out.println(lexer.debugState());
    	}
    	if (id_counter < 1) {
    		throw new RuntimeException();
    	}
    	
    	lexer.consume(":");
//    	if (lexer.inspect(":")) {
//    		lexer.consume(":");
//    	} else {
//    		throw new RuntimeException();
//    	}
    	
    	while (lexer.inspect(bit_tokens)) {
    		if (lexer.inspect(bit_tokens)) {
        		lexer.consume(bit_tokens);
        		bit_counter++;
        	}
    	}
    	if (bit_counter < 1) {
    		throw new RuntimeException();
    	}
    	
    	if (lexer.inspect(";")) {
    		lexer.consume(";");
    	} else {
    		throw new RuntimeException();
    	}
    }
}
