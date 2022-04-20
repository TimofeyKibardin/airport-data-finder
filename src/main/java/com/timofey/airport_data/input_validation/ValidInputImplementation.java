package com.timofey.airport_data.input_validation;

public class ValidInputImplementation implements ValidInput {

    /**
     * Метод проверяет передаваемый пользователем параметр args,
     * чтобы он входил в промежуток от 1 до 14 включительно,
     * чтобы цифра соответствовала номеру столбца в таблице
     * @param args - передаваемый с запуском программы аргумент
     * @return - true если в промежутке от 1 до 14, false - в остальных случаях.
     */
    @Override
    public boolean checkIfArgsValid(String[] args) {
        if (args != null && args.length == 1) {
            try {
                int a = Integer.parseInt(args[0]);
                return a > 0 && a < 15;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
