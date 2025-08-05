package model;

public class Avaliacao {
    private int nota;
    private String comentario;
    private Curso curso;
    private String autor;

    // Construtor completo
    public Avaliacao(int nota, String comentario, Curso curso, String autor) {
        this.nota = nota;
        this.comentario = comentario;
        this.curso = curso;
        this.autor = autor;
    }

    // Construtor alternativo (sem curso nem autor)
    public Avaliacao(int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
        this.curso = null;
        this.autor = "Anônimo";
    }

    // Getters
    public int getNota() { return nota; }
    public String getComentario() { return comentario; }
    public Curso getCurso() { return curso; }
    public String getAutor() { return autor; }

    // Setters
    public void setNota(int nota) { this.nota = nota; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public void setAutor(String autor) { this.autor = autor; }

    // toString bonitinho 😄
    @Override
    public String toString() {
        String cursoNome = (curso != null) ? curso.getNome() : "Curso desconhecido";
        return "Avaliação do curso '" + cursoNome + "' por " + autor +
               ": Nota " + nota + " | " + comentario;
    }
}