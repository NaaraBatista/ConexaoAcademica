package conexaoacademica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projeto_integrador", // ajuste seu nome de banco se for diferente
                "root", // seu usuário do MySQL
                "20092007"      // sua senha do MySQL (pode ser "" se estiver em branco)
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}