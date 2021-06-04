package application.controller;

import application.model.Conta;

/**
 *
 * @author Mário Filipe
 */
public class ContaController {
    
    public synchronized void depositar(Conta conta, float deposito) {
        // saldo = saldo + valor
        float saldo = conta.getSaldo();
        saldo += deposito;
        conta.setSaldo(saldo);
    }
    
    public synchronized boolean sacar(Conta conta, float saque) {
        // saldo = saldo - valor
        if (conta.getSaldo() > saque) {
            float saldo = conta.getSaldo();
            saldo -= saque;
            conta.setSaldo(saldo);
            return true;
        }
        return false;
    }
    
    public synchronized boolean adicionarAcoes(Conta conta, int qtdAcoes) {
        // Adiciona a qtd de ações compradas e remove o valor da compra do saldo
        if (conta.getSaldo() > (qtdAcoes * 100)) {
            int acoes = conta.getAcoes();
            float saldo = conta.getSaldo();
            acoes += qtdAcoes;
            saldo -= (qtdAcoes * 100);
            conta.setAcoes(acoes);
            conta.setSaldo(saldo);
            return true;
        }
        return false;
    }
    
    public synchronized boolean removerAcoes(Conta conta, int qtdAcoes) {
        // Remove a qtd de ações vendidas e adiciona o valor da venda ao saldo
        if (qtdAcoes <= conta.getAcoes()) {
            int acoes = conta.getAcoes();
            float saldo = conta.getSaldo();
            acoes -= qtdAcoes;
            saldo += (qtdAcoes * 100);
            conta.setAcoes(acoes);
            conta.setSaldo(saldo);
            return true;
        }
        return false;
    }
    
    public int verAcoes(Conta conta) {
        return conta.getAcoes();
    }
}
