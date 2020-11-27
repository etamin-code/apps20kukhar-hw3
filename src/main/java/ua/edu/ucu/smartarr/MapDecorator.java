package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction myFunction;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        this.myFunction = myFunction;
    }


    @Override
    public Object[] toArray() {
        Object[] oldArray = smartArray.toArray();
        ArrayList<Object> newArray = new ArrayList<>();
        for (Object el1 : oldArray) {
            newArray.add(myFunction.apply(el1));
        }
        return newArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "change each object in smartArray on the myFunction(object)";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
