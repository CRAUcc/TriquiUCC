
package triqui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rubenp
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    Celda c=new Celda();
    Tablero t=new Tablero();
    
    
        
    public static void main(String[] args) {
        // TODO code application logic here
        Principal P=new Principal();
        P.Menu();
                   
    }
    

    public Principal() {
         for (int i = 0; i < t.state.length; i++) {
            for (int j = 0; j < t.state.length; j++) {
                t.state[i][j] = ' ';
            }
        }
    }
    
    
    public void CapturarDatos() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);  

        System.out.println("Jugada 1");
        String a;
        String b;
        try {
            a = br.readLine();
            b = br.readLine();
            int i = Integer.parseInt(a);
            int j = Integer.parseInt(b);
            
                if(t.state[i][j]== ' '){
                t.state[i][j]= 'X';
                
                
                }else{
                    System.out.println("Movimiento Incorrecto");
                    CapturarDatos();
                }
                   
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                     
    }
    
    public void getComputerMove()
    {
                InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);  

        System.out.println("Jugador 2");
        String a;
        String b;
        try {
            a = br.readLine();
            b = br.readLine();
            int i = Integer.parseInt(a);
            int j = Integer.parseInt(b);
            
                if(t.state[i][j]== ' '){
                t.state[i][j]= 'O';
                
                
                }else{
                    System.out.println("Movimiento Incorrecto");
                    getComputerMove();
                }
                   
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String imprimir(){
    

        String str = "";
        for (int i = 0; i < t.state.length; i++) {
            str += String.format(" %c | %c | %c\n", t.state[i][0], t.state[i][1], t.state[i][2]);
            if (i < 2) str += "---+---+---\n";
        }
        return str;
    }
    
    public void Menu(){
        Principal P=new Principal();
        char done = ' ';
        System.out.print(P.imprimir());
        do {
            
            P.CapturarDatos();
            done = P.validarGanador();
            if(done != ' ')break;
            System.out.print(P.imprimir());
            P.getComputerMove();
            done = P.validarGanador();
            System.out.print(P.imprimir());
                      
        }
        while (done == ' ');
        System.out.print(P.imprimir());
        if (done == 'X') {
            System.out.println("Jugador 1 gano");
        } else if (done == 'O') {
            System.out.println("Jugador 2 gano");
        }
    }
    
    //se realiza el metodo validar el ganador en el cual se miran todas las opciones probables que se pueden hacer
        public char validarGanador()
    {
        for (int i = 0; i < t.state.length; i++) {
            if (t.state[i][0] != ' ' && t.state[i][0] == t.state[i][1] && t.state [i][0] == t.state [i][2]) {
                return t.state[i][0];
            }
        }
        for (int j = 0; j < t.state.length; j++) {
            if (t.state[0][j] != ' ' && t.state[0][j] == t.state[1][j] && t.state [0][j] == t.state [2][j]) {
                return t.state[0][j];
            }
        }
        if (t.state[0][0] != ' ' && t.state[0][0] == t.state[1][1] && t.state [0][0] == t.state [2][2]) {
            return t.state[0][0];
        }
        if (t.state[0][2] != ' ' && t.state[0][2] == t.state[1][1] && t.state [0][2] == t.state [2][0]) {
            return t.state[0][2];
        }
        return ' ';
    }

}
