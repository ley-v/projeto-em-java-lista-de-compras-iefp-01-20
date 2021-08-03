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
public class ListaNome {
    
    private String id;
    private String nomeLista;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    @Override
    public String toString() {
        return "ListaNome{" + "id=" + id + ", nomeLista=" + nomeLista + '}';
    }
    
    
    
    
}
