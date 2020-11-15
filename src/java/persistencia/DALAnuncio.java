/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Anuncio;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.Conexao;

/**
 *
 * @author Leonardo
 */
public class DALAnuncio {
    public boolean inserir(Anuncio a) {
        String sql = "insert into anuncios (foto1,foto2,foto3,descricao,horario_atendimento,contato,servicos,usuario) values ('$1','$2','$3','$4','$5','$6','$7','$8')";
        sql = sql.replace("$1", a.getFoto1());
        sql = sql.replace("$2", a.getFoto2());
        sql = sql.replace("$3", a.getFoto3());
        sql = sql.replace("$4", a.getDescricao());
        sql = sql.replace("$5", a.getHorario_atendimento());
        sql = sql.replace("$6", a.getContato());
        sql = sql.replace("$7", a.getServicos());
        sql = sql.replace("$8", a.getUsuario());
        return new Conexao().manipular(sql);
    }

    public boolean alterar(Anuncio a) {
        String sql = "update anuncios set foto1='$1', foto2='$2', foto3='$3', descricao='$4', horario_atendimento='$5', contato='$6',servicos='$7', usuario='$8' where id_anuncio=" + a.getId_anuncio();
        sql = sql.replace("$1", a.getFoto1());
        sql = sql.replace("$2", a.getFoto2());
        sql = sql.replace("$3", a.getFoto3());
        sql = sql.replace("$4", a.getDescricao());
        sql = sql.replace("$5", a.getHorario_atendimento());
        sql = sql.replace("$6", a.getContato());
        sql = sql.replace("$7", a.getServicos());
        sql = sql.replace("$8", a.getUsuario());
        return new Conexao().manipular(sql);
    }

    public boolean apagar(int id) {
        return new Conexao().manipular("delete from anuncios where id_anuncio=" + id);
    }

    public Anuncio getAnuncio(int cod) {
        Anuncio a = null;
        String sql = "select * from anuncios where id_anuncio=" + cod;
        ResultSet rs = new Conexao().consultar(sql);
        try {
            if (rs.next()) {
                a = new Anuncio(rs.getInt("id_anuncio"),rs.getString("foto1"),rs.getString("foto2"),rs.getString("foto3"),rs.getString("descricao"),rs.getString("horario_atendimento"),rs.getString("contato"),rs.getString("servicos"),rs.getString("usuario"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }
    

    public ArrayList<Anuncio> getAnuncio(String filtro) {
        ArrayList<Anuncio> lista = new ArrayList();
        String sql = "SELECT * "
                + "FROM anuncios "
                + "INNER JOIN servicos s on anuncios.servicos = s.id_servico "
                + "INNER JOIN usuarios u on anuncios.usuario = u.id_usuario";
        if (!filtro.isEmpty()) {
            sql += " where upper (descricao) LIKE upper ('%"+filtro+"%')";
        }
        sql += " order by id_anuncio;";
        ResultSet rs = new Conexao().consultar(sql);
        try {
            while (rs.next()) {
                lista.add(
                       new Anuncio(rs.getInt("id_anuncio"),rs.getString("foto1"),rs.getString("foto2"),rs.getString("foto3"),rs.getString("descricao"),rs.getString("horario_atendimento"),rs.getString("contato"),rs.getString("categoria"),rs.getString("nome")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    public ArrayList<Anuncio> getAnuncioCat(String filtro) {
        ArrayList<Anuncio> lista = new ArrayList();
        String sql = "SELECT * "
                + "FROM anuncios "
                + "INNER JOIN servicos s on anuncios.servicos = s.id_servico "
                + "INNER JOIN usuarios u on anuncios.usuario = u.id_usuario";
        if (!filtro.isEmpty()) {
            sql += " where (id_servico) = "+filtro;
        }
        sql += " order by id_anuncio;";
        ResultSet rs = new Conexao().consultar(sql);
        try {
            while (rs.next()) {
                lista.add(
                       new Anuncio(rs.getInt("id_anuncio"),rs.getString("foto1"),rs.getString("foto2"),rs.getString("foto3"),rs.getString("descricao"),rs.getString("horario_atendimento"),rs.getString("contato"),rs.getString("categoria"),rs.getString("nome")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    public ArrayList<Anuncio> getAnuncioCatDesc(String filtro) {
        ArrayList<Anuncio> lista = new ArrayList();
        String sql = "SELECT * "
                + "FROM anuncios "
                + "INNER JOIN servicos s on anuncios.servicos = s.id_servico "
                + "INNER JOIN usuarios u on anuncios.usuario = u.id_usuario";
        if (!filtro.isEmpty()) {
            sql += " where (s.categoria) LIKE '"+filtro+"'";
        }
        sql += " order by id_anuncio;";
        ResultSet rs = new Conexao().consultar(sql);
        try {
            while (rs.next()) {
                lista.add(
                       new Anuncio(rs.getInt("id_anuncio"),rs.getString("foto1"),rs.getString("foto2"),rs.getString("foto3"),rs.getString("descricao"),rs.getString("horario_atendimento"),rs.getString("contato"),rs.getString("categoria"),rs.getString("nome")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
}
