package hello.advanced.app.inheritance;

import hello.advanced.app.inheritance.code.ChildClass;
import hello.advanced.app.inheritance.code.ParentClass;
import org.junit.jupiter.api.Test;

public class InheritanceTest {

    @Test
    void number_set_in_parent() {

        ParentClass parent = new ParentClass();

        parent.setNumber(100);
        System.out.println(parent.getNumber());

        ChildClass child = new ChildClass();
        System.out.println(child.getNumber());

        child.func1();
    }
}
