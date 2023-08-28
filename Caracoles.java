
import java.util.Scanner;

public class Caracoles {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.println ("******* Juego de los Caracoles *******\n");
        
        System.out.print ("Introduce número de caracol ganador: ");
        //El jugador apuesta por un caracol
        int ganador;
        Scanner sc=new Scanner (System.in);
        ganador=sc.nextInt();
        //Inicializamos el vector de caracoles a distancia 0
        Caracol[] caracoles=new Caracol[5];
        for (int i=0;i<caracoles.length;i++){
            caracoles[i]=new Caracol();
        }
        boolean termina=false;
        do {
        dibujaPantalla(caracoles);
        caracoles= movimento(caracoles);
        termina=compruebaFin (caracoles);
        Thread.sleep(100);
        
        } while (termina==false);
        int gana=mensajeGanador(caracoles);
        if (gana==ganador) System.out.println("Has ganado la apuesta");
            else System.out.println("Has perdido la apuesta");

    }

    static void dibujaPantalla (Caracol cara[]){
        System.out.print("\033[H\033[2J");
          System.out.print("********************************************");
        System.out.print("\n*                                          *");
        for (int i=0;i<5;i++){
            System.out.print("\n*"+(i+1)+" ");
            cara[i].imprimeCaracol();
            System.out.print("*");  
        }
          System.out.print("\n*                                          *");
          System.out.print("\n********************************************");


    }

    static Caracol[] movimento (Caracol[] cara){
        int azar;
        azar=(int)(Math.random()*5);
        cara[azar].aumentarDistancia();
        return cara;
    }

    static boolean compruebaFin (Caracol[] cara){
        boolean fin=false;
        for (int i=0;i<5;i++){
            if (cara[i].obtenerDistancia()>40) {
                fin=true;
                cara[i].establecerGanador();
            }
        }
        return fin;
    }

    static int mensajeGanador (Caracol [] cara){
        int gana=0;
        for (int i=0;i<5;i++){
            if (cara[i].obtenerGanador()){
                System.out.println ("\nEl ganador es el "+(i+1));
                gana=i+1;
            }
        }
        return gana;
    }
}