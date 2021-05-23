package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataHelpers {
    public static <T> T getRandomRowOfList(ArrayList<T> list) {
        Random rand = new Random();
        int sizeOflist = list.size();
        int randomRow = rand.nextInt(sizeOflist);
        return list.get(randomRow);
    }

    public static <T> T getRandomRowOfList(List<T> list) {
        Random rand = new Random();
        int sizeOflist = list.size();
        int randomRow = rand.nextInt(sizeOflist);
        return list.get(randomRow);
    }

    public static <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
        Random rand = new Random();
        int x = rand.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static  <T> List<T> getRandomListOfElement(List<T> list,
                                                      int totalItems)
    {
        Random rand = new Random();
        List<T> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(list.size());
            newList.add(list.get(randomIndex));
            list.remove(randomIndex);
        }
        return newList;
    }
}
