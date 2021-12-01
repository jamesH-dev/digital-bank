package com.dio.domain;

public class CheckingAccount extends Account {

    public void printExtract(){
        System.out.println("\n*************************************");
        System.out.println("* EXTRATO BANCO DIGITAL - CORRENTE  *");
        System.out.println("*************************************");
        super.printDataAccount();
    }
}
