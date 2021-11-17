import java.util.Random;


public class Carro {
    private int identificacao;//um número aleatória de 0 a 19
    private Roda[] rodas;
    private double combustivel = 3.5;//inicialmente com 3,5 litros
    private double valorVenda;//pode ficar a meu critério
    private boolean ipva;//true para pago e false para não pago
    private int distanciaPercorrida;




    public Carro(int ident,float comb) {
        this.identificacao = ident; //setar a identificação da classe Carro com a variavel que vem de ComandoCentral
        this.rodas = new Roda[4];  //Criar um novo vetor de Rodas com tamanho 4 e atribuir a variavel roda da classe Carro atravez do this
        this.combustivel = comb;    //setar o valor de combustivel da classe Carro
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


    
    public int getIdentificacao() { return identificacao; }
    public int getDistanciaPercorrida() { return this.distanciaPercorrida; }    //retorna o valor da variavel distanciaPercorrida
    public double getCombustivel() { return this.combustivel; }


    public void SetCombustivel(double comb) { this.combustivel+=comb; }

    public void adicionarRoda() {               //metodo para definir os atributos da roda
        Random aleatorio = new Random();
        int sorteio;
        for (int i = 0; i < 4; i++)
        {
            sorteio = aleatorio.nextInt(100);
            if (sorteio % 2 == 0)
            {
                this.rodas[i] = new Roda(true);
            }
            else
            {
                this.rodas[i] = new Roda(false);
            }
        }
    }

    public void calibrarOuEsvaziarPneuEspecifico(int caliEsva, int roda)   //metodo para calibrar um pneu de um veiculo especifico da corrida atraves de seu ID
    {
        if(caliEsva==1)
        {
            rodas[roda].esvaCaliEspe(true);
        }
        else
        {
            rodas[roda].esvaCaliEspe(true);
        }
    }

    public void calibrarOuEsvaziarTodasAsRodas(boolean flag) //metodo para calibrar ou esvaziar todos os pneus (se flag for true calibra, se for false descalibra)
    {
        if(flag)  //se o parametro for true ele calibra todas as rodas
        {
            for (int i = 0; i < 4; i++)
            {
                rodas[i].esvaCaliEspe(flag);    //true calibra a roda
            }
        }
        else
        {
            for (int i = 0; i < 4; i++)
            {
                rodas[i].esvaCaliEspe(flag);    //false descalibra a roda
            }
        }
    }

    public void imprimirDadosCarro()    //metodo para imprimir um carro especifico
    {
        for (int i = 0; i < 4; i++)
        {
            this.rodas[i].imprimirRoda();
        }
        System.out.println("Quantidade combustivel: " + this.combustivel);
        System.out.println("Valor de venda: " + this.valorVenda);
        if (this.ipva == false)
        {
            System.out.println("O IPVA nao foi pago.");
        }
        else if (this.ipva == true) {
            System.out.println("O IPVA foi pago.");
        }
        else {
            System.out.println("Informacao sobre ipva indisponível.");
        }
    }

    public void movimentaVeiculos() {     //metodo para movimentar os veiculos presentes na corrida
        boolean verificaPneus = true;
        int distancia=5;
        for (int i = 0; i < 4; i++) {
            if (!rodas[i].verificaCalibragem())
            {
                System.out.println("O veiculo " + identificacao + " possui o pneu "+ i + " descalibrado, não movimenta");
                verificaPneus = false;
                break;
            }
        }
        if (verificaPneus == true) {            //verifica que para o veiculo se movimentar os pneus devem estar calibrados
            if (ipva == true) {            // verifica que para um veiculo se movimentar o IPVA deve estar pago
                double combNecessario;
                combNecessario = distancia * 0.55;  //faz o calculo do combustivel nescessario para movimentar
                if (combustivel >= combNecessario) {       //verifica se tem combustivel suficiente
                    System.out.println("O veiculo " + this.identificacao + " se movimentou " + distancia * 5 + " blocos de distancia.");
                    combustivel -= combNecessario;   //define o novo valor do combustivel apartir do que foi gasto
                    distanciaPercorrida += distancia;
                } else {
                    System.out.println("O veiculo " + identificacao + " nao se movimenta, sem combustivel suficiente.");
                }
            } else {
                System.out.println("O veiculo " + identificacao + " nao se movimenta, IPVA nao pago.");
            }
        }
    }



}
