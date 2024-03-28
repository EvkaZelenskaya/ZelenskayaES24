package bank.entity;

import java.time.LocalDate;
import java.util.Random;

public class User {
    private int id; // Идентификатор клиента
    private String fullName; // ФИО клиента
    private LocalDate birthDate; // Дата рождения клиента
    private String workplace; // Место работы клиента
    private double monthlyIncome; // Ежемесячный доход клиента
    private Bank bank; // Банк, с которым взаимодействует пользователь
    private String banksUsed; // Банки, которыми он пользуется
    private CreditAccount creditAccount; // Кредитный счет клиента
    private PaymentAccount paymentAccount; // Платежный счет клиента
    private int creditRating; // Кредитный рейтинг клиента
    /**
     * Конструктор класса User с параметрами.
     */
    public User(int id, String fullName, LocalDate birthDate, String workplace, Bank bank) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.workplace = workplace;
        this.bank = bank;
        this.monthlyIncome = generateRandomMonthlyIncome();
        this.banksUsed = "";
        this.creditRating = generateCreditRating(monthlyIncome);
    }

    private double generateRandomMonthlyIncome() {
        // Генерация случайного ежемесячного дохода от 100 до 10 000
        return new Random().nextInt(9901) + 100;
    }
    private int generateCreditRating(double monthlyIncome) {
        if (monthlyIncome < 1000)
            return 100; // Плохой кредитный рейтинг
        else if (monthlyIncome < 2000)
            return 200; // Средний кредитный рейтинг
        else if (monthlyIncome < 3000)
            return 300; // Хороший кредитный рейтинг
        else if (monthlyIncome < 4000)
            return 400; // Отличный кредитный рейтинг
        else
            return 500; // Выдающийся кредитный рейтинг
    }

    // Геттеры и сеттеры

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getBanksUsed() {
        return banksUsed;
    }

    public void setBanksUsed(String banksUsed) {
        this.banksUsed = banksUsed;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }
    @Override
    public String toString() {
        return "Клиент:{" +
                "Идентификатор = " + id +
                ", ФИО = '" + fullName + '\'' +
                ", Дата рождения = " + birthDate +
                ", Место работы = '" + workplace + '\'' +
                ", Ежемесячный доход = " + monthlyIncome + " руб." +
                ", Банк = '" + bank.getName() + '\'' +
                ", Кредитный рейтинг = " + generateCreditRating(creditRating)
                +                '}';

}
}
