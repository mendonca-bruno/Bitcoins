/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitcoin;

/**
 *
 * @author cc44984357886
 */
public class Corretora extends Thread{
    private Double bitcoin;
    private Double valor_bitcoin;
    private Double fundos;
    
    public Corretora(){
        this.bitcoin = 5.00;
        this.valor_bitcoin = 100000.00;
        this.fundos = 200000.00;
    }
    
    public synchronized double vender(double bitcoin){ //investidores comprando
        double temp;
        try {
            while(this.bitcoin<bitcoin ||this.bitcoin<=0) wait();
            fundos += bitcoin*valor_bitcoin;
            this.bitcoin -= bitcoin;
            temp = valor_bitcoin;
            valor_bitcoin = valor_bitcoin+(0.01*valor_bitcoin); //valor bitcoin sobe
            notifyAll();
            return temp;
            
        } catch (Exception e) {
        }
        return -1;
    }
    
    public synchronized double comprar(double bitcoin){ //investidores vendendo
        double temp;
        try {
            while(this.fundos<bitcoin*valor_bitcoin) wait();
            fundos-=bitcoin*valor_bitcoin;
            this.bitcoin+=bitcoin;
            temp = valor_bitcoin;
            valor_bitcoin = valor_bitcoin-(0.02*valor_bitcoin); //valor bitcoin cai
            notifyAll();
            return temp;
        } catch (Exception e) {
        }
        return -1;
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
