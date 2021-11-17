public class Roda {
    private boolean calibragem = true; //1 para calibrado e 0 para não calibrado

    public Roda(boolean cali) {
        this.calibragem = cali;
    }

    public boolean getCalibragem(){ return calibragem; }

    public void setCalibragem(boolean calibragem) { this.calibragem = calibragem; }

    public void imprimirRoda() {
        if ((calibragem == false) || (calibragem == true)) {
            if (calibragem == false)
                System.out.println("Roda nao calibrada.");
            else
                System.out.println("Roda calibrada.");
        } else
            System.out.println("A informacao sobre a roda nao existe");
    }


}
