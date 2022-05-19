package com.timofey.airport_data.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataSorting {

    /**
     * Метод производит сортировку передаваемого массива ArrayList<List<String>>.
     * Сортировка производится по номеру столбца.
     * Сортировка проивзодится в лексиграфическом порядке для строк и
     * в порядке возрастания для численных значений.
     * @param listOfRows - Список найденных строк при поиске
     * @param columnNumber - Номер столбца, по которому нужно произвести сортировку
     */
    public static void sortInputDataByColumn(ArrayList<List<String>> listOfRows, int columnNumber) {

        if (columnNumber == 1 || columnNumber == 2) {
            listOfRows.sort(Comparator.comparing(l -> l.get(1)));
        }
        else if (columnNumber == 3){
            listOfRows.sort(Comparator.comparing(l -> l.get(2)));
        }
        else {
            listOfRows.sort(Comparator.comparing(l -> l.get(columnNumber)));
        }

    }


    /**
     * Метод производит конвертацию списка строк из ArrayList в StringBuilder,
     * разделяя строки символами перехода на новую строку
     * @param listOfRows - Список найденных строк при поиске
     * @return - Переменная StringBuilder со списком строк
     */
    public static StringBuilder convertListOfRowsToStringBuilder(ArrayList<List<String>> listOfRows) {
        StringBuilder resultOutput = new StringBuilder();
        for (List<String> listOfRow : listOfRows) {
            resultOutput.append(listOfRow).append("\n");
        }
        return resultOutput;
    }
}
