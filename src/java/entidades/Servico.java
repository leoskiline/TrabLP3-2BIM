/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Leonardo
 */
public class Servico {
    private int id_servico;
    private String categoria;

    public Servico(String categoria) {
        this.categoria = categoria;
    }

    public Servico(int id_servico, String categoria) {
        this.id_servico = id_servico;
        this.categoria = categoria;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
