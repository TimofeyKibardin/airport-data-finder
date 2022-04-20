package com.timofey.airport_data.columns_name;

import java.util.HashMap;
import java.util.Map;

public enum ColumnsName {

    AirportTableID (1, "row number in table"),
    AirportName (2, "airport name"),
    City (3, "city"),
    Country (4, "country"),
    IATA_code (5, "IATA code"),
    ICAO_code (6, "ICAO code"),
    Latitude (7, "latitude"),
    Longitude (8, "longitude"),
    Altitude (9, "altitude (in feet)"),
    Timezone_number (10, "timezone number"),
    DST (11, "daylight saving time (DST)"),
    Timezone_region_name (12, "timezone region name"),
    Object_type (13, "object type"),
    Table_source (14, "table source");

    private static final Map<Integer, ColumnsName> COLUMNS_NAME_MAP = new HashMap<>();
    private final int columnNumber;
    private final String columnName;

    static {
        for (ColumnsName cn : values()) {
            COLUMNS_NAME_MAP.put(cn.columnNumber, cn);
        }
    }

    ColumnsName(int columnNumber, String columnName) {
        this.columnNumber = columnNumber;
        this.columnName = columnName;
    }

    /**
     * Метод возвращает строковое описание enum-переменной, в зависимости от переданного
     * значения columnNumber
     * @param columnNumber - номер строки в таблице
     * @return - строковое описание enum-переменной
     */
    public static ColumnsName valueOfColumnNumber(int columnNumber) {
        return COLUMNS_NAME_MAP.get(columnNumber);
    }

    @Override
    public String toString() {
        return "Filter by: " + columnName;
    }
}
