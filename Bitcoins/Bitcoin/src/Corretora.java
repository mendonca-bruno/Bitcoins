/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CC49755682848
 */
public class Corretora{
    private Double bitcoin;
    private Double valor_bitcoin;
    private Double fundos;
    
    public Corretora(){
        this.bitcoin = 5.00;
        this.valor_bitcoin = 100000.00;
        this.fundos = 200000.00;
    }
    
    public synchronized void vender(Double bitcoin) throws InterruptedException{
       
       if(this.bitcoin>0 && this.bitcoin<=bitcoin){
           
           wait();
       }          
        
        atualizaValorVenda(bitcoin);
        this.fundos = this.fundos + calculaValor(bitcoin);
        recalcula();
        notifyAll();
        
        
    }
    public synchronized void comprar(Double bitcoin) throws InterruptedException{
        
        if(this.fundos<valor_bitcoin){
            wait();
        }
        recalculaCompra();            
        this.bitcoin = this.bitcoin+bitcoin;
        this.fundos = this.fundos - calculaValor(bitcoin);
        notifyAll();       
        
    }
    
    public void atualizaValorVenda(Double bitcoin){
        this.bitcoin = this.bitcoin - bitcoin;
    }
    
    public void recalcula(){
        valor_bitcoin += (0.03*valor_bitcoin); 
    }
    
    public void recalculaCompra(){
        valor_bitcoin -= (0.01*valor_bitcoin);
    }
    
    public Double calculaValor(Double bitcoin){
        return (bitcoin*this.valor_bitcoin);
    }

    public Double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Double bitcoin) {
        this.bitcoin = bitcoin;
    }

    public Double getValor_bitcoin() {
        return valor_bitcoin;
    }

    public void setValor_bitcoin(Double valor_bitcoin) {
        this.valor_bitcoin = valor_bitcoin;
    }

    public Double getFundos() {
        return fundos;
    }

    public void setFundos(Double fundos) {
        this.fundos = fundos;
    }
    

    
}