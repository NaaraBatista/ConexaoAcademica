package conexaoacademica;

import model.Usuario;
import model.Curso;
import model.Instituicao;
import model.Avaliacao;

public class ConexaoAcademica {
    public static void main(String[] args) {
        // Instanciando objetos para testes internos (se necessário)
        Instituicao inst1 = new Instituicao("Universidade Niterói", "Pública", "Niterói");
        Curso curso1 = new Curso("Engenharia de Software", 3600, "Presencial", inst1.getNome());
        Usuario usuario1 = new Usuario("Naara", "naara@email.com", "Estudante");
        Avaliacao avaliacao1 = new Avaliacao(9, "Curso excelente!", curso1, usuario1.getNome());

        // Aqui você poderia fazer testes chamando métodos da classe TelaAvaliacao
        // Exemplo: TelaAvaliacao.exibirFormulario(); // se estiver usando Java Swing ou console

        // Esse método serve como ponto de entrada, mas não precisa exibir dados diretamente
    }
}