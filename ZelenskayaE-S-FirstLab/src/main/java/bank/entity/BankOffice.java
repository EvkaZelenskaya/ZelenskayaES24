package bank.entity;

/**
 * Класс, представляющий банковский офис.
 */
public class BankOffice {
    private BankAtm atm; // Поле для хранения информации о банкомате в офисе
    private int id; // Идентификатор офиса
    private String name; // Название офиса
    private String address; // Адрес офиса
    private boolean status; // Статус офиса
    private boolean atmPlacement; // Размещение банкоматов
    private int numOfAtms; // Количество банкоматов
    private boolean creditService; // Наличие услуг по выдаче кредитов
    private boolean cashWithdrawal; // Возможность снятия наличных
    private boolean cashDeposit; // Возможность внесения наличных
    private double moneyAmount; // Сумма денег в офисе
    private double rentCost; // Стоимость аренды
    private Bank bank; // Принадлежность к банку

    /**
     * Конструктор класса BankOffice с параметрами.
     *
     * @param id             Идентификатор офиса.
     * @param name           Название офиса.
     * @param address        Адрес офиса.
     * @param status         Статус офиса.
     * @param atmPlacement   Размещение банкоматов.
     * @param numOfAtms      Количество банкоматов.
     * @param creditService  Наличие услуг по выдаче кредитов.
     * @param cashWithdrawal Возможность снятия наличных.
     * @param cashDeposit    Возможность внесения наличных.
     * @param moneyAmount    Сумма денег в офисе.
     * @param rentCost       Стоимость аренды.
     * @param bank           Принадлежность к банку.
     */
    public BankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.atmPlacement = atmPlacement;
        this.numOfAtms = numOfAtms;
        this.creditService = creditService;
        this.cashWithdrawal = cashWithdrawal;
        this.cashDeposit = cashDeposit;
        this.moneyAmount = moneyAmount;
        this.rentCost = rentCost;
        this.bank = bank;
    }
    public BankOffice(String name) {
        this.id = 0; // Значение по умолчанию для id
        this.name = name;
        this.address = ""; // Значение по умолчанию для адреса
        this.status = false; // Значение по умолчанию для статуса
        this.atmPlacement = false; // Значение по умолчанию для размещения банкомата
        this.numOfAtms = 0; // Значение по умолчанию для количества банкоматов
        this.creditService = false; // Значение по умолчанию для кредитного обслуживания
        this.cashWithdrawal = false; // Значение по умолчанию для возможности снятия наличных
        this.cashDeposit = false; // Значение по умолчанию для возможности внесения наличных
        this.moneyAmount = 0.0; // Значение по умолчанию для суммы денег в офисе
        this.rentCost = 0.0; // Значение по умолчанию для стоимости аренды
        this.bank = null; // Значение по умолчанию для объекта Bank
    }

    // Метод для увеличения количества банкоматов в офисе
    public void incrementQuantityAtms() {
        numOfAtms++;
    }

    // Геттеры и сеттеры

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAtmPlacement() {
        return atmPlacement;
    }

    public void setAtmPlacement(boolean atmPlacement) {
        this.atmPlacement = atmPlacement;
    }

    public int getNumOfAtms() {
        return numOfAtms;
    }

    public void setNumOfAtms(int numOfAtms) {
        this.numOfAtms = numOfAtms;
    }

    public boolean isCreditService() {
        return creditService;
    }

    public void setCreditService(boolean creditService) {
        this.creditService = creditService;
    }

    public boolean isCashWithdrawal() {
        return cashWithdrawal;
    }

    public void setCashWithdrawal(boolean cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }

    public boolean isCashDeposit() {
        return cashDeposit;
    }

    public void setCashDeposit(boolean cashDeposit) {
        this.cashDeposit = cashDeposit;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
      public BankAtm getAtm() {
        return atm;
    }

    public void setAtm(BankAtm atm) {
        this.atm = atm;
    }
    @Override
    public String toString() {
        return "Банковский офис:{" +
                "идентификатор=" + id +
                ", название='" + name + '\'' +
                ", адрес='" + address + '\'' +
                ", статус=" + (status ? "открыт" : "закрыт") +
                ", размещение банкоматов=" + (atmPlacement ? "разрешено" : "запрещено") +
                ", количество банкоматов=" + numOfAtms +
                ", обслуживание кредитов=" + (creditService ? "включено" : "выключено") +
                ", выдача наличных=" + (cashWithdrawal ? "разрешена" : "запрещена") +
                ", прием наличных=" + (cashDeposit ? "разрешен" : "запрещен") +
                ", количество денег=" + moneyAmount +
                ", стоимость аренды=" + rentCost +
                ", банк=" + (bank != null ? bank.getName() : "Отсутствует") +
                '}';
    }



}
