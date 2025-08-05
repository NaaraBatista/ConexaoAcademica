package model;

public class Usuario {
    private int id; // se quiser trabalhar com o campo id do banco
    private String nome;
    private String email;
    private String perfil; // compatível com o nome no banco MySQL

    // Construtor completo
    public Usuario(String nome, String email, String perfil) {
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
    }

    // Construtor vazio (opcional)
    public Usuario() {}

    public Usuario(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getPerfil() { return perfil; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    @Override
    public String toString() {
        return "Usuário: " + nome + " | Email: " + email + " | Perfil: " + perfil;
    }
}