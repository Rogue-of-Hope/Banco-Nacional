package application.controller;

import application.model.Banco;
import application.model.Conta;
import application.model.Poupanca;

/**
 *
 * @author Mário Filipe
 */
public class BancoController {
    Banco unicap = new Banco();
    ContaController contaControl = new ContaController();
    PoupancaController poupancaControl = new PoupancaController();
    
    public boolean criarConta(Conta conta) {
        if (!unicap.getContas().isEmpty()) {
            for (int i = 0; i < unicap.getContas().size(); i++) {
                if (unicap.getContas().get(i).getId() == conta.getId()) {
                    unicap.getContas().add(conta);
                    return true;
                }
            
            }
            return false;
        }
        else {
            unicap.getContas().add(conta);
            return true;
        }
    }
    
    public boolean criarContaP(Poupanca poupanca) {
        if (!unicap.getPoupancas().isEmpty()) {
        for (int i = 0; i < unicap.getPoupancas().size(); i++) {
            if (unicap.getPoupancas().get(i).getId() == poupanca.getId()) {
                unicap.getPoupancas().add(poupanca);
                return true;
            }
        }
        return false;
        }
        else {
            unicap.getPoupancas().add(poupanca);
            return true;
        }
    }
    
    public boolean verificarConta(int id) {
        if (!unicap.getContas().isEmpty()) {
            for (int i = 0; i < unicap.getContas().size(); i++) {
                if (unicap.getContas().get(i).getId() == id) {
                    return true;
                }
            }
            return false;
        }
        else {
            System.out.println("Nenhuma conta corrente registrada.");
            System.out.println();
            return false;
        }
    }
    
    public boolean verificarContaP(int id) {
        if (!unicap.getPoupancas().isEmpty()) {
            for (int i = 0; i < unicap.getPoupancas().size(); i++) {
                if (unicap.getPoupancas().get(i).getId() == id) {
                    return true;
                }
            }
            return false;
        }
        else {
            System.out.println("Nenhuma conta poupança registrada");
            return false;
        }
    }
    
    public void desativarConta(int id) {
        if (!unicap.getContas().isEmpty()) {
            for (int i = 0; i < unicap.getContas().size(); i++) {
                if (unicap.getContas().get(i).getId() == id) {
                    unicap.getContas().remove(i);
                    break;
                }
            }
        }
        else {
            System.out.println("Nenhuma conta corrente registrada.");
            System.out.println();
        }
    }
    
    public boolean desativarContaP(int id) {
        if (!unicap.getPoupancas().isEmpty()) {
            for (int i = 0; i < unicap.getPoupancas().size(); i++) {
                if (unicap.getPoupancas().get(i).getId() == id) {
                    unicap.getPoupancas().remove(i);
                    return true;
                }
            }
            return false;
        }
        else {
            System.out.println("Nenhuma conta poupança registrada.");
            System.out.println();
            return false;
        }
    }
    
    public void deposito(int id, float deposito) {
        for (int i = 0; i < unicap.getContas().size(); i++) {
            if (unicap.getContas().get(i).getId() == id) {
                contaControl.depositar(unicap.getContas().get(i), deposito);
                break;
            }
        }
    }
    
    public void depositoP(int id, float deposito) {
        for (int i = 0; i < unicap.getPoupancas().size(); i++) {
            if (unicap.getPoupancas().get(i).getId() == id) {
                poupancaControl.depositarP(unicap.getPoupancas().get(i), deposito);
                break;
            }
        }
    }
    
    public boolean saque(int id, float saque) {
        for (int i = 0; i < unicap.getContas().size(); i++) {
            if (unicap.getContas().get(i).getId() == id) {
                boolean saqSucesso = contaControl.sacar(unicap.getContas().get(i), saque);
                return saqSucesso;
            }
        }
        return false;
    }
    
    public boolean saqueP(int id, float saque) {
        for (int i = 0; i < unicap.getPoupancas().size(); i++) {
            if (unicap.getPoupancas().get(i).getId() == id) {
                boolean saqSucesso = poupancaControl.sacarP(unicap.getPoupancas().get(i), saque);
                return saqSucesso;
            }
        }
        return false;
    }
    
    public float consultarSaldo(int id) {
        for (int i = 0; i < unicap.getContas().size(); i++) {
            if (unicap.getContas().get(i).getId() == id) {
                return unicap.getContas().get(i).getSaldo();
            }
            
        }
        return -1;
    }
    
    public float consultarSaldoP(int id) {
        for (int i = 0; i < unicap.getPoupancas().size(); i++) {
            if (unicap.getPoupancas().get(i).getId() == id) {
                return unicap.getPoupancas().get(i).getSaldo();
            }
            
        }
        return -1;
    }
    
    public boolean renderConta(int id) {
        for (int i = 0; i < unicap.getPoupancas().size(); i++) {
            if (unicap.getPoupancas().get(i).getId() == id) {
                poupancaControl.render(unicap.getPoupancas().get(i));
                return true;
            }
        }
        return false;
    }
    
    public boolean comprarAcoes(int id, int acoes) {
        for (int i = 0; i < unicap.getContas().size(); i++) {
            if (unicap.getContas().get(i).getId() == id) {
                boolean adSucesso = contaControl.adicionarAcoes(unicap.getContas().get(i), acoes);
                return adSucesso;
            }
        }
        return false;
    }
    
    public boolean venderAcoes(int id, int acoes) {
        for (int i = 0; i < unicap.getContas().size(); i++) {
            if (unicap.getContas().get(i).getId() == id) {
                boolean vdSucesso = contaControl.removerAcoes(unicap.getContas().get(i), acoes);
                return vdSucesso;
            }
        }
        return false;
    }
    
    public void consultarAcoes(int id) {
        for (int i = 0; i < unicap.getContas().get(i).getId(); i++) {
            if (unicap.getContas().get(i).getId() == id) {
                Conta c = unicap.getContas().get(i);
                int acoes = contaControl.verAcoes(c);
                System.out.println("A conta " + id + " possui " + acoes + " ação(oes).");
                System.out.println();
                break;
            }
        }
    }
    
}
