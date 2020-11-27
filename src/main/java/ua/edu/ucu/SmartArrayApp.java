package ua.edu.ucu;

import java.util.ArrayList;
import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        ArrayList<Object> integersList = new ArrayList<>(Arrays.asList(integers));
        SmartArray sa = new BaseArray(integersList);


        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student student = (Student) t;
                return student.getYear() == 2 & student.getGPA() >= 4;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student student1 = (Student) o1, student2 = (Student) o2;
                String s1 = student1.getSurname(), s2 = student2.getSurname();
                int len1 = s1.length(), len2 = s2.length();
                for (int i = 0; i < Math.min(len1, len2); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return (int) s1.charAt(i) - (int) s2.charAt(i);
                    }
                }
                return len1 - len2;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student student = (Student) t;
                return student.getSurname() + " " + student.getName();
            }
        };

        ArrayList<Object> studentsList = new ArrayList<>(Arrays.asList(students));
        SmartArray sa = new BaseArray(studentsList);

        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);

        Object[] result = sa.toArray();

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
