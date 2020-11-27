package ua.edu.ucu.smartarr;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

// Base array for decorators
@Getter @Setter
public class BaseArray implements SmartArray {
    private ArrayList<Object> array;

    public BaseArray(ArrayList<Object> array) {
        this.array = array;
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public String operationDescription() {
        return array.toString();
    }

    @Override
    public int size() {
        return array.size();
    }
}
