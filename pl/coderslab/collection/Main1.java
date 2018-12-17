package pl.coderslab.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {
    private static final Pattern PATERN_MONEY = Pattern.compile("\\d+\\.\\d+ zł");
    private static final Pattern PATERN_NAME = Pattern.compile("Kowalsk[ia]");
    private static final Pattern PATERN_DOUBLE = Pattern.compile("\\d+\\.\\d+");

    public static void main(String[] args) {
        try {
            File file = new File("earnings.txt");
            Scanner scan = new Scanner(file);
            ArrayList<String> employeesNotRelated = new ArrayList<>();
            ArrayList<Double> salaries = new ArrayList<>();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (containsMoney(line) && !hasNameKowalski(line)) {
                    employeesNotRelated.add(line);
                    salaries.add(extractMoney(line));
                }
            }
            ArrayList<String> employeesForFire = extractBestPaid(employeesNotRelated, salaries, 3);
            System.out.println("**** Pracownicy do zwolnienia ****");
            for (String employee : employeesForFire) {
                System.out.println(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }


    static boolean containsMoney(String text) {
        Matcher matcher = PATERN_MONEY.matcher(text);
        return matcher.find();
    }


    static Double extractMoney(String text) throws NumberFormatException {
        Matcher matcher = PATERN_DOUBLE.matcher(text);
        matcher.find();
        String money = text.substring(matcher.start(), matcher.end() - 3);
        Double salary = Double.parseDouble(money);
        return salary;
    }


    static boolean hasNameKowalski(String text) {
        Matcher matcher1 = PATERN_NAME.matcher(text);
        return matcher1.find();
    }


    static ArrayList<String> extractBestPaid(ArrayList<String> employees, ArrayList<Double> salaries, int count) {
        ArrayList<String> highestSalaries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ListIterator<Double> it = salaries.listIterator();
            Double max = it.next();
            int index = 0;
            int j;
            for (j = 0; j < salaries.size(); j++) {
                if (salaries.get(j) > max) {
                    max = salaries.get(j);
                    index = j;
                }
            }
            highestSalaries.add(employees.get(index));
            salaries.remove(index);
            employees.remove(index);
        }
        return highestSalaries;
    }


}
