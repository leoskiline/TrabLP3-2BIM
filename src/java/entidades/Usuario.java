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
public class Usuario {
    private int id_usuario;
    private String usuario;
    private String senha;
    private String nivel;
    private String foto;
    private String nome;
    private String logradouro;

    public Usuario() {
    }

    public Usuario(String usuario, String senha, String nivel, String foto, String nome, String logradouro) {
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
        this.foto = foto;
        this.nome = nome;
        this.logradouro = logradouro;
    }

    public Usuario(int id_usuario, String usuario, String senha, String nivel, String foto, String nome, String logradouro) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
        this.foto = foto;
        this.nome = nome;
        this.logradouro = logradouro;
    }
    
    public Usuario(String usuario,String senha)
    {
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    
}
