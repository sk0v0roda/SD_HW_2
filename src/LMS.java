import java.util.*;

// Название класса -- Learning management system, вроде по кодстайлу......
public class LMS {
    // храним список неоцененных студентов в ArrayList.
    private ArrayList<String> studentsInfo;
    // храним словарь оцененных студентов и их оценок в словаре.
    private Map<String, Integer> markedStudents;
    // единственный конструктор, принимающий на вход список студентов.
    LMS(ArrayList<String> students) {
        studentsInfo = new ArrayList<>();
        markedStudents = new HashMap<>();
        studentsInfo.addAll(students);
    }
    public void removeStudent(String student) {
        try {
            studentsInfo.remove(student);
        }
        catch (Exception ex) {
            if (studentsInfo.isEmpty()) {
                System.out.println("Все студенты оценены!");
            }
            return;
        }
    }
    public ArrayList<String> getUnmarkedStudents() {
        return studentsInfo;
    }
    public void giveMark(String student, Integer mark) {
        markedStudents.put(student, mark);
        studentsInfo.remove(student);
    }
    // метод возвращает словарь со студентами, которые уже отвечали и их оценки.
    public Map<String, Integer> getMarked() {
        return markedStudents;
    }
}
