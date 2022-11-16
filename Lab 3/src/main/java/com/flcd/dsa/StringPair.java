package com.flcd.dsa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StringPair {
    private String first;
    private String second;

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}
