package Etapa2;
public class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getIntencoes() {
        return intencoesVotos;
    }

    public void setIntencoes(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }

    @Override
    public String toString() {
        return "Dados do candidato - Nome: " + getNome() + ", Partido: " + getPartido() + ", intenções de voto: " + getIntencoes();
    }
    
}
