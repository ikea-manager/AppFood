import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {

    HashMap<String, ArrayList<Double>> expensesByCategories;
    ArrayList<Double> expenses; // Замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expenses = new ArrayList<>();
        expensesByCategories = new HashMap<>();// Создайте таблицу
    }

    // Добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        expenses.add(expense); // Замените на работу с таблицей
        if (expensesByCategories.containsKey(category) == true) {// Проверьте наличие категории
            expenses = new ArrayList<>(); // Получите список трат в этой категории
            expenses.add(expense); // Добавьте трату
        } else {
            ArrayList<Double> expenses = new ArrayList<>();;// Создайте новый список трат и добавьте в него сумму
            expensesByCategories.put(category, expenses); // Сохраните категорию и новый список трат в хеш-таблицу
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpenses() {
        // Замените логику для работы с таблицами
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println("Трата № " + (i + 1) + ". Потрачено " + expenses.get(i) + " рублей");
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        if (expensesByCategories.containsKey(category) == true) {
            for (String cat : expensesByCategories.keySet()) {
                for (Double exp : expensesByCategories.get(cat)) {
                    if (exp > maxExpense) {
                        maxExpense = exp;
                    }
                }
            }
        } else System.out.println("Такой категории пока нет.");
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }
}