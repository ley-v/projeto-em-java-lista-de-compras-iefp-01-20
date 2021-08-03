/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Ley
 */
public class ErroNaConversaoDeStringParaDoubleException extends Exception {

    /**
     * Creates a new instance of
     * <code>ErroNaConversaoDeStringParaDoubleException</code> without detail
     * message.
     */
    public ErroNaConversaoDeStringParaDoubleException() {
    }

    /**
     * Constructs an instance of
     * <code>ErroNaConversaoDeStringParaDoubleException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ErroNaConversaoDeStringParaDoubleException(String msg) {
        super(msg);
    }
}
