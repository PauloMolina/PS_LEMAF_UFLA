package reserva_de_carros;

public class Locadora {
    
    private int precoDiaSemana;
    private int precoDiaSemanaCartao;
    private int precoFimSemana;
    private int precoFimSemanaCartao;

    public Locadora(int precoDiaSemana, int precoDiaSemanaCartao, int precoFimSemana, int precoFimSemanaCartao) {
        this.precoDiaSemana = precoDiaSemana;
        this.precoDiaSemanaCartao = precoDiaSemanaCartao;
        this.precoFimSemana = precoFimSemana;
        this.precoFimSemanaCartao = precoFimSemanaCartao;
    }

    public int calcularPreco(Carro carroEntrada){
        int preco = 0;
        if(carroEntrada.getTipoCliente().equals("Normal")){
            for (int i = 0; i < carroEntrada.getDisponibilidade().length; i++) {
                String pmts[] = carroEntrada.getDisponibilidade()[i].split(" ");
                if(pmts[1].equals("(sab)") || pmts[1].equals("(dom)")){
                    preco += precoFimSemana;
                }else{
                    preco += precoDiaSemana;
                }
            }
        }else{
            for (int i = 0; i < carroEntrada.getDisponibilidade().length; i++) {
                String pmts[] = carroEntrada.getDisponibilidade()[i].split(" ");
                if(pmts[1].equals("(sab)") || pmts[1].equals("(dom)")){
                    preco += precoFimSemanaCartao;
                }else{
                    preco += precoDiaSemanaCartao;
                }
            }
        }
        return preco;
    }
}
