package ru.vasadm.minitable;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Line {
    private int id;
    private List<String> cellsValues;

    public Line() {
    }

    public Line(int id, List<String> cellsValues) {
        this.id = id;
        this.cellsValues = cellsValues;
    }

    @Override
    public String toString() {
        return cellsValues.toString();
    }
}
