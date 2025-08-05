package dao;

import model.Curso;
import model.Instituicao;
import conexaoacademica.Conexao;

import java.sql.*;
import java.util.ArrayList;

public class CursoDAO {

    public ArrayList<Curso> listarCursos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        String sql = """
            SELECT c.id, c.nome, c.cargaHoraria, c.modalidade,
                   i.nome AS instituicao_nome, i.tipo, i.localizacao
            FROM curso c
            JOIN instituicao i ON c.instituicao_id = i.id
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Instituicao inst = new Instituicao(
                    rs.getString("instituicao_nome"),
                    rs.getString("tipo"),
                    rs.getString("localizacao")
                );

                Curso curso = new Curso(
                    rs.getString("nome"),
                    rs.getInt("cargaHoraria"),
                    rs.getString("modalidade"),
                    inst.getNome()
                );

                cursos.add(curso);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        }

        return cursos;
    }

    public Curso buscarPorNome(String nome) {
        Curso curso = null;
        String sql = """
            SELECT c.nome, c.cargaHoraria, c.modalidade,
                   i.nome AS instituicao_nome, i.tipo, i.localizacao
            FROM curso c
            JOIN instituicao i ON c.instituicao_id = i.id
            WHERE c.nome = ?
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Instituicao inst = new Instituicao(
                    rs.getString("instituicao_nome"),
                    rs.getString("tipo"),
                    rs.getString("localizacao")
                );

                curso = new Curso(
                    rs.getString("nome"),
                    rs.getInt("cargaHoraria"),
                    rs.getString("modalidade"),
                    inst.getNome()
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar curso: " + e.getMessage());
        }

        return curso;
    }
}