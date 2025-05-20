package entity;

public class animalEntity {

    public animalEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEstadoSaude() {
        return estadoSaude;
    }

    public void setEstadoSaude(String estadoSaude) {
        this.estadoSaude = estadoSaude;
    }

    public String getHistoricoVacinas() {
        return historicoVacinas;
    }

    public void setHistoricoVacinas(String historicoVacinas) {
        this.historicoVacinas = historicoVacinas;
    }

    public String getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(String dataResgate) {
        this.dataResgate = dataResgate;
    }

    private int id;
    private String nome;
    private String especie;
    private String raca;
    private String idade;
    private String estadoSaude;
    private String historicoVacinas;
    private String dataResgate;

    public animalEntity(int id, String nome, String especie, String raca, String idade, String estadoSaude, String historicoVacinas, String dataResgate) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.estadoSaude = estadoSaude;
        this.historicoVacinas = historicoVacinas;
        this.dataResgate = dataResgate;
    }

}
