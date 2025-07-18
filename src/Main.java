public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Иван");
        BankAccount account2 = new BankAccount("Пётр");

        account1.deposit(3500);
        System.out.println("После пополнения:");
        System.out.println(account1);
        System.out.println(account2);

        account1.transfer(account2, 1500);
        System.out.println("\nПосле перевода:");
        System.out.println(account1);
        System.out.println(account2);

        boolean success = account1.withdraw(2000);
        System.out.println("\nПопытка снять 1000: " + (success ? "Успешно" : "Неудача"));

        boolean fail = account2.withdraw(5500);
        System.out.println("\nПопытка снять 5500: " + (fail ? "Успешно" : "Неудача"));

        System.out.println("\nСравнение счетов:");
        System.out.println("account1.equals(account2): " + account1.equals(account2));


        BankAccount account3 = new BankAccount("Иван");
        System.out.println("account1.equals(account3): " + account1.equals(account3));
    }
}