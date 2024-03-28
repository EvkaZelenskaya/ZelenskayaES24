package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice;

    @Override
    public BankOffice createBankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank) {
        if (this.bankOffice == null) {
            this.bankOffice = new BankOffice(id, name, address, status, atmPlacement, numOfAtms, creditService, cashWithdrawal, cashDeposit, moneyAmount, rentCost, bank);
            System.out.println("Банковский офис успешно создан.");
            return this.bankOffice;
        } else {
            System.out.println("Ошибка: Банковский офис уже существует.");
            return null;
        }
    }

    @Override
    public void updateBankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank) {
        if (this.bankOffice != null && this.bankOffice.getId() == id) {
            this.bankOffice.setName(name);
            this.bankOffice.setAddress(address);
            this.bankOffice.setStatus(status);
            this.bankOffice.setAtmPlacement(atmPlacement);
            this.bankOffice.setNumOfAtms(numOfAtms);
            this.bankOffice.setCreditService(creditService);
            this.bankOffice.setCashWithdrawal(cashWithdrawal);
            this.bankOffice.setCashDeposit(cashDeposit);
            this.bankOffice.setMoneyAmount(moneyAmount);
            this.bankOffice.setRentCost(rentCost);
            this.bankOffice.setBank(bank);
            System.out.println("Банковский офис успешно обновлен.");
        } else {
            System.out.println("Ошибка: Банковский офис не найден.");
        }
    }

    @Override
    public void deleteBankOffice(int id) {
        if (this.bankOffice != null && this.bankOffice.getId() == id) {
            this.bankOffice = null;
            System.out.println("Банковский офис успешно удален.");
        } else {
            System.out.println("Ошибка: Банковский офис не найден.");
        }
    }

    @Override
    public BankOffice getBankOffice(int id) {
        if (this.bankOffice != null && this.bankOffice.getId() == id) {
            return this.bankOffice;
        } else {
            System.out.println("Ошибка: Банковский офис не найден.");
            return null;
        }
    }


}
