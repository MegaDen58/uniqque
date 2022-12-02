import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1,1,2,2,2,2,3,3,3,3,5,5,5,5);
        List<Integer> uniqueElements = list.stream().distinct().collect(Collectors.toList());
        
        System.out.print(uniqueElements);
    }
}