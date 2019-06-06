/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CC49755682848
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CorretoraInvestidor {
    public static void main(String[] args) {
        //DecimalFormat d = new DecimalFormat("0.00");
        Corretora cor = new Corretora();
        //List<Investidor> investidores = new ArrayList<>();
       Investidor inv1 = new Investidor(cor, 0);
       Investidor inv2 = new Investidor(cor, 1);
       
       inv1.start();
       inv2.start();
       
    }
}
