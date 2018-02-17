package reserva_de_carros;

public class Carro {
    
    private String tipoCliente;
    private int numPassageiros;
    private String[] disponibilidade;

    public Carro(String nome, int numPassageiros, String[] disponibilidade) {
        this.tipoCliente = nome;
        this.numPassageiros = numPassageiros;
        this.disponibilidade = disponibilidade;
    }
    
    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String nome) {
        this.tipoCliente = nome;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public String[] getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String[] disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
}
