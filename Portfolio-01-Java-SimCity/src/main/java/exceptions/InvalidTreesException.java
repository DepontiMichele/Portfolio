/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class InvalidTreesException extends Exception {

    /**
     * Creates a new instance of <code>InvalidTreesException</code> without
     * detail message.
     */
    public InvalidTreesException() {
    }

    /**
     * Constructs an instance of <code>InvalidTreesException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidTreesException(String msg) {
        super(msg);
    }
}
