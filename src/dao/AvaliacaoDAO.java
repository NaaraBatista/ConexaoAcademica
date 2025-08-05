package dao;

import model.Avaliacao;
import model.Curso;
import model.Usuario;
import conexaoacademica.Conexao;

import java.sql.*;
import java.util.ArrayList;

public class AvaliacaoDAO {

    public void adicionar(Avaliacao avaliacao, int cursoId, int autorId) {
        String sql = "INSERT INTO avaliacao (nota, comentario, curso_id, autor_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setFloat(1, avaliacao.getNota()); // usando float em vez de BigDecimal
            stmt.setString(2, avaliacao.getComentario());
            stmt.setInt(3, cursoId);
            stmt.setInt(4, autorId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar avaliação: " + e.getMessage());
        }
    }

    public ArrayList<Avaliacao> listarTodas() {
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        String sql = """
            SELECT a.nota, a.comentario, 
                   u.nome AS autor_nome, 
                   c.nome AS curso_nome 
            FROM avaliacao a
            JOIN usuario u ON a.autor_id = u.id
            JOIN curso c ON a.curso_id = c.id
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso(rs.getString("curso_nome"));
                Usuario autor = new Usuario(rs.getString("autor_nome"));
                Avaliacao av = new Avaliacao(
                    (int) rs.getFloat("nota"),
                    rs.getString("comentario"),
                    curso,
                    autor.getNome()
                );
                avaliacoes.add(av);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar avaliações: " + e.getMessage());
        }

        return avaliacoes;
    }
}