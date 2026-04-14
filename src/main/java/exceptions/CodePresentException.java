/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class CodePresentException extends Exception {

    /**
     * Creates a new instance of <code>CodePresentException</code> without
     * detail message.
     */
    public CodePresentException() {
    }

    /**
     * Constructs an instance of <code>CodePresentException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CodePresentException(String msg) {
        super(msg);
    }
}
