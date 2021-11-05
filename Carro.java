import java.util.Random;


public class Carro {
    private int identificacao;//um número aleatória de 0 a 19
    private Roda[] rodas;
    private double combustivel = 3.5;//inicialmente com 3,5 litros
    private double valorVenda;//pode ficar a meu critério
    private boolean ipva;//true para pago e false para não pago
    private int distanciaPercorrida;
    private  boolean removido = false;



    public Carro(int ident) {
        this.identificacao = ident;
        this.rodas = new Roda[4];
        this.combustivel = 3.5;
        this.valorVenda = 40000;
        Random aleatorio = new Random();
        int sorteio = aleatorio.nextInt(100);
        if (sorteio % 2 == 0) {
            this.ipva = true;
        } else {
            this.ipva = false;
        }
        this.adicionarRoda();
    }

    private void setRemovido(boolean b) { this.removido=b;}
    public boolean getRemovido(){return this.removido;}
    public int getDistanciaPercorrida() { return this.distanciaPercorrida; }

    public void adicionarRoda() {
        Random aleatorio = new Random();
        int sorteio;
        for (int i = 0; i < 4; i++) {
            sorteio = aleatorio.nextInt(100);
            if (sorteio % 2 == 0) {
                this.rodas[i] = new Roda(true);
            } else {
                this.rodas[i] = new Roda(false);
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
            if (this.ipva == false)
                System.out.println("O IPVA nao foi pago.");
            else if (this.ipva == true)
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
        if (this.ipva == false)
            System.out.println("O IPVA nao foi pago.");
        else if (this.ipva == true)
            System.out.println("O IPVA foi pago.");
        else
            System.out.println("Informacao sobre ipva indisponível.");

        System.out.println(" ");
    }

    public void removerVeiculo(int id, Carro a) {
        if (a!= null) {
            if(a.identificacao == id)
            {
                a.setRemovido(true);
                System.out.println("O veiculo numero " + id + " foi removido da corrida.");
            }

        }
    }



    public void abastecerVeiculo(int id, double comb, Carro b) {
        if (b.identificacao == id) {
            if (b.combustivel < 3.5) {
                b.combustivel = b.combustivel + comb;
                System.out.println("O carro numero " + id + " foi abastecido com " + comb + " litros");
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
            boolean verificaPneus = true;
            for (int i = 0; i < 4; i++) {
                if (c.rodas[i] != null)
                    verificaPneus = c.rodas[i].verificaCalibragem(c.rodas[i]);
            }
            if (verificaPneus == true) {
                if (c.ipva == true) {
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
        boolean verificaPneus = true;
        for (int i = 0; i < 4; i++) {
            if (this.rodas[i] != null)
                verificaPneus = this.rodas[i].verificaCalibragem(this.rodas[i]);
        }
        if (verificaPneus == true) {
            if (this.ipva == true) {
                double combNecessario;
                combNecessario = distancia * 0.55;
                if (this.combustivel >= combNecessario) {
                    System.out.println("O veiculo " + this.identificacao +" se movimentou " + distancia * 5 + " blocos de distancia.");
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
