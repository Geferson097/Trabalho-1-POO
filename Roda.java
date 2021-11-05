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

    public boolean verificaCalibragem(Roda a) {
        if (a.calibragem == true) {
            return true;
        } else {
            return false;
        }
    }

    public void esvaCaliEspe(int caliEsva) {
        if (caliEsva == 1) {
            this.calibragem = true;
        } else {
            this.calibragem = false;
        }
    }
}
