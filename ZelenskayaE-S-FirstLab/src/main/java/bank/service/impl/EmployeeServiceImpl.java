package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee;

    @Override
    public Employee createEmployee(int id, String name, LocalDate birthDate, String position, Bank workBank, boolean onsite, BankOffice workOffice, boolean canIssueCredit, double salary) {
        if (this.employee == null) {
            this.employee = new Employee(id, name, birthDate, position, workBank, onsite, workOffice, canIssueCredit, salary);
            System.out.println("Сотрудник успешно добавлен.");
            return this.employee;
        } else {
            System.out.println("Ошибка: Сотрудник уже существует.");
            return null;
        }
    }

    @Override
    public void updateEmployee(int id, String name, LocalDate birthDate, String position, Bank workBank, boolean onsite, BankOffice workOffice, boolean canIssueCredit, double salary) {
        if (this.employee != null && this.employee.getId() == id) {
            this.employee.setName(name);
            this.employee.setBirthDate(birthDate);
            this.employee.setPosition(position);
            this.employee.setWorkBank(workBank);
            this.employee.setOnsite(onsite);
            this.employee.setWorkOffice(workOffice);
            this.employee.setCanIssueCredit(canIssueCredit);
            this.employee.setSalary(salary);
            System.out.println("Сотрудник успешно обновлен.");
        } else {
            System.out.println("Ошибка: Сотрудник не найден.");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        if (this.employee != null && this.employee.getId() == id) {
            this.employee = null;
            System.out.println("Сотрудник успешно удален.");
        } else {
            System.out.println("Ошибка: Сотрудник не найден.");
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        if (this.employee != null && this.employee.getId() == id) {
            return this.employee;
        } else {
            System.out.println("Ошибка: Сотрудник не найден.");
            return null;
        }
    }


}
