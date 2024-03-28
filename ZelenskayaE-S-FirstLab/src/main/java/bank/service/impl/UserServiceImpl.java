package bank.service.impl;

import bank.entity.Bank;
import bank.entity.Employee;
import bank.entity.User;
import bank.service.UserService;

import java.time.LocalDate;

public class UserServiceImpl implements UserService {
    private User user;

    @Override
    public User createUser(int id, String fullName, LocalDate birthDate, String workplace, Bank bank) {
        if (user == null) {
            user = new User(id, fullName, birthDate, workplace, bank);
            System.out.println("Пользователь успешно создан.");
            return user; // Возвращаем созданный объект User
        } else {
            System.out.println("Ошибка: Пользователь уже существует.");
            return null;
        }
}



    @Override
    public void updateUser(int userId, String newName, LocalDate birthDate, double newMonthlyIncome, String newBanksUsed) {
        if (user != null && user.getId() == userId) {
            user.getFullName();
            user.setBirthDate(birthDate);
            user.setMonthlyIncome(newMonthlyIncome);
            user.setBanksUsed(newBanksUsed);
            System.out.println("Пользователь успешно обновлен.");
        } else if (user == null) {
            System.out.println("Ошибка: Пользователь не существует.");
        } else {
            System.out.println("Ошибка: Неверные данные для обновления пользователя.");
        }
    }


    @Override
    public void deleteUser(int userId) {
        if (user != null && user.getId() == userId) {
            user = null;
            System.out.println("Пользователь успешно удален.");
        } else {
            System.out.println("Ошибка: Пользователь не найден.");
        }
    }

    @Override
    public User getUserById(int userId) {
        if (user != null && user.getId() == userId) {
            return this.user;
        }else {
            System.out.println("Ошибка: Пользователь не найден.");
            return null;
        }
    }



}
