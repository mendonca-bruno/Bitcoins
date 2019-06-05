/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoin;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

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
    
   public void comprar(Double bitcoin){
       try {
           if(capital >= cor.getValor_bitcoin()){
               System.out.println("Investidor " + id + " comprou " + d.format(bitcoin) + " bitcoins");
           }         
           Thread.sleep((long)(Math.random()*1000));
       } catch (Exception e) {
       }finally{       
                 
            if(capital >= cor.getValor_bitcoin()){
             cor.vender(bitcoin);             
             atualizaCapital(bitcoin);
             this.carteira += bitcoin;
            }
       }
   }
   public void vender(double bitcoin){
       try {
           if(carteira!=0){
           System.out.println("Investidor " + id + " vendeu " + d.format(bitcoin) + " bitcoins");
           
           }           
           Thread.sleep((long)(Math.random()*1000));
       } catch (Exception e) {
       }finally{
           if(carteira!=0){
               cor.comprar(bitcoin);
               attCap2(bitcoin);
               this.carteira-=bitcoin;
               
           }
       }
       
   }
   public void attCap2(Double bitcoin){
       this.capital+= cor.calculaValor(bitcoin);
   }
   
   public void atualizaCapital(Double bitcoin){
       this.capital -= cor.calculaValor(bitcoin);
   }
   
    @Override
   public void run(){
       while(true){
           try {
               if(capital>=cor.getValor_bitcoin()) comprar(ThreadLocalRandom.current().nextDouble(0.1, cor.getBitcoin()));
               if(carteira>0) vender(ThreadLocalRandom.current().nextDouble(0.1, carteira));
                
           } catch (Exception e) {
           }
       
   }
   }
}
