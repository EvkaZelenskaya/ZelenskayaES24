package bank.service;

import bank.entity.Bank;

/**
 * Интерфейс для управления банками.
 */
public interface BankService {

    Bank createBank(String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients);

    void updateBank(int bankId, String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients);

    void deleteBank(int bankId);

    Bank getBankById(int bankId);

    String getName();
}


