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


    
    public int getIdentificacao() { return identificacao; }            //retorna o valor da variavel identificacao
    public int getDistanciaPercorrida() { return this.distanciaPercorrida; }    //retorna o valor da variavel distanciaPercorrida
    public double getCombustivel() { return this.combustivel; }     //retorna o valor da variavel combustive
    public boolean getIpva() { return ipva;}                //retorna o valor da variavel IPVA
    public Roda getRodas(int i) { return rodas[i]; }        //retorna o valor da i-ésima roda passada como parametro

    public void setCombustivel(double comb) { this.combustivel-=comb; }  //Seta o valor do combustivel após um quantia ser gasta para o carro se movimentar
    public void setCombustivel(float comb) { this.combustivel+=comb; }   //Seta o valor do combustivel após abastecer um carro
    public void setdistanciaPercorrida(int dist) {this.distanciaPercorrida +=dist; }   //Seta o atributo distancia percorrida de um carro

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

    private void calibrarOuEsvaziarRodas(boolean caliEsva, int roda)  //metodo para settar o valor da variavel calibragem como true (calibrado) ou false (descalibrado)
    {
        if (caliEsva) {
            rodas[roda].setCalibragem(caliEsva);
        } else {
            rodas[roda].setCalibragem(caliEsva);
        }
    }
    public void calibrarOuEsvaziarRodas(int caliEsva, int roda)   //metodo para calibrar um pneu de um veiculo especifico da corrida atraves de seu ID
    {
        if(caliEsva==1)
        {
            calibrarOuEsvaziarRodas(true,roda);
        }
        else
        {
            calibrarOuEsvaziarRodas(false,roda);
        }
    }

    public void calibrarOuEsvaziarRodas(boolean flag) //metodo para calibrar ou esvaziar todos os pneus (se flag for true calibra, se for false descalibra)
    {
        if(flag)  //se o parametro for true ele calibra todas as rodas
        {
            for (int i = 0; i < 4; i++)
            {
                calibrarOuEsvaziarRodas(flag,i);    //true calibra a roda
            }
        }
        else
        {
            for (int i = 0; i < 4; i++)
            {
                calibrarOuEsvaziarRodas(flag,i);    //false descalibra a roda
            }
        }
    }

    public void imprimirDadosCarro()    //metodo para imprimir os dados de um carro
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
}
