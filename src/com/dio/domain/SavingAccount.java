package com.dio.domain;

public class SavingAccount extends Account {

    public void printExtract(){
        System.out.println("\n*************************************");
        System.out.println("* EXTRATO BANCO DIGITAL - POUPANÇA  *");
        System.out.println("*************************************");
        super.printDataAccount();
    }
}
