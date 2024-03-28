package bank;

import bank.entity.*;
import bank.service.*;
import bank.service.impl.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Установка кодировки консоли на UTF-8
        System.setProperty("console.encoding", "UTF-8");

        // Создаем сервисы для управления сущностями
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        BankAtmService bankAtmService = new BankAtmServiceImpl();

        Scanner scanner = new Scanner(System.in);

        // Создаем банк
        Bank bank = bankService.createBank("МойБанк", 5, 3, 50, 1000);

        // Создаем банковский офис
        BankOffice bankOffice = bankOfficeService.createBankOffice(1, "Главный офис", "ул. Пушкина, д. 10, кв. 5", true, true, 1, true, true, true, 0, 1000, bank);

        // Создаем сотрудника
        Employee employee = employeeService.createEmployee(1, "Иван Иванов", LocalDate.of(1985, 5, 15), "Менеджер", bank, true, bankOffice, true, 5000);

        // Создаем клиента
        User user = userService.createUser(1, "Алиса Иванова", LocalDate.of(1990, 8, 20), "ул. Ленина, д. 15, кв. 3", bank);

        // Создаем платежный счет
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(1, user, bank.getName(), 10000);

        // Создаем кредитный счет
        CreditAccount creditAccount = creditAccountService.createCreditAccount(1, user, bank.getName(), "2024-03-28", "2025-03-28", 12, 5000.0, 0.0, 10.0, employee, null);

        // Создаем банкомат
        BankAtm bankAtm = bankAtmService.createBankAtm(1, "Банкомат1", "1", bankOffice, "ул. Красноармейская, д. 20", employee, true, true, 100);

        // Выводим созданные сущности
        System.out.println("Заполненные сущности:");
        System.out.println(bank);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(user);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);
        System.out.println(bankAtm);

        // Добавляем опции отображения и удаления данных
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Отобразить данные");
            System.out.println("2. Удалить данные");
            System.out.println("3. Изменить данные");
            System.out.println("4. Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayData(bankService, bankOfficeService, employeeService, userService, paymentAccountService, creditAccountService, bankAtmService);
                    break;
                case 2:
                    deleteData(scanner, bankService, bankOfficeService, employeeService, userService, paymentAccountService, creditAccountService, bankAtmService);
                    break;
                case 3:
                    modifyData(scanner, bankService, bankOfficeService, employeeService, userService, paymentAccountService, creditAccountService, bankAtmService);
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static void displayData(BankService bankService, BankOfficeService bankOfficeService, EmployeeService employeeService, UserService userService, PaymentAccountService paymentAccountService, CreditAccountService creditAccountService, BankAtmService bankAtmService) {
        // Выводим данные из сервисов
        System.out.println("\nДанные:");

        System.out.println(bankService.getBankById(1));
        System.out.println(bankOfficeService.getBankOffice(1));
        System.out.println(employeeService.getEmployeeById(1));
        System.out.println(userService.getUserById(1));
        System.out.println(paymentAccountService.getPaymentAccountById(1));
        System.out.println(creditAccountService.getCreditAccountById(1));
        System.out.println(bankAtmService.getBankAtmById(1));
    }

    private static void deleteData(Scanner scanner, BankService bank, BankOfficeService bankOffice, EmployeeService employee, UserService userService, PaymentAccountService paymentAccount, CreditAccountService creditAccount, BankAtmService bankAtm) {
        // Удаляем данные из сервисов
        System.out.println("\nУдаление данных:");
        System.out.println("Выберите тип сущности для удаления:");
        System.out.println("1. Банк");
        System.out.println("2. Банковский офис");
        System.out.println("3. Сотрудник");
        System.out.println("4. Клиент");
        System.out.println("5. Платежный счет");
        System.out.println("6. Кредитный счет");
        System.out.println("7. Банкомат");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                bank.deleteBank(1);
                break;
            case 2:
                bankOffice.deleteBankOffice(1);
                break;
            case 3:
                employee.deleteEmployee(1);
                break;
            case 4:
                userService.deleteUser(1);
                break;
            case 5:
                paymentAccount.deletePaymentAccount(1);
                break;
            case 6:
                creditAccount.deleteCreditAccount(1);
                break;
            case 7:
                bankAtm.deleteBankAtm(1);
                break;
            default:
                System.out.println("Неверный выбор. Ничего не удалено.");
        }
    }

    private static void modifyData(Scanner scanner, BankService bank, BankOfficeService bankOffice, EmployeeService employee, UserService user, PaymentAccountService paymentAccount, CreditAccountService creditAccount, BankAtmService bankAtm) {
        // Изменяем данные в сервисах
        System.out.println("\nИзменение данных:");
        System.out.println("Выберите тип сущности для изменения:");
        System.out.println("1. Банк");
        System.out.println("2. Банковский офис");
        System.out.println("3. Сотрудник");
        System.out.println("4. Клиент");
        System.out.println("5. Платежный счет");
        System.out.println("6. Кредитный счет");
        System.out.println("7. Банкомат");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите новое название банка:");
                String newName = scanner.next();
                System.out.println("Введите новое количество отделений:");
                int numOfOffices = scanner.nextInt();
                System.out.println("Введите новое количество банкоматов:");
                int numOfAtms = scanner.nextInt();
                System.out.println("Введите новое количество сотрудников:");
                int numOfEmployees = scanner.nextInt();
                System.out.println("Введите новое количество клиентов:");
                int numOfClients = scanner.nextInt();
                bank.updateBank(1, newName, numOfOffices, numOfAtms, numOfEmployees, numOfClients);
                break;

            case 2:
                System.out.println("Введите новое название офиса:");
                String newOfficeName = scanner.next();
                System.out.println("Введите новый адрес офиса:");
                String newAddress = scanner.next();
                System.out.println("Введите новый статус офиса (true/false):");
                boolean newStatus = scanner.nextBoolean();
                System.out.println("Введите новое размещение банкомата (true/false):");
                boolean newAtmPlacement = scanner.nextBoolean();
                System.out.println("Введите новое количество банкоматов:");
                int newNumOfAtms = scanner.nextInt();
                System.out.println("Введите новое наличие кредитного обслуживания (true/false):");
                boolean newCreditService = scanner.nextBoolean();
                System.out.println("Введите новую возможность снятия наличных (true/false):");
                boolean newCashWithdrawal = scanner.nextBoolean();
                System.out.println("Введите новую возможность внесения наличных (true/false):");
                boolean newCashDeposit = scanner.nextBoolean();
                System.out.println("Введите новую сумму денег в офисе:");
                double newMoneyAmount = scanner.nextDouble();
                System.out.println("Введите новую стоимость аренды:");
                double newRentCost = scanner.nextDouble();
                bankOffice.updateBankOffice(1, newOfficeName, newAddress, newStatus, newAtmPlacement, newNumOfAtms, newCreditService, newCashWithdrawal, newCashDeposit, newMoneyAmount, newRentCost, new Bank("Сбербанк", 12, 45, 9, 120));

                break;

            case 3:
                System.out.println("Введите новое имя сотрудника:");
                String newEmployeeName = scanner.next();
                System.out.println("Введите новую дату рождения сотрудника в формате ГГГГ-ММ-ДД:");
                LocalDate newEmployeeBirthDate = LocalDate.parse(scanner.next());
                System.out.println("Введите новую должность сотрудника:");
                String newPosition = scanner.next();
                System.out.println("Введите банк, на котором работает сотрудник:");
                String newWorkBankName = scanner.next(); // В данном случае вводится только название банка
                Bank newWorkBank = new Bank(newWorkBankName); // Создаем объект Bank с новым именем
                System.out.println("Введите статус нахождения на рабочем месте (true/false):");
                boolean newOnsite = scanner.nextBoolean();
                System.out.println("Введите название банковского офиса, в котором работает сотрудник:");
                String newWorkOfficeName = scanner.next(); // В данном случае вводится только название офиса
                BankOffice newWorkOffice = new BankOffice(newWorkOfficeName); // Создаем объект BankOffice с новым именем
                System.out.println("Может ли сотрудник выдавать кредиты (true/false):");
                boolean newCanIssueCredit = scanner.nextBoolean();
                System.out.println("Введите заработную плату сотрудника:");
                double newSalary = scanner.nextDouble();

                // После получения всех новых данных вызываем метод обновления сотрудника
                employee.updateEmployee(1, newEmployeeName, newEmployeeBirthDate, newPosition, newWorkBank, newOnsite, newWorkOffice, newCanIssueCredit, newSalary);
                break;


            case 4:
                System.out.println("Введите новое имя клиента:");
                String newUserName = scanner.next();
                System.out.println("Введите новую дату рождения клиента в формате ГГГГ-ММ-ДД:");
                LocalDate newBirthDate = LocalDate.parse(scanner.next());
                System.out.println("Введите новый ежемесячный доход клиента:");
                double newMonthlyIncome = scanner.nextDouble();
                System.out.println("Введите список используемых банков (разделите их запятыми, если их несколько):");
                String newBanksUsed = scanner.next();

                // После получения всех новых данных вызываем метод обновления клиента
                user.updateUser(1, newUserName, newBirthDate, newMonthlyIncome, newBanksUsed);
                break;

            case 5:
                System.out.println("Введите новое количество средств на счете:");
                double newAmount = scanner.nextDouble();

                // После получения новой суммы вызываем метод обновления платежного счета
                paymentAccount.updatePaymentAccount(1,  new User(4, "Иванов Иван Иванович", LocalDate.of(1990, 5, 15), "ул. Ленина, д. 15, кв. 3", new Bank("МойБанк", 5, 3, 50, 1000)), bank.getName(), newAmount);
                break;

            case 6:
                System.out.println("Введите новую сумму кредита:");
                double newCreditAmount = scanner.nextDouble();

                // После получения новой суммы вызываем метод обновления кредитного счета
                creditAccount.updateCreditAccount(1, new User(5, "Алёхин Иван Андреевич", LocalDate.of(1990, 5, 15), "ул. Ленина, д. 15, кв. 3", new Bank("МойБанк", 5, 3, 50, 1000)), bank.getName(), "2024-03-28", "2025-03-28", 12, newCreditAmount, 0.0, 10.0, new Employee (3,"Дакоткина Ольга"), null);
                break;

            case 7:
                System.out.println("Введите новое количество наличных в банкомате:");
                int newATMMoneyAmount = scanner.nextInt();

                // После получения нового количества наличных вызываем метод обновления банкомата
                bankAtm.updateBankAtm(1, "ATM1", "1", "Location", new Bank("Яндекс-Деньги", 12, 45, 9, 120), new BankOffice("Арутинов"), new Employee(2,"Петр Никитин"), true, true, newATMMoneyAmount, 100);
                break;



            default:
                System.out.println("Неверный выбор. Ничего не изменено.");
        }
    }
}
