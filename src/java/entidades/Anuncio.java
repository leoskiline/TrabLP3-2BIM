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
public class Anuncio {
    private int id_anuncio;
    private String foto1;
    private String foto2;
    private String foto3;
    private String descricao;
    private String horario_atendimento;
    private String contato;
    private String servicos;
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getServicos() {
        return servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public Anuncio(String foto1, String foto2, String foto3, String descricao, String horario_atendimento, String contato, String servicos, String usuario) {
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.descricao = descricao;
        this.horario_atendimento = horario_atendimento;
        this.contato = contato;
        this.servicos = servicos;
        this.usuario = usuario;
    }

    public Anuncio() {
    }

    public Anuncio(int id_anuncio, String foto1, String foto2, String foto3, String descricao, String horario_atendimento, String contato,String servicos,String usuario) {
        this.id_anuncio = id_anuncio;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.descricao = descricao;
        this.horario_atendimento = horario_atendimento;
        this.contato = contato;
        this.servicos = servicos;
        this.usuario = usuario;
    }

    public int getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(int id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(String horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    
}
