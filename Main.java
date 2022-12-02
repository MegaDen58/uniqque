import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String text = "";
        int[] array = {1,4,4,4,1,1,1,6,6,6,4,3};
        Set<Integer> set = new HashSet<>();
        for(int count = 0; count < array.length; count++){
            set.add(array[count]);
        }

        int[] newArray = Arrays.stream(array).distinct().toArray();
        int[] counter = new int[newArray.length];
        int[] counter2 = new int[newArray.length];
        for(int count = 0; count < counter.length; count++){
            counter[count] = findCount(array, newArray[count]);
            counter2[count] = findCount(array, newArray[count]);
        }

        String firstArray = deleteAll(Arrays.toString(newArray));
        String secondArray = deleteAll(Arrays.toString(counter));

        System.out.println(firstArray + " - уникальные элементы");
        System.out.println(secondArray + " - кол-во каждого элемента");

        Arrays.sort(counter2);
        int[] counter3 = reverse(counter2);
        int[] ggg = Arrays.stream(counter3).distinct().toArray();
        text = deleteAll(Arrays.toString(ggg));

        String numberAndCount = toConcat(firstArray, secondArray);

        System.out.println(numberAndCount + " - число-количество");

        String result = toResult(numberAndCount, text);

        System.out.println(result + " - отсортированное число-количество");

        int[] resultArray = new int[findArrayElements(result)];
        String[] numbers = createArray(result).split(" ");
        for(int count = 0; count < resultArray.length; count++){
            resultArray[count] = Integer.parseInt(numbers[count]);
        }

        System.out.println(Arrays.toString(resultArray));
    }

    public static int findCount(int[] first, int number){
        int counter = 0;
        for(int count = 0; count < first.length; count++){
            if(number == first[count]){
                counter++;
            }
        }
        return counter;
    }

    public static int[] reverse(int[] numbers){
        int[] result = new int[numbers.length];
        for(int count = numbers.length - 1, count1 = 0; count1 < numbers.length; count--, count1++){
            result[count1] = numbers[count];
        }
        return result;
    }

    public static String deleteAll(String text){
        text = text.replaceAll("\\[", "");
        text = text.replaceAll("\\]", "");
        text = text.replaceAll(",", "");

        return text;
    }

    public static String toConcat(String text, String text1){
        String toOut = "";
        String[] words = text.split(" ");
        String[] words1 = text1.split(" ");

        for(int count = 0; count < words.length; count++){
            toOut += words[count] + "-" + words1[count] + " ";
        }
        return toOut;
    }

    public static String toResult(String text, String unique){
        String toOut = "";
        String[] words = text.split(" ");
        String[] numbers = unique.split(" ");

        for(int count = 0; count < numbers.length; count++){
            for(int count1 = 0; count1 < words.length; count1++){
                String whereFind = words[count1];
                String whatFind = "-" + numbers[count];
                if(whereFind.contains(whatFind)){
                    toOut += words[count1] + " ";
                }
            }
        }
        return toOut;
    }

    public static int findArrayElements(String text){
        int toOut = 0;
        String[] array = text.split(" ");
        for(int count = 0; count < array.length; count++){
            String[] array2 = array[count].split("-");
            toOut += Integer.parseInt(array2[array2.length - 1]);
        }
        return toOut;
    }

    public static String createArray(String text){
        String toOup = "";
        int number;
        int counter;
        String[] array = text.split(" ");
        for(int count = 0; count < array.length; count++){
            String[] array2 = array[count].split("-");
            number = Integer.parseInt(array2[0]);
            counter = Integer.parseInt(array2[1]);
            for(int k = 0; k < counter; k++){
                toOup += number + " ";
            }
        }
        return toOup;
    }
}