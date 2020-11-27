package ua.edu.ucu.smartarr;


import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] oldArray = smartArray.toArray();
        ArrayList<Object> newArray = new ArrayList<>();
        for (Object el1 : oldArray) {
            boolean repeat = false;
            for (Object el2 : newArray) {
                if (el1.toString().equals(el2.toString())) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                newArray.add(el1);
            }
        }
        return newArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "return new object with each element of the previous one," +
                " but each only in 1 exemplar";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
