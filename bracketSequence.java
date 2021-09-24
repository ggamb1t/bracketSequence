import java.io.IOException;
import java.util.*;


public class bracketSequence
{
    public static void main(String[] args) throws IOException {
         runTests(); // Прогнать тестовые строки через алгоритм
        // Для прогона тестовых строк раскомментируйте строку выше

        boolean stringIsValid; // true - если строка правильная, иначе - false
        stringIsValid = bracketsCheck(getNewStringFromKeyboard());
        printResult(stringIsValid);
    }

    public static String getNewStringFromKeyboard() {
        Scanner in = new Scanner(System.in);
        System.out.print("\n   Enter your string:");
        return in.next();
    }

    private static void printResult(boolean goodOrBad) {
        System.out.print((goodOrBad)?"String is good":"String is bad ");
    }

    private static boolean bracketsCheck(String str) {
        Stack<Character> stack_brackets = new Stack<Character>(); // Создание стэка типа Character
        try {
            for (int i = 0; i < str.length(); i++) {

                Character currentChar = str.charAt(i);

                switch (currentChar) { // Посимвольная проверка строки
                    case '(': // Встретились открывающие скобки
                        stack_brackets.push(currentChar); // Если встречается открытая скобка - добавляем её в стэк
                        break;
                    case '{':
                        stack_brackets.push(currentChar);
                        break;
                    case '[':
                        stack_brackets.push(currentChar);
                        break;

                    case ')':// Встретились закрывающие скобки
                        if (stack_brackets.pop() != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack_brackets.pop() != '{')
                            return false;
                        break;
                    case ']':
                        if (stack_brackets.pop() != '[')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        catch (EmptyStackException exc) {  // Исключение возникало при попытке вынуть элемент из пустого стэка
            return false;
        }
        return stack_brackets.empty();
    }

    public static void runTests()
    {
        String[] strings = {"C{D#(F)}",                  // correct
                            "C)(D#{F#}[F]()",            // incorrect
                            "(C){([D#])()[]}[F]{D#}(C)", // correct
                            "(h[e]}l{l(o)}",             // incorrect
                            "{d}[i](p)[[c[h]i]p]]"};     //incorrect
        for (int i = 0; i < strings.length; i++)
        {
            System.out.print("\n   " + strings[i]+"   ");
            printResult(bracketsCheck(strings[i]));
        }
    }
}