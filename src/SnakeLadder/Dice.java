package SnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public int min = 1;
    public int max = 6;

    public int rollDice(){
        return ThreadLocalRandom.current().nextInt(min,max+1);
    }
}
