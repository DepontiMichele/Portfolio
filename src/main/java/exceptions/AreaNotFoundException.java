/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class AreaNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>AreaNotFoundException</code> without
     * detail message.
     */
    public AreaNotFoundException() {
    }

    /**
     * Constructs an instance of <code>AreaNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AreaNotFoundException(String msg) {
        super(msg);
    }
}
