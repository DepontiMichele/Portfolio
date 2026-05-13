/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class InvalidResidentsException extends Exception {

    /**
     * Creates a new instance of <code>InvalidResidentsException</code> without
     * detail message.
     */
    public InvalidResidentsException() {
    }

    /**
     * Constructs an instance of <code>InvalidResidentsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidResidentsException(String msg) {
        super(msg);
    }
}
