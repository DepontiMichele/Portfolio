/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author Michele Deponti
 */
public class AreaNotInsertableException extends Exception {

    /**
     * Creates a new instance of <code>AreaNotInsertableException</code> without
     * detail message.
     */
    public AreaNotInsertableException() {
    }

    /**
     * Constructs an instance of <code>AreaNotInsertableException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public AreaNotInsertableException(String msg) {
        super(msg);
    }
}
