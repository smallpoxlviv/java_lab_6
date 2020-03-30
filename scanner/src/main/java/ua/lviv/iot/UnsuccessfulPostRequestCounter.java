package ua.lviv.iot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;

public class UnsuccessfulPostRequestCounter {

    public static String readTextFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            StringBuilder stringBuilder = new StringBuilder();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append('\n');
            }
            string = stringBuilder.toString();
            return string;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return "FileNotFoundException";
        } catch (IOException e) {
            e.printStackTrace();
            return "IOException";
        }
    }

    public int countUnsuccessfulPostRequestFromFileBetween10and11oclock(String fileName) {
        String regex = "10:[0-5][0-9]:[0-5][0-9].+POST.+HTTP.{4}\"\\s[400-599]";
        Pattern pattern = Pattern.compile(regex);
        String textFromFile = UnsuccessfulPostRequestCounter.readTextFromFile(fileName);
        Matcher matcher = pattern.matcher(textFromFile);

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }
}
