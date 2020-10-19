/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.Conexao;

/**
 *
 * @author Leonardo
 */
public class DALUsuario {
     public boolean inserir(Usuario u) {
        String sql = "insert into usuarios (usuario,senha,nivel,foto,nome,logradouro) values ('$1','$2','$3','$4','$5','$6')";
        sql = sql.replace("$1", u.getUsuario());
        sql = sql.replace("$2", u.getSenha());
        sql = sql.replace("$3", u.getNivel());
        sql = sql.replace("$4", u.getFoto());
        sql = sql.replace("$5", u.getNome());
        sql = sql.replace("$6", u.getLogradouro());
        return new Conexao().manipular(sql);
    }

    public boolean alterar(Usuario u) {
        String sql = "update usuarios set usuario='$1', senha='$2', nivel='$3', foto='$4', nome='$5', logradouro='$6' where id=" + u.getId_usuario();
        sql = sql.replace("$1", u.getUsuario());
        sql = sql.replace("$2", u.getSenha());
        sql = sql.replace("$3", u.getNivel());
        sql = sql.replace("$4", u.getFoto());
        sql = sql.replace("$5", u.getNome());
        sql = sql.replace("$6", u.getLogradouro());
        return new Conexao().manipular(sql);
    }

    public boolean apagar(int id) {
        return new Conexao().manipular("delete from usuarios where id_usuario=" + id);
    }

    public Usuario getUsuario(int cod) {
        Usuario u = null;
        String sql = "select * from usuarios where id_usuario=" + cod;
        ResultSet rs = new Conexao().consultar(sql);
        try {
            if (rs.next()) {
                u = new Usuario(rs.getInt("id_usuario"),rs.getString("usuario"),rs.getString("senha"),rs.getString("nivel"),rs.getString("foto"),rs.getString("nome"),rs.getString("logradouro"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
    
    public Usuario getUsuario(String usuario,String senha) {
        Usuario u = null;
        String sql = "SELECT * FROM usuarios WHERE usuario = '"+usuario+"' AND senha = '"+senha+"';";
        ResultSet rs = new Conexao().consultar(sql);
        try {
            if (rs.next()) {
                u = new Usuario(rs.getInt("id_usuario"),rs.getString("usuario"),rs.getString("senha"),rs.getString("nivel"),rs.getString("foto"),rs.getString("nome"),rs.getString("logradouro"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

    public ArrayList<Usuario> getUsuario(String filtro) {
        ArrayList<Usuario> lista = new ArrayList();
        String sql = "select * from servicos";
        if (!filtro.isEmpty()) {
            sql += " where " + filtro;
        }
        sql += " order by id_usuario";
        ResultSet rs = new Conexao().consultar(sql);
        try {
            while (rs.next()) {
                lista.add(
                        new Usuario(rs.getInt("id_usuario"),rs.getString("usuario"),rs.getString("senha"),rs.getString("nivel"),rs.getString("foto"),rs.getString("nome"),rs.getString("logradouro")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
}
