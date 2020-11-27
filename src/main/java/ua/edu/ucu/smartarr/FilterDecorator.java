package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate myPredicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.myPredicate = myPredicate;
    }

    @Override
    public Object[] toArray() {
        Object[] oldArray = smartArray.toArray();
        ArrayList<Object> newArray = new ArrayList<>();
        for (Object el1 : oldArray) {
            if (myPredicate.test(el1)) {
                newArray.add(el1);
            }
        }
        return newArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "return new object with elements ofr which predicat is true";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
