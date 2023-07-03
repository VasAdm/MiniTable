package ru.vasadm.minitable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyTest {
    String a1;
    String a2;
    String a3;
    String a4;

    @Override
    public String toString() {
        return "Test{" +
                "a1='" + a1 + '\'' +
                ", a2='" + a2 + '\'' +
                ", a3='" + a3 + '\'' +
                ", a4='" + a4 + '\'' +
                '}';
    }
}
