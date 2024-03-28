package bank.service;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.Employee;

/**
 * Интерфейс для управления банкоматами.
 */
public interface BankAtmService {

    BankAtm createBankAtm(int id, String name, String status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost);

    void updateBankAtm(int id, String name, String address, String status, Bank bank, BankOffice bankOffice, Employee serviceEmployee, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double maintenanceCost);

    void deleteBankAtm(int id);

    BankAtm getBankAtmById(int id);


}
