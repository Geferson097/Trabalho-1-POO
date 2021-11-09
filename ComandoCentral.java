import java.util.Scanner;
import java.util.Random;


public class ComandoCentral extends Carro{

    private static final int max = 20;
    public static Carro[] veiculos = new Carro[max];

    public ComandoCentral(int ident) {
        super(ident);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        Carro[] listaCorrida = new Carro[max];
        int posicao = 0;
        int id;
        //menu iterativo para acessar as funções
        do {
            System.out.println("COMANDO CENTRAL");
            System.out.println(" ");
            System.out.println("1 - Incluir um veiculo");
            System.out.println("2 - Remover um veiculo");
            System.out.println("3 - Abastecer um veiculo");
            System.out.println("4 - Movimentar um veiculo");
            System.out.println("5 - Movimentar todos os veiculos");
            System.out.println("6 - Imprimir todos os dados de um veiculo");
            System.out.println("7 - Imprimir todos os dados de todos os veiculos");
            System.out.println("8 - Esvaziar/calibrar um pneu especifico");//solicitar qualveículo e qual pneu
            System.out.println("9 - Calibrar todos os pneus de um veículo especifico");
            System.out.println("10 - Esvaziar todos os pneus de um veículo especifico");
            System.out.println("11 - Imprime pista de corrida");
            System.out.println("12 - Sair da aplição");

            System.out.println("Digite sua opçao: ");
            opcao = sc.nextInt();
            System.out.println(" ");
            switch (opcao) {
                case 1:

                    System.out.println("Incluindo um veiculo...");
                    System.out.println("-------------------------------------------------");
                    Random aleatorio = new Random(System.nanoTime());
                    int ident = aleatorio.nextInt(100);

                    if (posicao<20) {
                        if(listaCorrida[posicao] == null)
                        {
                            listaCorrida[posicao] = new Carro(ident);
                            System.out.println("O veiculo de numero " + ident + " foi adicionado na posicao " + posicao);
                            posicao++;
                        }
                    }
                    else{
                        for (int i = 0; i < max; i++) {
                            if (listaCorrida[i].getRemovido() == true) {
                                listaCorrida[i] = new Carro(ident);
                                System.out.println("O veiculo de numero " + ident + " foi adicionado na posicao " + i);
                                break;
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 2:
                    System.out.println("Removendo um veiculo...");
                    System.out.println("-----------------------");
                    System.out.println("Informe o numero do veiculo a ser removido: ");
                    id = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null)
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].removerVeiculo(id, listaCorrida[i]);
                            }
                    }
                    System.out.print("\n\n");
                    break;

                case 3:
                    System.out.println("Abastecendo um veiculo...");
                    System.out.println("Informe o id do veiculo que sera abastecido: ");
                    id = sc.nextInt();
                    double comb;
                    System.out.println("Informe a quantidade de combustivel que sera abastecido: ");
                    comb = sc.nextDouble();

                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null)
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].abastecerVeiculo(id, comb, listaCorrida[i]);
                            }

                    }
                    System.out.print("\n\n");
                    break;

                case 4:
                    System.out.println("Movimentando um veiculo...");
                    System.out.println("Informe o id do veiculo que vai se movimentar: ");
                    id = sc.nextInt();
                    int distancia = 0;
                    System.out.println("Informe o quanto ira se movimentar: ");
                    distancia = sc.nextInt();

                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null) {
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].movimentarVeiculo(id, distancia, listaCorrida[i]);
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 5:
                    System.out.println("Movimentando todos os veiculos...");
                    System.out.println("Informe o quanto todos os carros se movimentarao: ");
                    distancia = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null) {
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].movimentaTodosVeiculos(distancia);
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 6:
                    System.out.println("Imprimindo todos os dados de um veiculo...");
                    System.out.println("Informe o numero do veiculo que se quer os dados: ");
                    id = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null ) {
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].imprimirCarro(id);
                            }
                            else System.out.println("Veiculo não esta na corrida");
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 7:
                    System.out.println("Imprimindo todos os dados de todos os veiculos...");
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null ) {
                            if(!listaCorrida[i].getRemovido()){
                                listaCorrida[i].imprimirTodosCarros();
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 8:
                    System.out.println("Esvaziando/calibrando um pneu especifico...");
                    System.out.println("Informe a id do carro: ");
                    id = sc.nextInt();
                    int roda;
                    System.out.println("Informe a roda que sera calibrada/evaziada: ");
                    roda = sc.nextInt();
                    int caliEsva;
                    System.out.println("Digite 1 para calibrar e 0 para esvaziar: ");
                    caliEsva = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null) {
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].calibrarOuEsvaziarEspecifico(id, caliEsva, roda, listaCorrida[i]);
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;
                case 9:
                    System.out.println("Calibrando todos os pneus de um veiculo especifico...");
                    System.out.println("Informe a id do carro: ");
                    id = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null) {
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].calibrarTodasRodas(id, listaCorrida[i]);
                            }

                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 10:
                    System.out.println("Esvaziando todos os pneus de um veiculo especifico...");
                    System.out.println("Informe a id do carro: ");
                    id = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null) {
                            if(!listaCorrida[i].getRemovido())
                            {
                                listaCorrida[i].esvaziarTodasRodas(id, listaCorrida[i]);
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 11: //imprimir a pista de corrida
                    System.out.println("Imprimindo pista de corrida...");

                    for(int i = 0; i<veiculos.length; i++){
                        if(listaCorrida[i]!=null){
                            if(!listaCorrida[i].getRemovido())
                            {
                                System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) + "    ____\n");
                                System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) +" __/  |_ \\_\n");
                                System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) +"|  _     _``-. \n");
                                System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) +"'-(_)---(_)--'\n\n\n");
                            }

                        }
                    }
                    break;

                case 12:
                    System.out.println("Saindo da operacao...");
                    break;

                default:
                    System.out.println("Opçao Invalida");
                    break;
            }
        } while (opcao != 12);
    }
    static String getWhiteSpace(int size) {
        StringBuilder builder = new StringBuilder(size);
        for(int i = 0; i <size ; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }
}

