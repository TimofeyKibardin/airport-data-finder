package com.timofey.airport_data.data_input;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.timofey.airport_data.sorting.DataSorting;

import java.io.*;
import java.util.*;

public class ValueInputImplementation implements ValueInput {

    /**
     * Метод предназначен для опрашивания пользователя, желает ли он
     * продолжить какое-то действие в программе, предлагая ему ввести в консоль Y или N.
     * При неудачном вводе, пользователю будет предложено ввести Y или N снова до тех пор,
     * пока не будет введён предусмотренный вариант
     * @return - true если пользователь выбрал Y, false в случае N
     */
    @Override
    public boolean getYesOrNoAnswer() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Type Y or N ");
            }
        }
    }


    /**
     * Метод позволяет пользователю ввести нужный запрос для поиска по выбранному
     * при запуске программы столбцу. В случае, если запрос некорректный - пользователю
     * будет предложено повторить попытку поиска до того момента, пока в переменную inputText
     * не будет записана переменная из консоли. При выдаче Invalid Input будет принудительно завершена программа.
     * @return - String переменную, в которую записан запрос пользователя
     */
    @Override
    public String getInputString() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText;

        while (true) {
            try {
                System.out.println("Type here: ");
                inputText = reader.readLine();
                if (inputText.isBlank()) {
                    System.out.println("Request is empty, please try again:");
                } else {
                    break;
                }

            } catch (IOException e) {
                System.out.println("Invalid input");
                System.exit(-1);
            }
        }

        return inputText;
    }


    /**
     * Метод предназначен для поиска строк в csv-файле по переданному запросу от пользователя.
     * Для сортировки найденных строк внутри метода вызывается другой метод - sortInputDataByColumn().
     * Все найденные строки конвертируются через метод convertListOfRowsToStringBuilder() в переменную StringBuilder
     * Перед возвратом, метод выдаёт информацию о количестве найденных результатов.
     * @param path - путь к csv-файлу с таблицей значений
     * @param inputString - ключевое слово от пользователя, по которому будет производиться поиск
     * @param columnNumber - номер колонки, по которому будет производиться поиск и сортировка
     * @return - StringBuilder переменная с отсортированным результатом поиска
     */
    @Override
    public StringBuilder getResultRows(String path, String inputString, int columnNumber) {

        ArrayList<List<String>> listOfRows = new ArrayList<>();
        List<String> row;
        String[] nextLine;
        int rowsFound = 0;

        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {

            while ((nextLine = csvReader.readNext()) != null) {
                if (nextLine[columnNumber]
                        .toLowerCase()
                        .contains(inputString.toLowerCase())) {

                    row = Arrays.asList(nextLine);
                    listOfRows.add(row);
                    rowsFound++;
                }
            }

        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        DataSorting.sortInputDataByColumn(listOfRows, columnNumber);
        StringBuilder resultOutput = DataSorting.convertListOfRowsToStringBuilder(listOfRows);

        resultOutput.append("\n").append("Number of airports found: ").append(rowsFound);
        return resultOutput;
    }
}
