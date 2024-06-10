package data;

public class Student {
    protected String code;
    protected String name;
    protected int mark;

    public Student() {
    }

    public Student(String code, String name, int mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" + "code=" + code + ", name=" + name + ", mark=" + mark + '}';
    }
    
    public void showProfile() {
        System.out.printf("|%-4s|%-20s|%-4d|\n",
                            code, name, mark);
    }
}
