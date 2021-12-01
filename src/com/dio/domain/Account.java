package com.dio.domain;

public abstract class Account implements AccountInterface {

    private static final Integer PATTERN_AGENCY = 1;
    private static Integer SEQUENTIAL = 1;

    private Integer numberAccount;
    private Integer agency;
    private Double balance = 0d;

    public Account() {
        this.agency = PATTERN_AGENCY;
        this.numberAccount = SEQUENTIAL++;
    }

    @Override
    public void withdraw(Double value){
        balance -= value;
    }

    @Override
    public void deposit(Double value){
        balance += value;
    }

    @Override
    public void transfer(Double value, Account destinyAccount){
        this.withdraw(value);
        destinyAccount.deposit(value);
    }

    protected void printDataAccount(){
        System.out.printf("Agência: %d", this.agency);
        System.out.printf("\nNúmero da Conta: %d", this.numberAccount);
        System.out.printf("\nSaldo: %.2f\n", this.balance);
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Integer numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Integer getAgency() {
        return agency;
    }

    public void setAgency(Integer agency) {
        this.agency = agency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  "Número da Conta: " + numberAccount + "\n" +
                "Agência: " + agency + "\n" +
                "Saldo: " + balance;
    }
}
