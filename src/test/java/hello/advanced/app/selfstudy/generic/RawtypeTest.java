package hello.advanced.app.selfstudy.generic;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RawtypeTest {

    @Test
    void raw_type() {
        List raw = new ArrayList();

        raw.add(1);
        raw.add("문자열");
        raw.add(Boolean.FALSE);
        // 로 타입도 여기까지 가능은 하다 그러나

        for( Object o : raw ) {
            String s = (String) o;
            System.out.println(s); // ClassCastException
        }

    }

    @Test
    void generic_type() {
        List<String> generic = new ArrayList();

        //generic.add(1); error
        generic.add("문자열");
        //generic.add(Boolean.FALSE); error
        // add 부터 안되니까 에러 시점을 빠르고 정확하게 확인가능

        for( Object o : generic ) {
            String s = (String) o;
            System.out.println(s);
        }

    }




}
