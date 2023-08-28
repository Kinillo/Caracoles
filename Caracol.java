public class Caracol {
    protected int distancia;
    protected boolean ganador=false;

    public Caracol (){
        this.distancia=0;
    }

    public int obtenerDistancia (){
        return distancia;

    }

    public void establecerGanador (){
        this.ganador=true;
    }

    public boolean obtenerGanador (){
        return ganador;
    }

    public void aumentarDistancia () {
        distancia++;
    }

    public void aumentarDistancia (int distan){
        distancia=distancia+distan;
    }

    public void imprimeCaracol (){
        for (int i=0;i<obtenerDistancia();i++) 
            System.out.print(" ");
        System.out.print("@");
        for (int j=obtenerDistancia()+1;j<40;j++)
            System.out.print(" ");
    }
}