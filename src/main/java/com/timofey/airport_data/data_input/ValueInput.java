package com.timofey.airport_data.data_input;

public interface ValueInput {

    public boolean getYesOrNoAnswer();

    public String getInputString();

    public StringBuilder getResultRows(String path, String inputString, int columnNumber);

}
