import myrpg.units.IUnit;
import myrpg.units.Unit;
import myrpg.units.classes.Archer;
import myrpg.units.classes.IClass;
import myrpg.units.classes.Warrior;
import myrpg.races.Human;
import myrpg.races.IRace;
import myrpg.races.Undead;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program{

    public static void main(String[] args) {
        int[] array = new int[] {1,2,4,56,7,3,6,1,0,-23,-2,1,5};

        int minValue = 100;

        Stream stream = Arrays
                .stream(array)
                .mapToObj(num -> num + "_str");

        Object[] arr = stream.toArray();

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }


//        ArrayList<Integer> intArr = new ArrayList<>();
//
//        for (int i = 0; i < array.length; i++){
//            if (array[i] > 3) {
//                intArr.add(array[i]);
//            }
//            if (intArr.size() > 2) {
//                break;
//            }
//        }
//
//        for (int i = 0; i < intArr.size(); i++){
//            System.out.println(intArr.get(i));
//        }
    }

    public static class MyPredicate implements IntPredicate {
        @Override
        public boolean test(int value) {
            return value > 3;
        }
    }
}
