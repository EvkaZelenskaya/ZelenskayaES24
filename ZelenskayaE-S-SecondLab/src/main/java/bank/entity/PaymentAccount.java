package bank.entity;

/**
 * Класс, представляющий платежный счет пользователя.
 */
public class PaymentAccount {
    private int id; // Идентификатор платежного счета
    private User user; // Пользователь, которому принадлежит счет
    private String bankName; // Название банка, в котором открыт счет
    private double amount; // Сумма на счете

    /**
     * Конструктор класса PaymentAccount с параметрами.
     *
     * @param id       Идентификатор платежного счета.
     * @param user     Пользователь, которому принадлежит счет.
     * @param bankName Название банка, в котором открыт счет.
     * @param amount   Сумма на счете.
     */
    public PaymentAccount(int id, User user, String bankName, double amount) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.amount = amount;
    }



    // Геттеры и сеттеры для полей

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Платежный счет:{" +
                "идентификатор=" + id +
                ", пользователь=" + user.getFullName() +
                ", название банка='" + bankName + '\'' +
                ", сумма=" + amount +
                '}';
    }

    public int getBalance() {
        return (int) amount; // Если вы хотите вернуть сумму как целое число, приведите ее к типу int
    }

}
