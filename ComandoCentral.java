import java.util.Scanner;
import java.util.Random;


public class ComandoCentral {

    private static final int max = 20;
    private static final float combIni = 3.5F ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        Carro[] listaCorrida = new Carro[max];
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
            int aux=0;
            switch (opcao) {
                case 1:

                    System.out.println("Incluindo um veiculo...");
                    System.out.println("-------------------------------------------------");
                    Random aleatorio = new Random(System.nanoTime());
                    int ident = aleatorio.nextInt(100);
                    for (int i = 0; i < listaCorrida.length; i++) {
                        if (listaCorrida[i] != null && listaCorrida[i].getIdentificacao() == ident)
                        {
                            ident = aleatorio.nextInt(100);
                        }
                    }
                    for (int i = 0; i < listaCorrida.length; i++)
                    {
                        if (listaCorrida[i]==null)
                        {
                            listaCorrida[i] = new Carro(ident, combIni);
                            System.out.println("O veiculo de numero " + ident + " foi adicionado na posicao " + i);
                            aux++;
                            break;
                        }
                        if(aux==19 ) System.out.print("Cheio, remova um veiculo caso queira adicionar mais");
                    }

                    System.out.print("\n\n");
                    break;

                case 2:
                    System.out.println("Removendo um veiculo...");
                    System.out.println("-----------------------");
                    System.out.println("Informe o numero do veiculo a ser removido: ");
                    id = sc.nextInt();
                    for (int i = 0; i < listaCorrida.length; i++) {
                        if (listaCorrida[i] != null)
                            if(listaCorrida[i].getIdentificacao()==id)
                            {
                                listaCorrida[i]=null;
                                System.out.print("O veiculo "+ id + " foi removido");
                                aux--;
                            }
                    }
                    System.out.print("\n\n");
                    break;

                case 3:
                    System.out.println("Abastecendo um veiculo...");
                    System.out.println("Informe o id do veiculo que sera abastecido: ");
                    id = sc.nextInt();
                    float comb;
                    System.out.println("Informe a quantidade de combustivel que sera abastecido: ");
                    comb = sc.nextFloat();

                    for (int i = 0; i < listaCorrida.length; i++) {
                        if (listaCorrida[i] != null)
                            if(listaCorrida[i].getIdentificacao()==id)
                            {
                                listaCorrida[i].setCombustivel(comb);
                                System.out.print("O veiculo "+ id + " foi abastecido e agora possui "+listaCorrida[i].getCombustivel() + " litros");
                            }

                    }
                    System.out.print("\n\n");
                    break;

                case 4:
                    System.out.println("Movimentando um veiculo...");
                    System.out.println("Informe o id do veiculo que vai se movimentar: ");
                    id = sc.nextInt();
                    for (int i = 0; i < listaCorrida.length; i++) {
                        if (listaCorrida[i] != null) {
                            if(listaCorrida[i].getIdentificacao()==id)
                            {
                                movimentarVeiculos(listaCorrida[i]);
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 5:
                    System.out.println("Movimentando todos os veiculos...");
                    for (int i = 0; i < listaCorrida.length; i++) {
                        if (listaCorrida[i] != null)
                        {
                            movimentarVeiculos(listaCorrida[i]);
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 6:
                    System.out.println("Imprimindo todos os dados de um veiculo...");
                    System.out.println("Informe o numero do veiculo que se quer os dados: ");
                    id = sc.nextInt();
                    for (int i = 0; i < listaCorrida.length; i++) {
                        if (listaCorrida[i] != null ) {
                            if(listaCorrida[i].getIdentificacao()==id)
                            {
                                System.out.println("Identificacao -> " + listaCorrida[i].getIdentificacao());
                                listaCorrida[i].imprimirDadosCarro();
                                System.out.println("\n");
                            }
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 7:
                    System.out.println("Imprimindo todos os dados de todos os veiculos...");
                    for (int i = 0; i < listaCorrida.length; i++) {
                        if (listaCorrida[i] != null )
                        {
                            System.out.println("Identificacao -> " + listaCorrida[i].getIdentificacao());
                            listaCorrida[i].imprimirDadosCarro();
                            System.out.println("\n");
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
                            if(listaCorrida[i].getIdentificacao()==id)
                            {
                                listaCorrida[i].calibrarOuEsvaziarRodas(caliEsva, roda);
                            }
                        }
                    }
                    if(caliEsva ==1) System.out.println("A roda " +roda + " do carro " + id + " foi calibrado");
                    else System.out.println("A roda " +roda + " do carro " + id + " foi descalibrado");
                    System.out.print("\n\n");
                    break;
                case 9:
                    System.out.println("Calibrando todos os pneus de um veiculo especifico...");
                    System.out.println("Informe a id do carro: ");
                    id = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null) {
                            if(listaCorrida[i].getIdentificacao()==id)
                            {
                                listaCorrida[i].calibrarOuEsvaziarRodas(true);
                            }
                        }
                    }
                    System.out.println("Todos os pneus do veiculo " + id + " foram calibrados");
                    System.out.print("\n\n");
                    break;

                case 10:
                    System.out.println("Esvaziando todos os pneus de um veiculo especifico...");
                    System.out.println("Informe a id do carro: ");
                    id = sc.nextInt();
                    for (int i = 0; i < 20; i++) {
                        if (listaCorrida[i] != null) {
                            if(listaCorrida[i].getIdentificacao()==id)
                            {
                                listaCorrida[i].calibrarOuEsvaziarRodas(false);
                            }
                        }

                    }
                    System.out.println("Todos os pneus do veiculo " + id + " foram esvaziados");
                    System.out.print("\n\n");
                    break;

                case 11: //imprimir a pista de corrida
                    System.out.println("Imprimindo pista de corrida...");

                    for(int i = 0; i<listaCorrida.length; i++)
                    {
                        if(listaCorrida[i]!=null)
                        {
                            System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) + "    ____\n");
                            System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) +" __/  |_ \\_\n");
                            System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) +"|  _     _``-. \n");
                            System.out.print(getWhiteSpace(listaCorrida[i].getDistanciaPercorrida()) +"'-(_)---(_)--'\n\n\n");
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

    static void movimentarVeiculos(Carro c) {     //metodo para movimentar os veiculos presentes na corrida
        boolean verificaPneus = true;
        int distancia=5;
        for (int i = 0; i < 4; i++) {
            if (!c.getRodas(i).getCalibragem())
            {
                System.out.println("O veiculo " +c.getIdentificacao()+ " possui o pneu "+ i + " descalibrado, não movimenta");
                verificaPneus = false;
                break;
            }
        }
        if (verificaPneus == true) {            //verifica que para o veiculo se movimentar os pneus devem estar calibrados
            if (c.getIpva()) {            // verifica que para um veiculo se movimentar o IPVA deve estar pago
                double combNecessario;
                combNecessario = distancia * 0.55;  //faz o calculo do combustivel nescessario para movimentar
                if (c.getCombustivel()>= combNecessario) {       //verifica se tem combustivel suficiente
                    System.out.println("O veiculo " + c.getIdentificacao() + " se movimentou " + distancia * 5 + " blocos de distancia.");
                    c.setCombustivel(combNecessario);  //define o novo valor do combustivel apartir do que foi gasto
                    c.setdistanciaPercorrida(distancia);
                } else {
                    System.out.println("O veiculo " + c.getIdentificacao() + " nao se movimenta, sem combustivel suficiente.");
                }
            } else {
                System.out.println("O veiculo " + c.getIdentificacao() + " nao se movimenta, IPVA nao pago.");
            }
        }
    }


    static String getWhiteSpace(int size) {
        StringBuilder builder = new StringBuilder(size);
        for(int i = 0; i <size ; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }

}

