/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoin;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author cc44984357886
 */
public class CorretoraInvestidor {
    public static void main(String[] args) {
        //DecimalFormat d = new DecimalFormat("0.00");
        Corretora cor = new Corretora();
        //List<Investidor> investidores = new ArrayList<>();
        Investidor inv1 = new Investidor(cor,0);
        Investidor inv2 = new Investidor(cor, 1);
        inv1.start();
        inv2.start();
        
        /*for(int i = 0; i<10; i++){
            investidores.add(new Investidor(cor,  i));
        }
        for(Investidor i:investidores){
            i.start();
        }*/
    }
}
