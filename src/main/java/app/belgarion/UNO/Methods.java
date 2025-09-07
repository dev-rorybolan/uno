package app.belgarion.UNO;

import java.util.Random;

public class Methods {
    public static <T extends Enum<?>> T randomEnum(Class<T> clas){
        Random random = new Random();
        int x = random.nextInt(clas.getEnumConstants().length);
        return clas.getEnumConstants()[x];
    }
}
