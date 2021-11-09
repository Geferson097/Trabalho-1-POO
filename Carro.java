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
        this.identificacao = ident; //setar a identificação da classe Carro com a variavel que vem de ComandoCentral
        this.rodas = new Roda[4];  //Criar um novo vetor de Rodas com tamanho 4 e atribuir a variavel roda da classe Carro atravez do this
        this.combustivel = 3.5;    //setar o valor de combustivel da classe Carro
        this.valorVenda = 40000;   //setar o valor de venda da classe Carro
        Random aleatorio = new Random();  //criar um numero aleatorio
        int sorteio = aleatorio.nextInt(100);  //filtrar para o numero aleatorio ser um inteiro entre 0 e 99
        if (sorteio % 2 == 0) {     //verificar se o numero aleatorio  é par o ipva é dito true (pago)
            this.ipva = true;
        } else {                   //se for impar o ipva é dito false (não pago)
            this.ipva = false;
        }
        this.adicionarRoda();   //chama o metodo para criar uma roda e definir as variaveis dela
    }

    private void setRemovido(boolean b) { this.removido=b;}   //seta o valor da variavel removido da classe Carro com o parametro passado
    public boolean getRemovido(){return this.removido;}       //retorna o valor da variavel removido
    public int getDistanciaPercorrida() { return this.distanciaPercorrida; }    //retorna o valor da variavel distanciaPercorrida

    public void adicionarRoda() {               //metodo para definir os atributos da roda
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

    public void imprimirCarro(int id) {         //metodo para imprimir um carro especifico
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

    public void imprimirTodosCarros() {     //metodo para imprimir todos os carros presentes na corrida
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

    public void removerVeiculo(int id, Carro a) {   //metodo para remover um veiculo especifico da corrida atraves de seu ID
        if (a!= null) {
            if(a.identificacao == id)
            {
                a.setRemovido(true);
                System.out.println("O veiculo numero " + id + " foi removido da corrida.");
            }

        }
    }

    public void abastecerVeiculo(int id, double comb, Carro b) {    //metodo para abastecer um veiculo especifico da corrida atraves de seu ID
        if (b.identificacao == id) {
            if (b.combustivel < 3.5) {
                b.combustivel = b.combustivel + comb;
                System.out.println("O carro numero " + id + " foi abastecido com " + comb + " litros");
            } else {
                System.out.println("O carro esta com o tanque cheio.");
            }
        }
    }

    public void movimentarVeiculo(int id, int distancia, Carro c) {         //metodo para movimentar um veiculo especifico da corrida atraves de seu ID
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

    public void movimentaTodosVeiculos(int distancia) {     //metodo para todos os veiculos presentes na corrida
        boolean verificaPneus = true;
        for (int i = 0; i < 4; i++) {
            if (this.rodas[i] != null)
                verificaPneus = this.rodas[i].verificaCalibragem(this.rodas[i]);
        }
        if (verificaPneus == true) {            //verifica que para o veiculo se movimentar os pneus devem estar calibrados
            if (this.ipva == true) {            // verifica que para um veiculo se movimentar o IPVA deve estar pago
                double combNecessario;
                combNecessario = distancia * 0.55;  //faz o calculo do combustivel nescessario para movimentar
                if (this.combustivel >= combNecessario) {       //verifica se tem combustivel suficiente
                    System.out.println("O veiculo " + this.identificacao +" se movimentou " + distancia * 5 + " blocos de distancia.");
                    this.combustivel = this.combustivel - combNecessario;   //define o novo valor do combustivel apartir do que foi gasto
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

    public void calibrarOuEsvaziarEspecifico(int id, int caliEsva, int roda, Carro a) {  //metodo para calibrar um pneu de um veiculo especifico da corrida atraves de seu ID
        if (a.identificacao == id) {
            rodas[roda].esvaCaliEspe(caliEsva);
        }
    }

    public void calibrarTodasRodas(int id, Carro a) {   //metodo para calibrar todos os peneus um veiculo especifico da corrida atraves de seu ID
        if (a.identificacao == id) {
            for (int i = 0; i < 4; i++) {
                rodas[i].esvaCaliEspe(1);    //se o parametro passado for 1 calibra a roda
            }
        }
    }

    public void esvaziarTodasRodas(int id, Carro a) {    //metodo para descalibrar todos os peneus um veiculo especifico da corrida atraves de seu ID
        if (a.identificacao == id) {
            for (int i = 0; i < 4; i++) {
                rodas[i].esvaCaliEspe(0);           //se o parametro passado for 0 descalibra a roda
            }
        }
    }

}
