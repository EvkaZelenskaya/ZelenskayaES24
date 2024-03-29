package bank;

import bank.entity.*;
import bank.service.*;
import bank.service.impl.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        BankAtmService bankAtmService = new BankAtmServiceImpl();

        List<Bank> banks = new ArrayList<>();
        List<BankOffice> bankOffices = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<BankAtm> bankAtms = new ArrayList<>();

        // Создание 5 банков
        for (int i = 0; i < 5; i++) {
            Bank bank = bankService.createBank("Банк " + (char) ('A' + i), 3, 3, 15, 50);
            banks.add(bank);

            // Создание офисов для каждого банка
            for (int j = 0; j < 3; j++) {
                int officeId = bankOffices.size() + 1; // Генерация уникального идентификатора офиса
                BankOffice office = bankOfficeService.createBankOffice(officeId, "Офис " + officeId + " " + bank.getName(), "Адрес " + officeId, true, true, 70 + officeId, true, true, true, 4566300 + officeId, 1235400 + officeId, bank);
                bankOffices.add(office);

                // Создание сотрудников для каждого офиса
                for (int k = 0; k < 5; k++) {
                    int employeeId = employees.size() + 1; // Генерация уникального идентификатора сотрудника
                    Employee employee = employeeService.createEmployee(employeeId, "Сотрудник " + employeeId + " " + office.getName(), LocalDate.of(1980, k + 1, k + 1), "Должность " + (k + 1), bank, true, office, true, 1000 * (k + 1));
                    employees.add(employee);
                }

                // Создание клиентов для каждого офиса
                for (int k = 0; k < 5; k++) {
                    int userId = users.size() + 1; // Генерация уникального идентификатора пользователя
                    User user = userService.createUser(userId, "Клиент " + userId + " " + office.getName(), LocalDate.of(1990 - k, k + 1, k + 1), "user" + userId + "@mail.com", bank);
                    users.add(user);

                    // Создание платежных счетов для каждого клиента
                    PaymentAccount paymentAccount1 = paymentAccountService.createPaymentAccount((userId + 1) * 10000, user, (userId + 1) * 10000);
                    PaymentAccount paymentAccount2 = paymentAccountService.createPaymentAccount((userId + 2) * 10000, user, (userId + 2) * 10000);

                    // Создание кредитных счетов для каждого клиента
                    CreditAccount creditAccount1 = creditAccountService.createCreditAccount((userId + 1) * 10000, user, "Кредитный счет 1 для клиента " + userId, "2024-01-04", "2024-06-04", 5, 50000.0, 10000.0, 0.2, employees.get(0), paymentAccount1);
                    CreditAccount creditAccount2 = creditAccountService.createCreditAccount((userId + 2) * 10000, user, "Кредитный счет 2 для клиента " + userId, "2024-04-04", "2024-10-04", 6, 70000.0, 600.0, 0.18, employees.get(0), paymentAccount2);
                }
            }

            // Создание банкоматов для каждого банка
            for (int j = 0; j < 3; j++) {
                try {
                    BankOffice office = bankOffices.get(i * 3 + j); // Получаем соответствующий офис банка
                    Employee employee = employees.get(i * 3 + j); // Получаем соответствующего сотрудника банка
                    BankAtm atm = bankAtmService.createBankAtm(j + 1, "Банкомат " + (j + 1) + " " + bank.getName(), "1", office, "Адрес " + (j + 1), employee, true, true, true, 500.0);
                    bankAtms.add(atm);
                } catch (Exception e) {
                    System.out.println("Ошибка: Невозможно создать банкомат.");
                    e.printStackTrace(); // Это поможет вам увидеть дополнительную информацию об ошибке
                }
            }

        }

        // Вывод всех данных по банкам
        for (Bank bank : banks) {
            System.out.println("Банк: " + bank.getName());
            System.out.println("Банкоматы: " + bankAtmService.getAllBankAtm());
            System.out.println("Офисы: " + bankOfficeService.getAllBankOffices());
            System.out.println("Сотрудники: " + employeeService.getAllEmployees());
            System.out.println("Клиенты: " + userService.getAllUsers());
            System.out.println();
        }

        // Вывод всех счетов для каждого клиента
        for (User user : users) {
            System.out.println("Счета для клиента " + user.getFullName() + ": ");
            System.out.println("Платежные счета: " + paymentAccountService.getAllPaymentAccountsByUser(user));
            System.out.println("Кредитные счета: " + creditAccountService.getAllCreditAccountsByUser(user));
            System.out.println();
        }
    }
}
