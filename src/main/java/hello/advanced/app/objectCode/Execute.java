package hello.advanced.app.objectCode;

import java.util.Arrays;

public class Execute {

    public static void main(String[] args) {
        Professor professor = new Professor("professor1",
                new Lecture("강의1",
                70,
                Arrays.asList(81, 95, 75, 50, 45)
                )
        );

        String ststics = professor.compileStatistics();
        System.out.println(ststics);


        Professor professor2 = new Professor("교수2",
                new GradeLecture("알고리즘 강의",
                70,
                Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("E", 49, 0)
                ),
                Arrays.asList(81, 95, 75, 50, 45))
        );

        String statistics2 = professor2.compileStatistics();
        System.out.println(statistics2);

        // 요게 업캐스팅 부모 = 자식
        Lecture lecture = new GradeLecture("객체지향 프로그래밍",
                70,
                Arrays.asList(
                        new Grade("C", 79, 70),
                        new Grade("B", 94, 80),
                        new Grade("A", 100, 95),
                        new Grade("D", 69, 50),
                        new Grade("E", 49, 0)),
                Arrays.asList(81, 95, 75, 50, 45)
        );

        // 다운캐스팅 자식 = 부모
        GradeLecture gradeLecture = (GradeLecture) lecture;


        // gradeLecture : 자식
        // lecture : 부모
        // GradeLecture(자식)에게 없지만 메서드(stats- 부모에게는 없음)를 실행시키고 싶으면?
        gradeLecture.stats();
        System.out.println(gradeLecture.stats()); // 부모-자식에 둘다 찾아보고 있는걸로 실행시켜줌 (self가 우선) - 동적바인딩
        //자식 먼저 확인 -> 부모 확인

        // self는 변하지 않고 (그대로 참조) : 결국 실행되는 것은 self


        // p.425 super를 실행시점에 결정할수도 있는 경우


    }
}
