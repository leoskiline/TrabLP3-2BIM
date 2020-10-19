/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Servico;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.Conexao;

/**
 *
 * @author Leonardo
 */
public class DALServico {
    public boolean inserir(Servico s) {
        String sql = "insert into servicos (categoria) values ('$1')";
        sql = sql.replace("$1", s.getCategoria());
        return new Conexao().manipular(sql);
    }

    public boolean alterar(Servico s) {
        String sql = "update servicos set categoria='$1' where id_servico=" + s.getId_servico();
        sql = sql.replace("$1", s.getCategoria());
        return new Conexao().manipular(sql);
    }

    public boolean apagar(int id) {
        return new Conexao().manipular("delete from servicos where id_servico=" + id);
    }

    public Servico getServico(int cod) {
        Servico s = null;
        String sql = "select * from servicos where id_servico=" + cod;
        ResultSet rs = new Conexao().consultar(sql);
        try {
            if (rs.next()) {
                s = new Servico(rs.getInt("id_servico"),rs.getString("categoria"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    public ArrayList<Servico> getServico(String filtro) {
        ArrayList<Servico> lista = new ArrayList();
        String sql = "SELECT * FROM servicos";
        if (!filtro.isEmpty()) {
            sql += " WHERE UPPER (categoria) LIKE UPPER ('%" + filtro+"%')";
        }
        sql += " ORDER BY id_servico";
        ResultSet rs = new Conexao().consultar(sql);
        try {
            while (rs.next()) {
                lista.add(
                        new Servico(rs.getInt("id_servico"),rs.getString("categoria")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
}
