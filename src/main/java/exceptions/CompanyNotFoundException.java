/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class CompanyNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>CompanyNotFoundException</code> without
     * detail message.
     */
    public CompanyNotFoundException() {
    }

    /**
     * Constructs an instance of <code>CompanyNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CompanyNotFoundException(String msg) {
        super(msg);
    }
}
