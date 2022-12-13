package hello.advanced.app.trace.threadlocal;

import hello.advanced.app.trace.threadlocal.code.FieldService;
// import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 롬복 implementation이 자꾸 추가됨;
 */
// @Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field_thread_문제_X() {
        System.out.println("main start!");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("threadB");

        threadA.start();
        sleep(2000);

        threadB.start();
        sleep(3000);
        System.out.println("main end");

        /**
         * saved name = userA -> nameStore = null
         * select nameStore = userA
         * saved name = userB -> nameStore = userA
         * select nameStore = userB
         */

    }

    @Test
    void field_thread_문제_O() {
        System.out.println("main start!");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("threadB");

        threadA.start();
        sleep(100); //여기만 수정

        threadB.start();
        sleep(3000);
        System.out.println("main end");

        /**
         * saved name = userA -> nameStore = null
         * saved name = userB -> nameStore = userA
         * select nameStore = userB
         * select nameStore = userB
         */

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
