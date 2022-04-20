package com.timofey.airport_data.logic;

import com.timofey.airport_data.columns_name.ColumnsName;
import com.timofey.airport_data.data_input.ValueInput;
import com.timofey.airport_data.data_input.ValueInputImplementation;
import com.timofey.airport_data.input_validation.ValidInput;
import com.timofey.airport_data.input_validation.ValidInputImplementation;

public class RequestAirportList {

    private static final String CSV_FILE_PATH = "src/main/resources/airports.csv";
    private static final int DEFAULT_COLUMN_NUMBER = 3;

    /**
     * Комплексный метод по поиску строк в таблице и выдаче результата в консоль.
     * 1. Проверяется на валидность передаваемый с запуском программы аргумент.
     *    Если не проходит проверку, то в качестве номер столбца будет использоваться дефолтное
     *    значение [3 - поиск по городу]. Результат записывается в columnNumber.
     * 2. В зависимости от номера столбца, программа в консоль выдаёт его название.
     * 3. Задействуется метод по принятию и обработке запроса от пользователя,
     *    результат записывается в переменную inputString.
     * 4. Задействуется метод по получению выборки строк по запросу пользователя.
     * 5. В консоль выводится результат в виде списка строк из таблицы.
     * 6. В консоль выводится количество найденных строк и затраченное на поиск время.
     * @param args - передаваемый с запуском программы аргумент
     */
    public void findValues(String[] args) {

        ValidInput validInput = new ValidInputImplementation();
        ValueInput valueInput = new ValueInputImplementation();
        int columnNumber;

        if (validInput.checkIfArgsValid(args)) {
            columnNumber = Integer.parseInt(args[0]);
        } else columnNumber = DEFAULT_COLUMN_NUMBER;

        System.out.println(ColumnsName.valueOfColumnNumber(columnNumber));
        columnNumber--;

        String inputString = valueInput.getInputString();

        long timeBefore = System.currentTimeMillis();
        String values = valueInput.getResultRows(CSV_FILE_PATH, inputString, columnNumber).toString();

        System.out.println(values);
        System.out.println("Time spent on searching: " + (System.currentTimeMillis() - timeBefore) + " ms");

    }

    /**
     * Метод запуска программы. Пользователь может совершать сколько угодно запрос на выдачу результатов,
     * пока программа не будет закрыта программа или выбран вариант не продолжать поиск.
     * @param args - передаваемый с запуском программы аргумент
     */
    public static void startApp(String[] args) {
        ValueInput valueInput = new ValueInputImplementation();
        RequestAirportList airportList = new RequestAirportList();
        boolean continueSearch = true;

        while (continueSearch) {
            airportList.findValues(args);
            System.out.println("--------------------------------------" +
                    "\n" + "Continue searching? (Y/N): ");
            continueSearch = (valueInput.getYesOrNoAnswer());
        }
    }

}
