package application.controller;

import application.model.Conta;
import application.model.Poupanca;

/**
 *
 * @author Mário Filipe
 */
public class PoupancaController {
    
    public synchronized void depositarP(Poupanca poupanca, float deposito) {
        float saldo = poupanca.getSaldo();
        saldo += deposito;
        poupanca.setSaldo(saldo);
    }
    
    public synchronized boolean sacarP(Poupanca poupanca, float saque) {
        // saldo = saldo - valor
        if (poupanca.getSaldo() > saque) {
            float saldo = poupanca.getSaldo();
            saldo -= saque;
            poupanca.setSaldo(saldo);
            return true;
        }
        return false;
    }
    
    public void render(Conta conta) {
        
        float rendimento = conta.getSaldo() * 0.01f;
        float saldoAtual = conta.getSaldo();
        conta.setSaldo(rendimento + saldoAtual);
        
    }
}
