public class Roda {
    private int calibragem; //1 para calibrado e 0 para não calibrado

    public Roda(int cali) {
        this.calibragem = cali;
    }

    public void imprimirRoda() {
        if ((calibragem == 0) || (calibragem == 1)) {
            if (calibragem == 0)
                System.out.println("Roda nao calibrada.");
            else
                System.out.println("Roda calibrada.");
        } else
            System.out.println("A informacao sobre a roda nao existe");
    }

    public int verificaCalibragem(Roda a) {
        if (a.calibragem == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void esvaCaliEspe(int caliEsva) {
        if (caliEsva == 1) {
            this.calibragem = 1;
        } else {
            this.calibragem = 0;
        }
    }
}
