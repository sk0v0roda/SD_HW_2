import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Stepan Skovoroda");
        students.add("Maxim Valera");
        students.add("Glad Valakas");
        students.add("Froggy Frog");
        LMS firstClass = new LMS(students);
        String input;
        Scanner console = new Scanner(System.in);
        do {
            System.out.println("/r - choose random student\n/l - list of students with grades\n/kill - kill program");
            input = console.nextLine();
            if (input.equals("/r")) {
                int randomStudentIndex = (int)(Math.random() * (firstClass.getUnmarkedStudents().size()));
                String answer;
                do {
                    System.out.println("Отвечает " + firstClass.getUnmarkedStudents().get(randomStudentIndex) + "\n" + "Присутствует ли на паре? (y / n)");
                    answer = console.nextLine();
                } while (!(answer.equals("y") || answer.equals("n")));
                if (answer.equals("y")) {
                    System.out.println("Оценка?");
                    try {
                        firstClass.giveMark(firstClass.getUnmarkedStudents().get(randomStudentIndex), Integer.parseInt(console.nextLine()));
                        if (firstClass.getUnmarkedStudents().isEmpty()) {
                            System.out.println("Все студенты оценены!");
                            for (String student :
                                    firstClass.getMarked().keySet()) {
                                System.out.println(student + " : " + firstClass.getMarked().get(student));
                            }
                            input = "/kill";
                        }
                    }
                    catch (Exception ex) {
                        System.out.println("Вы ввели не целое число, давайте пробовать заново :(\n" + ex.getMessage());
                    }
                }
                else {
                    firstClass.removeStudent(firstClass.getUnmarkedStudents().get(randomStudentIndex));
                    System.out.println("Понял, начинаем заново");
                }
            }
            else if (input.equals("/l")) {
                try {
                    for (String student :
                            firstClass.getMarked().keySet()) {
                        System.out.println(student + " : " + firstClass.getMarked().get(student));
                    }
                }
                catch (Exception ex) {
                    System.out.println("Пока никого не оценили!");
                }
            }
        } while (!input.equals("/kill"));
    }
}