package com.dio.domain;

public interface AccountInterface {
    void withdraw(Double value);
    void deposit(Double value);
    void transfer(Double value, Account destinyAccount);
    void printExtract();
}
