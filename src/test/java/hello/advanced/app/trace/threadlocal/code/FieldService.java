package hello.advanced.app.trace.threadlocal.code;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {
        System.out.println("saved name = "+name+" -> nameStore = "+nameStore);
        nameStore = name;
        sleep(1000);
        System.out.println("select nameStore = " + nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
