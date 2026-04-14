/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class InvalidCodeException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCodeException</code> without
     * detail message.
     */
    public InvalidCodeException() {
    }

    /**
     * Constructs an instance of <code>InvalidCodeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidCodeException(String msg) {
        super(msg);
    }
}
