package bank.service.impl;

import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private PaymentAccount paymentAccount;

    @Override
    public PaymentAccount createPaymentAccount(int id, User user, String bankName, double amount) {
        if (this.paymentAccount == null) {
            PaymentAccount newPaymentAccount = new PaymentAccount(id, user, bankName, amount);
            this.paymentAccount = newPaymentAccount;
            System.out.println("Платежный счет успешно создан.");
            return newPaymentAccount;
        } else {
            System.out.println("Ошибка: Платежный счет уже существует.");
            return null;
        }
}


    @Override
    public void updatePaymentAccount(int id, User user, String bankName, double amount) {
        if (this.paymentAccount != null && this.paymentAccount.getId() == id) {
            this.paymentAccount.setBankName(bankName);
            this.paymentAccount.setUser(user);
            this.paymentAccount.setAmount(amount);
            System.out.println("Платежный счет успешно обновлен.");
        } else {
            System.out.println("Ошибка: Платежный счет не найден.");
        }
    }

    @Override
    public void deletePaymentAccount(int id) {
        if (this.paymentAccount != null && this.paymentAccount.getId() == id) {
            this.paymentAccount = null;
            System.out.println("Платежный счет успешно удален.");
        } else {
            System.out.println("Ошибка: Платежный счет не найден.");
        }
    }

    @Override
    public PaymentAccount getPaymentAccountById(int id) {
        if (this.paymentAccount != null && this.paymentAccount.getId() == id) {
            return this.paymentAccount;
        } else {
            System.out.println("Ошибка: Платежный счет не найден.");
            return null;
        }
    }


}
