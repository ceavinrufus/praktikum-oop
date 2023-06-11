import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeSet;

public class StudentSorter {
    public static class Student{
        private String name;
        private Map<String, Integer> courseGrades;

        public Student(String name){
            this.name = name;
            // inisialisasi hashset
            this.courseGrades = new HashMap<String, Integer>();
        }

        public void addCourseGrade(String course, int grade){
            courseGrades.put(course, grade);
        }

        public double getGPA(){
            int total = 0;
            int count = 0;
 
            for (int grade: courseGrades.values()){
                 total += grade;
                 count ++;
            }

            return (total / count);
        }

        public String getName() {
            return name;
        }
    }

    public static class StudentComparator implements Comparator<Student>{

        public int compare(Student s1, Student s2){
            double x = s1.getGPA();
            double y = s2.getGPA();

            if (x>y){
                return 1;
            }
            else if (x<y){
                return -1;
            }
            else{
                return 0;
            }
        }
    }

    public static List<Student> sortStudentsByGPA(List<Student> students){
        StudentComparator comparator = new StudentComparator();
        Student muridTemp;

        // bubble sort lol
        for (int i = 0; i < students.size(); i++){
            for (int j = i + 1; j<students.size(); j++){
                if (comparator.compare(students.get(i), students.get(j)) > 0){
                    muridTemp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, muridTemp);
                }
            }
        }

        //sorting done
        return students;
    }


}
