import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {

    String name;
    int balance;
    LocalDateTime openingDate;
    boolean isBlocked;
    String number;

    BankAccount(String name) {
        this.name = name;
        balance = 0;
        openingDate = LocalDateTime.now();
        isBlocked = false;
        this.number = createAccountNumber();
    }

    // Генерация номера счёта (number)
    private String createAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10)); // Цифра от 0 до 9
        }
        return sb.toString();
    }

    // Пополнение счёта
    public boolean deposit(int amount) {
        if (amount >= 0 && !isBlocked) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Снятие денег
    public boolean withdraw(int amount) {
        if (amount >= 0 && balance >= amount && !isBlocked){
            balance -= amount;
            return true;
        }
        return false;
    }

    // Перевод денег на другой счёт
    public boolean transfer(BankAccount otherAccount, int amount) {
        if (otherAccount == null || isBlocked || otherAccount.isBlocked || amount <= 0 || amount > balance) {
            return false;
        }

        if (this.withdraw(amount)) {
            return otherAccount.deposit(amount);
        }
        return false;
    }

    // Вывод в консоль информации о счёте
    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                ", isBlocked=" + isBlocked +
                ", number='" + number + '\'' +
                '}';
    }

    // Сравнение счетов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}