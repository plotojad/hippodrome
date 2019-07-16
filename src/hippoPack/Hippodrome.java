package hippoPack;

import java.util.ArrayList;

public class Hippodrome implements Runnable {
    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList <Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        Hippodrome game = new Hippodrome();
        game.getHorses().add(new Horse("FURY", 3, 0));
        game.getHorses().add(new Horse("SPEEDY", 3, 0));
        game.getHorses().add(new Horse("LOLLY", 3, 0));
        game.run();
        game.printWinner();

    }

    public void move(){
        for (Horse horse : horses){
            horse.move();
        }

    }

    public void print(){
        for (Horse horse : horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner(){
        int max = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance()>horses.get(max).getDistance()){
                max = i;
            }
        }return horses.get(max);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!!!");
    }
}
