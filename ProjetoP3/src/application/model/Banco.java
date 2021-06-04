package application.model;

import java.util.ArrayList;
import java.util.List;
import application.model.Conta;
import application.model.Poupanca;



/**
 *
 * @author Mário Filipe
 */

public class Banco {
    private List<Conta> contas;
    private List<Poupanca> poupancas;
    private int indiceDisponivel, indiceDisponivelPoupanca;
    
    public Banco() {
        indiceDisponivel = 0;
        contas = new ArrayList<>();
        poupancas = new ArrayList<>();
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Poupanca> getPoupancas() {
        return poupancas;
    }

    public void setPoupancas(List<Poupanca> poupancas) {
        this.poupancas = poupancas;
    }

    public int getIndiceDisponivel() {
        return indiceDisponivel;
    }

    public void setIndiceDisponivel(int indiceDisponivel) {
        this.indiceDisponivel = indiceDisponivel;
    }

    public int getIndiceDisponivelPoupanca() {
        return indiceDisponivelPoupanca;
    }

    public void setIndiceDisponivelPoupanca(int indiceDisponivelPoupanca) {
        this.indiceDisponivelPoupanca = indiceDisponivelPoupanca;
    }

    
}
