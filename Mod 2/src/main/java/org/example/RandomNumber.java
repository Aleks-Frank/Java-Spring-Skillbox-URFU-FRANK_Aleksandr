package org.example;

import java.util.Random;

public class RandomNumber {
    Random random = new Random();

    public int RandomNumReturn(){
        return random.nextInt(VARIANTS.values().length);
    }
}
