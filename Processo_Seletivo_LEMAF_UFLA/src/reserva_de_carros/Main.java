package reserva_de_carros;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Metodo metodo = new Metodo();
        Locadora southCar = new Locadora(210, 150, 200, 90);
        Locadora westCar = new Locadora(530, 150, 200, 90);
        Locadora northCar = new Locadora(630, 580, 600, 590);

        System.out.println("\nBem Vindo!");
        System.out.println("Opção 1: Rodar arquivo de testes");
        System.out.println("Opção 2: Entrar com um pedido");
        System.out.println("\nDigite o número de acordo com a opção desejada: ");
        Scanner scan = new Scanner(System.in);
        int opcao= scan.nextInt();
        if(opcao == 1){
            metodo.lerTestes(southCar, westCar, northCar);
        }else{
            metodo.lerEntrada(southCar, westCar, northCar);
        }      
    }
}
