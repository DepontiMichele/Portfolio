/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class CompanyPresentException extends Exception {

    /**
     * Creates a new instance of <code>CompanyPresentException</code> without
     * detail message.
     */
    public CompanyPresentException() {
    }

    /**
     * Constructs an instance of <code>CompanyPresentException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CompanyPresentException(String msg) {
        super(msg);
    }
}
