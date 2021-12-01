import com.dio.domain.Account;
import com.dio.domain.CheckingAccount;
import com.dio.domain.SavingAccount;

import java.util.Scanner;

public class DigitalBankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String option = "";

        while (option != "s" || option != "n") {
            System.out.println("\n\n****************************************");
            System.out.println("*                 JBANK                *");
            System.out.println("****************************************");
            System.out.println("Bem vindo ao JBank, Digite a opção desejada:");
            System.out.println("Deseja criar sua Conta? (s/n)");
            option = sc.next();

            if ("s".equals(option)) {
                System.out.println("*************CRIAÇÃO DE CONTA***********");
                System.out.println("1 - CONTA CORRENTE");
                System.out.println("2 - CONTA POUPANÇA");
                option = sc.next();
                if (option.equals("1")) {
                    Account checkingAccount = new CheckingAccount();
                    System.out.println("CONTA CRIADA COM SUCESSO!\n\n");
                    while (!option.equals("5")) {
                        System.out.println("\n****************************************");
                        System.out.println("*                CORRENTE              *");
                        System.out.println("****************************************");
                        System.out.println("Selecione a opção desejada:");
                        System.out.println("1 - Depositar:");
                        System.out.println("2 - Sacar:");
                        System.out.println("3 - Transferir para Poupança:");
                        System.out.println("4 - Extrato Conta Corrente");
                        System.out.println("5 - Sair");
                        option = sc.next();
                        switch (option) {
                            case "1" -> {
                                System.out.println("Digite o valor do depósito: ");
                                double valor = sc.nextDouble();
                                System.out.println("DEPOSITANDO VALOR... ");
                                checkingAccount.deposit(valor);
                                checkingAccount.printExtract();
                            }
                            case "2" -> {
                                System.out.println("Digite o valor do saque: ");
                                double valor = sc.nextDouble();
                                System.out.println("SACANDO VALOR... ");
                                checkingAccount.withdraw(valor);
                                checkingAccount.printExtract();
                            }
                            case "3" -> {
                                System.out.println("Digite o valor que será investido: ");
                                double valor = sc.nextDouble();
                                System.out.println("INVESTINDO... ");
                                Account savingAccount = new SavingAccount();
                                System.out.println("POUPANÇA CRIADA!");
                                checkingAccount.transfer(valor, savingAccount);
                                checkingAccount.printExtract();
                                savingAccount.printExtract();
                            }
                            case "4" -> {
                                checkingAccount.printExtract();
                            }
                        }
                    }
                } else if (option.equals("2")) {
                    Account savingAccount = new SavingAccount();
                    System.out.println("CONTA CRIADA COM SUCESSO!\n");
                    while (!option.equals("5")) {
                        System.out.println("\n****************************************");
                        System.out.println("*                POUPANÇA              *");
                        System.out.println("****************************************");
                        System.out.println("Selecione a opção desejada:");
                        System.out.println("1 - Depositar:");
                        System.out.println("2 - Sacar:");
                        System.out.println("3 - Transferir para Corrente:");
                        System.out.println("4 - Extrato Conta Poupança");
                        System.out.println("5 - Sair");
                        option = sc.next();
                        switch (option) {
                            case "1" -> {
                                System.out.println("Digite o valor do depósito: ");
                                double valor = sc.nextDouble();
                                System.out.println("DEPOSITANDO VALOR... ");
                                savingAccount.deposit(valor);
                                savingAccount.printExtract();
                            }
                            case "2" -> {
                                System.out.println("Digite o valor do saque: ");
                                double valor = sc.nextDouble();
                                System.out.println("SACANDO VALOR... ");
                                savingAccount.withdraw(valor);
                                savingAccount.printExtract();
                            }
                            case "3" -> {
                                System.out.println("Digite o valor que será resgatado: ");
                                double valor = sc.nextDouble();
                                System.out.println("RESGATANDO... ");
                                Account checkingAccount = new CheckingAccount();
                                System.out.println("CONTA CORRENTE CRIADA!");
                                savingAccount.transfer(valor, checkingAccount);
                                savingAccount.printExtract();
                                checkingAccount.printExtract();
                            }
                            case "4" -> {
                                savingAccount.printExtract();
                            }
                        }
                    }

                }
            } else if ("n".equals(option)) {
                System.out.println("Obrigado por usar nosso programa!");
                System.exit(0);
            } else System.out.println("Opção desejada inválida, tente novamente!");
        }
        sc.close();
    }
}
