package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.BankAtmService;

public class BankAtmServiceImpl implements BankAtmService {
    private BankAtm bankAtm;

    @Override
    public BankAtm createBankAtm(int id, String name, String status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        if (bankOffice.getAtm() == null) { // Проверяем, есть ли уже банкомат в банковском офисе
            String atmStatus;
            if (status.equals("1")) {
                atmStatus = "Работает";
            } else if (status.equals("2")) {
                atmStatus = "Нет денег";
            } else {
                atmStatus = "Не работает";
            }

            BankAtm atm = new BankAtm(name, location, atmStatus, bankOffice.getBank(), bankOffice, servicingEmployee, cashWithdrawal, cashDeposit, maintenanceCost);
            atm.setId(id);
            bankOffice.setAtm(atm); // Устанавливаем банкомат в банковский офис
            bankOffice.getBank().incrementQuantityATM(); // Увеличиваем количество банкоматов у банка
            this.bankAtm = atm; // Устанавливаем значение поля bankAtm
            System.out.println("Банкомат успешно создан.");
            return atm;
        } else {
            System.out.println("Ошибка: В этом банковском офисе уже есть банкомат.");
            return null;
        }
    }



    @Override
    public void updateBankAtm(int id, String name, String address, String status, Bank bank, BankOffice bankOffice, Employee serviceEmployee, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double maintenanceCost) {
        if (this.bankAtm != null && this.bankAtm.getId() == id) {
            this.bankAtm.setName(name);
            this.bankAtm.setAddress(address);
            this.bankAtm.setStatus(status);
            this.bankAtm.setBank(bank);
            this.bankAtm.setBankOffice(bankOffice);
            this.bankAtm.setServiceEmployee(serviceEmployee);
            this.bankAtm.setCashWithdrawal(cashWithdrawal);
            this.bankAtm.setCashDeposit(cashDeposit);
            this.bankAtm.setMoneyAmount(moneyAmount);
            this.bankAtm.setMaintenanceCost(maintenanceCost);
            System.out.println("Банкомат успешно обновлен.");
        } else {
            System.out.println("Ошибка: Банкомат не найден.");
        }
    }

    @Override
    public void deleteBankAtm(int id) {
        if (this.bankAtm != null && this.bankAtm.getId() == id) {
            this.bankAtm = null;
            System.out.println("Банкомат успешно удален.");
        } else {
            System.out.println("Ошибка: Банкомат не найден.");
        }
    }

    @Override
    public BankAtm getBankAtmById(int id) {
        if (this.bankAtm != null && this.bankAtm.getId() == id) {
            return this.bankAtm;
        } else {
            System.out.println("Ошибка: Банкомат не найден.");
            return null;
        }
    }


}
