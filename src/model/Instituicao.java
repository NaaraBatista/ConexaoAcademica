package model;

public class Instituicao {
    private String nome;
    private String tipo;         // Ex: Pública, Privada
    private String localizacao;  // Ex: Niterói, Rio de Janeiro

    public Instituicao(String nome, String tipo, String localizacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.localizacao = localizacao;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public String getLocalizacao() { return localizacao; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    @Override
    public String toString() {
        return "Instituição: " + nome + " | Tipo: " + tipo + " | Localização: " + localizacao;
    }
}