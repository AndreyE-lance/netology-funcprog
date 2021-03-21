package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String inputString = readToString();
        
        //Дальше все очень по-функциональному.;)
        // Функция, которая составляет словарь, должна быть оформлена как реализатор Function
        Function<String, String[]> stringToArray = s -> Arrays.stream(s.split("\\s+")).distinct().toArray(String[]::new);

        String[] array = stringToArray.apply(inputString);
        List<String> list = Arrays.stream(array).sorted().collect(Collectors.toList());
        System.out.println("Словарь");
        list.forEach(System.out::println);
    }

    private static String readToString() {
        File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "input.txt");
        StringBuilder sBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                sBuilder.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sBuilder.toString();
    }


}
