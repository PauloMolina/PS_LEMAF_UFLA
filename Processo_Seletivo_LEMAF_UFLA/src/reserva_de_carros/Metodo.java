package reserva_de_carros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Metodo {
    
    //Método de leitura.
    public void lerEntrada(Locadora south, Locadora west, Locadora north){
        System.out.printf("Informe o tipo do carro, número de passageiros e dias desejados: \n");
        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine();
        String pmts[] = entrada.split(": ");
        String datas[] = pmts[2].split(", ");
        Carro carroPedido = new Carro(pmts[0], Integer.parseInt(pmts[1]), datas);
        solucao(carroPedido, south, west, north);
    }
    
    public void lerTestes(Locadora south, Locadora west, Locadora north){
        try {
            FileReader arq = new FileReader("Testes.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                String pmts[] = linha.split(": ");
                Carro novoCarro = new Carro(pmts[0], Integer.parseInt(pmts[1]), pmts[2].split(", "));
                solucao(novoCarro, south, west, north);
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }
    
    public void solucao(Carro carroAtual, Locadora south, Locadora west, Locadora north){
        int precoSouth;
        int precoWest;
        int precoNorth;
        
        if(carroAtual.getNumPassageiros()<1 || carroAtual.getNumPassageiros()>7){
            System.out.println("Insira um número de passageiros válido(1~7)");
        } else {
            if(carroAtual.getNumPassageiros() > 4) {
                System.out.println("SUV: NorthCar");
            } else {
                if(carroAtual.getNumPassageiros() > 2) {
                    precoSouth = south.calcularPreco(carroAtual);
                    precoNorth = north.calcularPreco(carroAtual);
                    if(precoNorth < precoSouth){
                        System.out.println("SUV: NorthCar");
                    }else{
                        System.out.println("Compacto: SouthCar");
                    }
                }else{
                    precoSouth = south.calcularPreco(carroAtual);
                    precoNorth = north.calcularPreco(carroAtual);
                    precoWest = west.calcularPreco(carroAtual);
                    if(precoWest <= precoSouth && precoWest<=precoNorth){
                        System.out.println("Esportivo: WestCar");
                    }else{
                        if(precoSouth<=precoNorth && precoSouth<=precoWest){
                            System.out.println("Compacto: SouthCar");
                        }else{
                            System.out.println("SUV: NorthCar");
                        }
                    }
                }
            }
        }
    }
}
