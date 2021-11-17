public class Roda {
    private boolean calibragem = true; //1 para calibrado e 0 para não calibrado

    public Roda(boolean cali) {
        this.calibragem = cali;
    }

    public void imprimirRoda() {
        if ((calibragem == false) || (calibragem == true)) {
            if (calibragem == false)
                System.out.println("Roda nao calibrada.");
            else
                System.out.println("Roda calibrada.");
        } else
            System.out.println("A informacao sobre a roda nao existe");
    }

    public boolean verificaCalibragem() {
        if (calibragem) {
            return true;
        } else {
            return false;
        }
    }

    public void esvaCaliEspe(boolean caliEsva) {
        if (caliEsva) {
            this.calibragem = caliEsva;
        } else {
            this.calibragem = caliEsva;
        }
    }
}
