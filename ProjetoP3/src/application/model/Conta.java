package application.model;

/**
 *
 * @author Mário Filipe
 */

public class Conta {
    public int id;
    public float saldo;
    private int acoes;
    
    public Conta(int id) {
        this.id = id;
        this.saldo = 0f;
        this.acoes = 0;
    }

    public Conta() {

    }

    public void setSaldo(float novoSaldo) {
        saldo = novoSaldo;
    }
    
    public float getSaldo() {
        return saldo;
    }

    public int getAcoes() {
        return acoes;
    }

    public void setAcoes(int acoes) {
        this.acoes = acoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
