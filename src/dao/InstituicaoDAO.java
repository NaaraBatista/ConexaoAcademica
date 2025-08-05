package dao;

import model.Instituicao;
import conexaoacademica.Conexao;

import java.sql.*;
import java.util.ArrayList;

public class InstituicaoDAO {

    public ArrayList<Instituicao> listarInstituicoes() {
        ArrayList<Instituicao> lista = new ArrayList<>();
        String sql = "SELECT nome, tipo, localizacao FROM instituicao";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Instituicao inst = new Instituicao(
                    rs.getString("nome"),
                    rs.getString("tipo"),
                    rs.getString("localizacao")
                );
                lista.add(inst);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar instituições: " + e.getMessage());
        }

        return lista;
    }
}