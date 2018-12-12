package Array;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Array.Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> studentArray=new Array<Student>();
        studentArray.addLast(new Student("ben",17));
        studentArray.addLast(new Student("pen",17));
        studentArray.addLast(new Student("ren",17));
        System.out.println(studentArray);

    }
}