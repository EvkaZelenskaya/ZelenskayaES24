package bank.entity;

import java.util.Random;

public class Bank {
    private static final Random random = new Random();
    private static int nextId = 1; // Счетчик для генерации уникальных идентификаторов
    private int id; // Идентификатор банка
    private String name; // Название банка
    private int numOfOffices; // Количество офисов банка
    private int numOfAtms; // Количество банкоматов банка
    private int numOfEmployees; // Количество сотрудников банка
    private int numOfClients; // Количество клиентов банка
    private int rating; // Рейтинг банка
    private double totalMoney; // Общая сумма денег в банке
    private double interestRate; // Процентная ставка банка

    /**
     * Конструктор класса Bank с параметрами.
     */
    public Bank(String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients) {
        this.id = nextId++;
        this.name = name;
        this.numOfOffices = numOfOffices;
        this.numOfAtms = numOfAtms;
        this.numOfEmployees = numOfEmployees;
        this.numOfClients = numOfClients;
        this.rating = random.nextInt(101); // Генерация случайного рейтинга от 0 до 100
        this.totalMoney = random.nextDouble() * 1_000_000; // Генерация случайной суммы денег до 1 000 000
        this.interestRate = random.nextDouble() * 20; // Генерация случайной процентной ставки до 20%
    }
    public Bank(String name) {
        this.id = nextId++;
        this.name = name;
        this.numOfOffices = 0;
        this.numOfAtms = 0;
        this.numOfEmployees = 0;
        this.numOfClients = 0;
        this.rating = random.nextInt(101); // Генерация случайного рейтинга от 0 до 100
        this.totalMoney = random.nextDouble() * 1_000_000; // Генерация случайной суммы денег до 1 000 000
        this.interestRate = random.nextDouble() * 20; // Генерация случайной процентной ставки до 20%
    }

    @Override
    public String toString() {
        return "Банк:{" +
                "идентификатор=" + id +
                ", название='" + name + '\'' +
                ", количество офисов=" + numOfOffices +
                ", количество банкоматов=" + numOfAtms +
                ", количество сотрудников=" + numOfEmployees +
                ", количество клиентов=" + numOfClients +
                ", рейтинг=" + rating +
                ", общая сумма денег=" + totalMoney +
                ", процентная ставка=" + interestRate +
                '}';
    }


    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfOffices() {
        return numOfOffices;
    }

    public void setNumOfOffices(int numOfOffices) {
        this.numOfOffices = numOfOffices;
    }

    public int getNumOfAtms() {
        return numOfAtms;
    }

    public void setNumOfAtms(int numOfAtms) {
        this.numOfAtms = numOfAtms;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public int getNumOfClients() {
        return numOfClients;
    }

    public void setNumOfClients(int numOfClients) {
        this.numOfClients = numOfClients;
    }

    public int getRating() {
        return rating;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void incrementQuantityATM() {
    }
}
