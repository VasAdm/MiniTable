package ru.vasadm.minitable.controllers;

import lombok.Getter;
import lombok.Setter;
import ru.vasadm.minitable.Line;

import java.util.List;

@Getter
@Setter
public class Wrapper {
    List<Line> lineList;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        lineList.forEach(builder::append);
        return builder.toString();
    }
}
