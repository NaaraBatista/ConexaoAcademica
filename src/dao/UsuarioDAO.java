package dao;

import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import conexaoacademica.Conexao;

public class UsuarioDAO {

    public boolean autenticar(String nome, String email) {
        String sql = "SELECT * FROM usuario WHERE nome = ? AND email = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

    public void cadastrar(Usuario novoUsuario) {
        String sql = "INSERT INTO usuario (nome, email, perfil) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoUsuario.getNome());
            stmt.setString(2, novoUsuario.getEmail());
            stmt.setString(3, novoUsuario.getPerfil());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

          while (rs.next()) {
    Usuario u = new Usuario(
        rs.getString("nome"),
        rs.getString("email"),
        rs.getString("perfil")
    );
    usuarios.add(u);
}
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }

        return usuarios;
    }
}