import java.util.Scanner;
import java.util.Random;

public class Carro {
    private int identificacao;//um número aleatória de 0 a 19
    private Roda[] rodas;
    private double combustivel;//inicialmente com 3,5 litros
    private double valorVenda;//pode ficar a meu critério
    private int ipva;//1 para pago e 0 para não pago
    private int distanciaPercorrida;

    public Carro(int ident) {
        this.identificacao = ident;
        this.rodas = new Roda[4];
        this.combustivel = 3.5;
        this.valorVenda = 40000;
        Random aleatorio = new Random();
        int sorteio = aleatorio.nextInt(100);
        if (sorteio % 2 == 0) {
            this.ipva = 1;
        } else {
            this.ipva = 0;
        }
        this.adicionarRoda();
    }

    public void adicionarRoda() {
        Random aleatorio = new Random();
        int sorteio;
        for (int i = 0; i < 4; i++) {
            sorteio = aleatorio.nextInt(100);
            if (sorteio % 2 == 0) {
                this.rodas[i] = new Roda(1);
            } else {
                this.rodas[i] = new Roda(0);
            }
        }
    }

    public void imprimirCarro(int id) {
        if (this.identificacao == id) {
            System.out.println("Identificacao -> " + this.identificacao);
            for (int i = 0; i < 4; i++)
                this.rodas[i].imprimirRoda();

            System.out.println("Quantidade combustivel: " + this.combustivel);
            System.out.println("Valor de venda: " + this.valorVenda);
            if (this.ipva == 0)
                System.out.println("O IPVA nao foi pago.");
            else if (this.ipva == 1)
                System.out.println("O IPVA foi pago.");
            else
                System.out.println("Informacao sobre ipva indisponível.");
        }

    }

    public void imprimirTodosCarros() {
        System.out.println("Identificacao -> " + this.identificacao);
        for (int i = 0; i < 4; i++)
            this.rodas[i].imprimirRoda();

        System.out.println("Quantidade combustivel: " + this.combustivel);
        System.out.println("Valor de venda: " + this.valorVenda);
        if (this.ipva == 0)
            System.out.println("O IPVA nao foi pago.");
        else if (this.ipva == 1)
            System.out.println("O IPVA foi pago.");
        else
            System.out.println("Informacao sobre ipva indisponível.");

        System.out.println(" ");
    }

    public void removerVeiculo(int id, Carro a) {
        if (a.identificacao == id) {
            a = null;
            System.out.println("O veiculo numero " + id + " foi removido da corrida.");
        }
    }

    public void abastecerVeiculo(int id, double comb, Carro b) {
        if (b.identificacao == id) {
            if (b.combustivel < 3.5) {
                b.combustivel = b.combustivel + 3.5;
                if (b.combustivel > 3.5) {
                    double abastecido;
                    abastecido = b.combustivel - 3.5;
                    b.combustivel = 3.5;
                    System.out.println("O carro numero " + id + " foi abastecido com " + abastecido + " litros");
                } else {
                    System.out.println("O carro numero " + id + " foi abastecido com " + comb + " litros");
                }
            } else {
                System.out.println("O carro esta com o tanque cheio.");
            }
        }
    }

    public void movimentarVeiculo(int id, int distancia, Carro c) {
        if (c.identificacao == id) {
            //o carro se move se tem combustivel para CENTRAL
            //cada distancia consome 0.55L de combustivel
            //se move se todos os pneus estiver calibrados
            //e por fim se move se o IPVA esta pago
            int verificaPneus = 1;
            for (int i = 0; i < 4; i++) {
                if (c.rodas[i] != null)
                    verificaPneus = c.rodas[i].verificaCalibragem(c.rodas[i]);
            }
            if (verificaPneus == 1) {
                if (c.ipva == 1) {
                    double combNecessario;
                    combNecessario = distancia * 0.55;
                    if (c.combustivel >= combNecessario) {
                        System.out.println("O veiculo se movimentou " + distancia * 5 + " blocos de distancia.");
                        c.combustivel = c.combustivel - combNecessario;
                        c.distanciaPercorrida = c.distanciaPercorrida + distancia;
                    } else {
                        System.out.println("O veiculo nao se movimenta, sem combustivel suficiente.");
                    }
                } else {
                    System.out.println("O veiculo nao se movimenta, IPVA nao pago.");
                }
            } else {
                System.out.println("O veiculo nao se movimenta, pneus nao calibrados.");
            }
        }
    }

    public void movimentaTodosVeiculos(int distancia) {
        int verificaPneus = 1;
        for (int i = 0; i < 4; i++) {
            if (this.rodas[i] != null)
                verificaPneus = this.rodas[i].verificaCalibragem(this.rodas[i]);
        }
        if (verificaPneus == 1) {
            if (this.ipva == 1) {
                double combNecessario;
                combNecessario = distancia * 0.55;
                if (this.combustivel >= combNecessario) {
                    System.out.println("O veiculo se movimentou " + distancia * 5 + " blocos de distancia.");
                    this.combustivel = this.combustivel - combNecessario;
                    this.distanciaPercorrida = this.distanciaPercorrida + distancia;
                } else {
                    System.out.println("O veiculo " + this.identificacao + " nao se movimenta, sem combustivel suficiente.");
                }
            } else {
                System.out.println("O veiculo " + this.identificacao + " nao se movimenta, IPVA nao pago.");
            }
        } else {
            System.out.println("O veiculo " + this.identificacao + " nao se movimenta, pneus nao calibrados.");
        }
    }

    public void calibrarOuEsvaziarEspecifico(int id, int caliEsva, int roda, Carro a) {
        if (a.identificacao == id) {
            rodas[roda].esvaCaliEspe(caliEsva);
        }
    }

    public void calibrarTodasRodas(int id, Carro a) {
        if (a.identificacao == id) {
            for (int i = 0; i < 4; i++) {
                rodas[i].esvaCaliEspe(1);
            }
        }
    }

    public void esvaziarTodasRodas(int id, Carro a) {
        if (a.identificacao == id) {
            for (int i = 0; i < 4; i++) {
                rodas[i].esvaCaliEspe(0);
            }
        }
    }
}
