package org.example;

public class Player extends RandomNumber{
    private final VARIANTS var;
    private final String name;

    Player(VARIANTS var, String name){
        this.var = var;
        this.name = name;
    }

    Player(){
        this.var = VARIANTS.values()[RandomNumReturn()];
        this.name = "Bot";
    }

//    Player(String name){
//        this.var = VARIANTS.values()[RandomNumReturn()];
//        this.name = name;
//    }

    public String whoWins(Player one, Player two){
        if (one.var == two.var){
            return "Ничья";
        } else {
            if ((one.var.ordinal() == 0 && two.var.ordinal() == 1) || (one.var.ordinal() == 1 && two.var.ordinal() == 2) || (one.var.ordinal() == 2 && two.var.ordinal() == 0)){
                return "Победил " + two.name + " выбросив " + two.var;
            } else {
                return "Победил " + one.name + " выбросив " + one.var;
            }
        }
    }
}
