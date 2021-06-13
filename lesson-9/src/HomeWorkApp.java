import java.util.*;
import java.util.stream.Collectors;

public class HomeWorkApp {

    public static void main(String[] args){

    }

    /**
     * Задание 1
     * Функцию, принимающая список Student и возвращающая список уникальных курсов, на которые подписаны студенты
     * @param students - список студентов
     * @return - список уникальных курсов всех студентов
     */
    public static Set<Course> UniqCourses(List<Student> students) {
        return students
                .stream()
                .flatMap(student -> student.getAllCourses().stream())
                .collect(Collectors.toSet());
    }

    /**
     * Задание 2
     * Функцию, принимающая на вход список Student и возвращающая список из трех самых любознательных
     * (любознательность определяется количеством курсов)
     * @param students - список студентов
     * @return - 3 самых любознательных студента
     */
    public static List<Student> InquisitiveStudents(List<Student> students) {
        return students
                .stream()
                .sorted(Comparator.comparing(student -> -1 * student.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Задание 3
     * Функцию, принимающая на вход список Student и экземпляр Course,
     * возвращающая список студентов, которые посещают этот курс.
     * @param students - список студентов
     * @param course - курс
     * @return - список студентов, посещающих курс
     */
    public static List<Student> VisitedStudents(List<Student> students, Course course) {
        return students
                .stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}