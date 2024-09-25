import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас числа Люка
 * @author dacko
 */
class LucasNumber{
    private int index;
    private long value;

    /**
     *  Конструктор класу
     * @param index номер числа Люка
     * @param value значення числа Люка
     */
    public LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Метод для доступу до номеру числа Люка
     * @return Повертає номер числа Люка
     */
    public int getIndex() {
        return index;
    }

    /**
     * Метод для доступу до числа Люка
     * @return повертає значення числа Люка.
     */
    public long getValue() {
        return value;
    }

    /**
     * Метод для перевірки чи є число кубом.
     * @return Якщо округлений результат Math.cbrt в кубі дорівнює значенню числа, то повертає true, інакше false.
     */
    public boolean isCube() {
        int x = (int) Math.round(Math.cbrt(value));
        // If cube of cube_root is equals to n,
        // then print Yes else print No
        return (x * x * x == value);
    }

    /**
     * Перевизначення стандартного методу toString()
     * @return Повертає строку в якій написаний номер та значення числа Люка.
     */
    @Override
    public String toString() {
        return "Число Лукаса: " +
                "індекс =" + index +
                ", значення =" + value;
    }
}

/**
 * Головний клас програми.
 * @author dacko
 */
public class LucasNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        System.out.println("Введіть N:");
        N = in.nextInt();
        List<LucasNumber> lucasNumbers = generateLucasNumbers(N);

        System.out.println("Lucas numbers that are cubes:");
        for (LucasNumber lucas : lucasNumbers) {
            if (lucas.isCube()) {
                System.out.println(lucas);
            }
        }
    }

    /**
     * Метод для генерації перших N чисел Люка.
     * @param N Кількість перших чисел Люка.
     * @return повертає новий сгенерований список з числами Люка.
     */
    private static List<LucasNumber> generateLucasNumbers(int N) {
        List<LucasNumber> lucasNumbers = new ArrayList<>();
        long first = 1, second = 3;

        lucasNumbers.add(new LucasNumber(0, first));
        lucasNumbers.add(new LucasNumber(1, second));

        for (int i = 2; i < N; i++) {
            long next = first + second;
            lucasNumbers.add(new LucasNumber(i, next));
            first = second;
            second = next;
        }

        return lucasNumbers;
    }
}