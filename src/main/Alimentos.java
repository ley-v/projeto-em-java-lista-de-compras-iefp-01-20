 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Ley
 */
public class Alimentos {
    
    private String id;
    private String nomeAlimento;
    private String nomeMercado;
    private double precoKgL;

    public Alimentos(String nomeAlimento, String nomeMercado, double precoKgL) {
        this.nomeAlimento = nomeAlimento;
        this.nomeMercado = nomeMercado;
        this.precoKgL = precoKgL;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public String getNomeMercado() {
        return nomeMercado;
    }

    public void setNomeMercado(String nomeMercado) {
        this.nomeMercado = nomeMercado;
    }

    public double getPrecoKgL() {
        return precoKgL;
    }

    public void setPrecoKgL(double precoKgL) {
        this.precoKgL = precoKgL;
    }

    
    
}
