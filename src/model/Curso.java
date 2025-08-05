package model;

public class Curso {
    private int id; // se quiser controlar pelo banco
    private String nome;
    private int cargaHoraria;
    private String modalidade;
    private String instituicao; // nome da instituição vinculada

    // Construtor completo
    public Curso(String nome, int cargaHoraria, String modalidade, String instituicao) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.modalidade = modalidade;
        this.instituicao = instituicao;
    }

    // Construtor simples (ex: apenas nome)
    public Curso(String nome) {
        this.nome = nome;
    }

    // Construtor vazio (opcional, usado em frameworks ou quando setando depois)
    public Curso() {}

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getCargaHoraria() { return cargaHoraria; }
    public String getModalidade() { return modalidade; }
    public String getInstituicao() { return instituicao; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }
    public void setInstituicao(String instituicao) { this.instituicao = instituicao; }

    // toString para exibir informações no console
    @Override
    public String toString() {
        return "Curso: " + nome + " | " + cargaHoraria + "h | " + modalidade +
               " | Instituição: " + instituicao;
    }

    // Método adicional (opcional)
    public String getDetalhes() {
        return nome + "\nCarga Horária: " + cargaHoraria + "h\nModalidade: " + modalidade +
               "\nInstituição: " + instituicao;
    }
}