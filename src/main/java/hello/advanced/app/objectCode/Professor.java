package hello.advanced.app.objectCode;

public class Professor {
    private String name;
    private Lecture lecture;

    // professor 객체 생성자가 lecture 그대로 갖다쓰고 있음
    //
    public Professor(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Avg: %.1f", name,
                lecture.evaluate(), lecture.average());
    }
}
