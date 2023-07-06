package ru.vasadm.minitable.services;

import lombok.Getter;
import lombok.Setter;
import ru.vasadm.minitable.Line;

import java.util.List;
import java.util.Locale;

@Getter
@Setter
public class Wrapper {
    private List<Line> lineList;

    public String getCellValue(String index) {
        Line line = lineList.get(Integer.parseInt(index.substring(1)) - 1);
        String value;
        switch (index.toLowerCase(Locale.ROOT).substring(0,1)) {
            case "a":
                value = line.getValues().get(0);
                return value.equals("") ? "0" : value;
            case "b":
                value = line.getValues().get(1);
                return value.equals("") ? "0" : value;
            case "c":
                value = line.getValues().get(2);
                return value.equals("") ? "0" : value;
            case "d":
                value = line.getValues().get(3);
                return value.equals("") ? "0" : value;
        }
        return null;
    }
}
