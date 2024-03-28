package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;

public class BankServiceImpl implements BankService {
    private Bank bank;

    @Override
    public Bank createBank(String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients) {
        if (this.bank == null) {
            this.bank = new Bank(name, numOfOffices, numOfAtms, numOfEmployees, numOfClients);
            System.out.println("Банк успешно создан.");
            return this.bank;
        } else {
            System.out.println("Ошибка: Банк уже существует.");
            return null;
        }
    }

    @Override
    public void updateBank(int bankId, String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients) {
        if (this.bank != null && this.bank.getId() == bankId) {
            this.bank.setName(name);
            this.bank.setNumOfOffices(numOfOffices);
            this.bank.setNumOfAtms(numOfAtms);
            this.bank.setNumOfEmployees(numOfEmployees);
            this.bank.setNumOfClients(numOfClients);
            System.out.println("Банк успешно обновлен.");
        } else {
            System.out.println("Ошибка: Банк не найден.");
        }
    }

    @Override
    public void deleteBank(int bankId) {
        if (this.bank != null && this.bank.getId() == bankId) {
            this.bank = null;
            System.out.println("Банк успешно удален.");
        } else {
            System.out.println("Ошибка: Банк не найден.");
        }
    }

    @Override
    public Bank getBankById(int bankId) {
        if (this.bank != null && this.bank.getId() == bankId) {
            return this.bank;
        } else {
            System.out.println("Ошибка: Банк не найден.");
            return null;
        }
    }

    @Override
    public String getName() {
        if (bank != null) {
            return bank.getName();
        } else {
            return null; // Или любое другое значение по умолчанию, в зависимости от вашей логики
        }
    }

}
