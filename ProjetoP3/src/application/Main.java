package application;

import application.controller.BancoController;
import application.model.Conta;
import application.model.Poupanca;

import java.util.Scanner;

/**
 *
 * @author Mário Filipe
 */
public class Main {
    
    
    public static void menu() {
        System.out.println("Digite a opção que deseja fazer:");
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Consultar Saldo");
        System.out.println("3 - Depositar em Conta");
        System.out.println("4 - Saque em Conta");
        System.out.println("5 - Desativar Conta");
        System.out.println("6 - Render");
        System.out.println("7 - Comprar Ações");
        System.out.println("8 - Vender Ações");
        System.out.println("9 - Consultar Ações");
        System.out.println("10 - Listar todas as contas correntes");
        System.out.println("11 - Listar todas as contas poupanças");
        System.out.println("0 - Sair");

    }

    public static void opcaoConta() {
        System.out.println("Especifique o tipo da conta: ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        new Thread(() -> {
            BancoController bankControl = new BancoController();
            int opcao, id;
            System.out.println("Bem vindo(a)");

            do {
                menu();
                System.out.print("==> ");
                opcao = in.nextInt();
                System.out.println();

                switch (opcao) {
                    case 1:
                        // Criar Conta
                        int opConta1;
                        do {
                            opcaoConta();
                            opConta1 = in.nextInt();
                            System.out.print("Digite um ID para a nova conta: ");
                            id = in.nextInt();
                            switch (opConta1) {
                                case 1:
                                    System.out.println("Criando conta...");
                                    System.out.println();
                                    Conta a = new Conta(id);
                                    boolean contaCriada = bankControl.criarConta(a);
                                    if (contaCriada) {
                                        System.out.println("Conta criada com sucesso.");
                                    } else {
                                        System.out.println("Erro!");
                                        System.out.println("Conta existente com mesmo ID.");
                                        System.out.println();
                                    }
                                    break;
                                case 2:
                                    System.out.println("Criando conta...");
                                    System.out.println();
                                    Poupanca p = new Poupanca(id);
                                    boolean poupCriada = bankControl.criarContaP(p);
                                    if (poupCriada) {
                                        System.out.println("Conta criada com sucesso.");
                                    } else {
                                        System.out.println("Erro!");
                                        System.out.println("Conta existente com mesmo ID.");
                                        System.out.println();
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida. Selecione uma das opções disponíveis.");
                                    System.out.println();
                            }
                        } while (opConta1 != 1 && opConta1 != 2);
                        break;
                    case 2:
                        // Consultar Saldo
                        int opConta2;
                        do {
                            opcaoConta();
                            opConta2 = in.nextInt();
                            System.out.print("Digite o ID da conta: ");
                            id = in.nextInt();
                            switch (opConta2) {
                                case 1:
                                    boolean existeConta1 = bankControl.verificarConta(id);
                                    if (existeConta1) {
                                        float saldo = bankControl.consultarSaldo(id);
                                        System.out.println("O saldo da conta " + id + " é R$" + saldo + ".");
                                    }
                                    else {
                                        System.out.println("Conta inexistente.");
                                        System.out.println();
                                    }
                                    break;
                                case 2:
                                    boolean existeConta1P = bankControl.verificarContaP(id);
                                    if (existeConta1P) {
                                        float saldoP = bankControl.consultarSaldoP(id);
                                        System.out.println("O saldo da conta " + id + " é R$" + saldoP + ".");
                                    }
                                    else {
                                        System.out.println("Conta inexistente.");
                                        System.out.println();
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida. Selecione uma das opções disponíveis.");
                                    System.out.println();
                            }
                        } while (opConta2 != 1 && opConta2 != 2);
                        break;
                    case 3:
                        // Depositar
                        int opConta3;
                        do {
                            opcaoConta();
                            opConta3 = in.nextInt();
                            System.out.println("Digite o ID da conta que deseja fazer um depósito: ");
                            int opD = in.nextInt();
                            switch (opConta3) {
                                case 1:
                                    boolean existeConta2 = bankControl.verificarConta(opD);
                                    if (existeConta2) {
                                        System.out.println("Digite o valor que deseja depositar: ");
                                        float deposito = in.nextFloat();
                                        bankControl.deposito(opD, deposito);
                                        System.out.println("R$" + deposito + " adicionados com sucesso à conta " + opD + ".");
                                        System.out.println();
                                    } else {
                                        System.out.println("Conta inexistente.");
                                    }
                                    break;
                                case 2:
                                    boolean existeConta2P = bankControl.verificarContaP(opD);
                                    if (existeConta2P) {
                                        System.out.println("Digite o valor que deseja depositar: ");
                                        float depositoP = in.nextFloat();
                                        bankControl.depositoP(opD, depositoP);
                                        System.out.println("R$" + depositoP + " adicionados com sucesso à conta " + opD + ".");
                                        System.out.println();
                                    } else {
                                        System.out.println("Conta inexistente.");
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida. Selecione uma das opções disponíveis.");
                                    System.out.println();
                            }
                        } while (opConta3 != 1 && opConta3 != 2);
                        break;
                    case 4:
                        // Saque
                        int opConta4;
                        do {
                            opcaoConta();
                            opConta4 = in.nextInt();
                            System.out.println("Digite o ID da conta que deseja realizar um saque: ");
                            int opS = in.nextInt();
                            switch (opConta4) {
                                case 1:
                                    boolean existeConta3 = bankControl.verificarConta(opS);
                                    if (existeConta3) {
                                        System.out.println("Digite o valor do saque: ");
                                        float saque = in.nextFloat();
                                        boolean saqSucesso = bankControl.saque(opS, saque);
                                        if (saqSucesso) {
                                            System.out.println("R$" + saque + " removidos com sucesso da conta " + opS);
                                        } else {
                                            System.out.println("Saldo insuficiente.");
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("Conta inexistente.");
                                        System.out.println();
                                    }
                                    break;
                                case 2:
                                    boolean existeConta3P = bankControl.verificarContaP(opS);
                                    if (existeConta3P) {
                                        System.out.println("Digite o valor do saque: ");
                                        float saque = in.nextFloat();
                                        boolean saqSucessoP = bankControl.saqueP(opS, saque);
                                        if (saqSucessoP) {
                                            System.out.println("R$" + saque + " removidos com sucesso da conta " + opS);
                                        } else {
                                            System.out.println("Saldo insuficiente.");
                                        }
                                    } else {
                                        System.out.println("Conta inexistente");
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida. Selecione uma das opções disponíveis.");
                                    System.out.println();
                            }
                        } while (opConta4 != 1 && opConta4 != 2);
                        break;
                    case 5:
                        // Desativar
                        int opConta5;
                        do {
                            opcaoConta();
                            opConta5 = in.nextInt();
                            System.out.println("Digite o ID da conta que deseja desativar: ");
                            int opR = in.nextInt();
                            switch (opConta5) {
                                case 1:
                                    boolean existeConta5 = bankControl.verificarConta(opR);
                                    if (existeConta5) {
                                        System.out.println("Deseja mesmo desativar a conta corrente " + opR + "?");
                                        System.out.println("Todo o seu saldo atual será perdido. :(");
                                        System.out.println("Y/N");
                                        char resp;
                                        do {
                                            resp = in.next().charAt(0);
                                            resp = Character.toUpperCase(resp);
                                            switch (resp) {
                                                case 'Y':
                                                    bankControl.desativarConta(opR);
                                                    System.out.println("Conta removida com sucesso.");
                                                    break;
                                                case 'N':
                                                    System.out.println("Ação cancelada. Voltando ao menu inicial...");
                                                    System.out.println();
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida. Digite Y ou N: ");
                                                    System.out.println();
                                            }
                                        } while (resp != 'Y' && resp != 'N');
                                    } else {
                                        System.out.println("Conta inexistente.");
                                        System.out.println();
                                    }
                                    break;
                                case 2:
                                    boolean existeConta5P = bankControl.verificarContaP(opR);
                                    if (existeConta5P) {
                                        System.out.println("Deseja mesmo desativar a conta poupança " + opR + "?");
                                        System.out.println("Todo o seu saldo atual será perdido. :(");
                                        System.out.println("Y/N");
                                        char resp;
                                        do {
                                            resp = in.next().charAt(0);
                                            resp = Character.toUpperCase(resp);
                                            switch (resp) {
                                                case 'Y':
                                                    bankControl.desativarContaP(opR);
                                                    System.out.println("Conta removida com sucesso.");
                                                    break;
                                                case 'N':
                                                    System.out.println("Ação cancelada. Voltando ao menu inicial...");
                                                    System.out.println();
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida. Digite Y ou N: ");
                                                    System.out.println();
                                            }
                                        } while (resp != 'Y' && resp != 'N');
                                    } else {
                                        System.out.println("Conta inexistente.");
                                        System.out.println();
                                    }
                                    break;
                                default:
                                    System.out.println("Opção inválida. Selecione uma das opções disponíveis.");
                                    System.out.println();
                            }
                        } while (opConta5 != 1 && opConta5 != 2);
                        break;
                    case 6:
                        // Render
                        System.out.println("Digite o ID da conta poupança que deseja render: ");
                        int idRende = in.nextInt();
                        boolean existeConta6P = bankControl.verificarContaP(idRende);
                        if (existeConta6P) {
                            bankControl.renderConta(idRende);
                            System.out.println("Rendimento de 1% para o saldo da conta poupança " + idRende);
                        } else {
                            System.out.println("Conta inexistente.");
                            System.out.println();
                        }
                        break;
                    case 7:
                        // Comprar Ações
                        System.out.println("Digite o ID da conta corrente para que deseja comprar ações: ");
                        int opComp = in.nextInt();
                        boolean existeConta7 = bankControl.verificarConta(opComp);
                        if (existeConta7) {
                            System.out.println("Quantas ações deseja comprar? (1 x R$100,00)");
                            int compra = in.nextInt();
                            boolean compSucesso = bankControl.comprarAcoes(opComp, compra);
                            if (compSucesso) {
                                System.out.println(compra + " ação(oes) comprada(s) com sucesso.");
                                System.out.println("R$" + (compra * 100f) + " deduzidos da conta " + opComp + ".");
                            } else {
                                System.out.println("Saldo insuficiente.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("Conta inexistente.");
                            System.out.println();
                        }
                        break;
                    case 8:
                        // Vender Ações
                        System.out.println("Digite o ID da conta corrente de que deseja vender ações: ");
                        int opV = in.nextInt();
                        boolean existeConta8 = bankControl.verificarConta(opV);
                        if (existeConta8) {
                            System.out.println("Quantas ações deseja vender? (1 x R$100,00)");
                            int venda = in.nextInt();
                            boolean vendSucesso = bankControl.venderAcoes(opV, venda);
                            if (vendSucesso) {
                                System.out.println(venda + " ação(oes) vendida(s) com sucesso.");
                                System.out.println("R$" + (venda * 100f) + " adicionados à conta " + opV + ".");
                                System.out.println();
                            } else {
                                System.out.println("Ações insuficientes.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("Conta inexistente.");
                        }
                        break;
                    case 9:
                        // Consultar Ações
                        System.out.println("Digite o ID da conta corrente de que deseja consultar ações: ");
                        int opCons = in.nextInt();
                        boolean existeConta9 = bankControl.verificarConta(opCons);
                        if (existeConta9) {
                            bankControl.consultarAcoes(opCons);
                        } else {
                            System.out.println("Conta inexistente.");
                            System.out.println();
                        }
                        break;
                    case 10:
                        System.out.println("Listando todas as contas correntes...");
                        System.out.println();
                        bankControl.listarContas();
                        break;
                    case 11:
                        System.out.println("Listando todas as contas poupanças...");
                        System.out.println();
                        bankControl.listarPoupancas();
                        break;
                    case 0:
                        System.out.println("Obrigado por utilizar os nossos serviços");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite uma das opções disponíveis.");
                        System.out.println();
                        break;
                }
            } while (opcao != 0);
        }).start();
    }

}

