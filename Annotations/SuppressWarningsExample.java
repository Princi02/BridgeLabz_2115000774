import java.util.ArrayList;
import java.util.List;

public class SuppressWarningsExample {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        List rawList = new ArrayList();

        rawList.add("Hello");
        rawList.add(42); 
        
        List<String> stringList = rawList;
        
        for (Object obj : stringList) {
            System.out.println(obj);
        }
    }
}
