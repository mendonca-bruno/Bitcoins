/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoin;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cc44984357886
 */
public class Investidor extends Thread{
    
    private double capital;
    private double carteira;
    private int id;
    private Corretora cor;
    private DecimalFormat d;
    
    
    public Investidor(Corretora cor,  int id){
        this.capital = 1000000.00;
        this.carteira = 00.00;
        this.cor = cor;
        this.id = id;
        this.d = new DecimalFormat("0.00");
    }
    
    public void comprar(double bitcoin) throws InterruptedException{
        if(capital>=bitcoin*cor.getValor_bitcoin()){
            double compra = cor.vender(bitcoin);
            if(compra!=-1){
                carteira+=bitcoin;
                capital-=compra;
                System.out.println("Investidor " +id+ " comprou "+d.format(bitcoin) + " bitcoins");
                System.out.println(+id+" Bitcoins corretora: " +d.format(cor.getBitcoin()));
                System.out.println(+id+" Bitcoins Investidor "+id+ "= " +d.format(this.carteira));
                Thread.sleep(1000);
            }
        }
    }
   public void vender(double bitcoin) throws InterruptedException{
       if(cor.getFundos()>=bitcoin*cor.getValor_bitcoin()){
           double venda = cor.comprar(bitcoin);
           if(venda!=-1){
               capital+=venda;
               carteira-=bitcoin;
               System.out.println("Investidor " +id+ " vendeu "+d.format(bitcoin) + " bitcoins");
               System.out.println(+id+" Bitcoins corretora: " +d.format(cor.getBitcoin()));
               System.out.println(+id+" Bitcoins Investidor "+id+ "= " +d.format(this.carteira));
               Thread.sleep(1000);
           }
       }
   }
    
    @Override
   public void run(){
       double bitcoin;
       while(true){
           bitcoin = ThreadLocalRandom.current().nextDouble(0.1, cor.getBitcoin());
           if(capital>=bitcoin*cor.getValor_bitcoin()) try {
               comprar(bitcoin);
           } catch (InterruptedException ex) {
               Logger.getLogger(Investidor.class.getName()).log(Level.SEVERE, null, ex);
           }
           if(carteira>0) try {
               vender(ThreadLocalRandom.current().nextDouble(0.1, carteira));
           } catch (InterruptedException ex) {
               Logger.getLogger(Investidor.class.getName()).log(Level.SEVERE, null, ex);
           }
          
       
   }
   }
}
