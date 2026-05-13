/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class InvalidCompanyNameException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCompanyNameException</code>
     * without detail message.
     */
    public InvalidCompanyNameException() {
    }

    /**
     * Constructs an instance of <code>InvalidCompanyNameException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidCompanyNameException(String msg) {
        super(msg);
    }
}
