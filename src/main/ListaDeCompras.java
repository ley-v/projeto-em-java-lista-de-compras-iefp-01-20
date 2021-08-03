/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import excecoes.ErroNaConversaoDeStringParaDoubleException;

/**
 *
 * @author Ley
 */
public class ListaDeCompras {

    private String alimento;
    private String mercado;
    private Double quantidade;
    private String preco;
    private String id;

    @Override
    public String toString() {
        return "ListaDeCompras{" + "alimento=" + alimento + ", mercado=" + mercado + ", quantidade=" + quantidade + ", preco=" + preco + ", id=" + id + '}';
    }

   
    

    public double converterStringParaDouble(String s) throws ErroNaConversaoDeStringParaDoubleException{
        Double d;
        try {
            d = Double.parseDouble(s.replace(",", "."));
        } catch (NumberFormatException e) {
            d = -1d;
            throw new ErroNaConversaoDeStringParaDoubleException("Não foi possível converter a String em Double");
        }
        return d;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}