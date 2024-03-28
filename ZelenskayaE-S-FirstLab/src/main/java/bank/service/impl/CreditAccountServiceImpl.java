package bank.service.impl;

import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.CreditAccountService;

public class CreditAccountServiceImpl implements CreditAccountService {
    private CreditAccount creditAccount;

    @Override
    public CreditAccount createCreditAccount(int id, User user, String bankName, String startDate, String endDate, int months, double amount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        if (this.creditAccount == null) {
            CreditAccount newCreditAccount = new CreditAccount(id, user, bankName, startDate, endDate, months, amount, monthlyPayment, interestRate, issuingEmployee, paymentAccount);
            this.creditAccount = newCreditAccount;
            System.out.println("Кредитный счет успешно создан.");
            return newCreditAccount;
        } else {
            System.out.println("Ошибка: Кредитный счет уже существует.");
            return null;
        }
}


    @Override
    public void updateCreditAccount(int id, User user, String bankName, String startDate, String endDate, int months, double amount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        if (this.creditAccount != null && this.creditAccount.getId() == id) {
            this.creditAccount.setUser(user);
            this.creditAccount.setBankName(bankName);
            this.creditAccount.setStartDate(startDate);
            this.creditAccount.setEndDate(endDate);
            this.creditAccount.setMonths(months);
            this.creditAccount.setAmount(amount);
            this.creditAccount.setMonthlyPayment(monthlyPayment);
            this.creditAccount.setInterestRate(interestRate);
            this.creditAccount.setIssuingEmployee(issuingEmployee);
            this.creditAccount.setPaymentAccount(paymentAccount);
            System.out.println("Кредитный счет успешно обновлен.");
        } else {
            System.out.println("Ошибка: Кредитный счет не найден.");
        }
    }

    @Override
    public void deleteCreditAccount(int id) {
        if (this.creditAccount != null && this.creditAccount.getId() == id) {
            this.creditAccount = null;
            System.out.println("Кредитный счет успешно удален.");
        } else {
            System.out.println("Ошибка: Кредитный счет не найден.");
        }
    }

    @Override
    public CreditAccount getCreditAccountById(int id) {
        if (this.creditAccount != null && this.creditAccount.getId() == id) {
            return this.creditAccount;
        } else {
            System.out.println("Ошибка: Кредитный счет не найден.");
            return null;
        }
    }


}
