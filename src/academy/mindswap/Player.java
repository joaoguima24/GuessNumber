package academy.mindswap;

public class Player {
    private String name;
    private int wins;

    public Player(String name){
        this.name= name;
        this.wins=0;
    }
    public String getName() {
        return this.name;
    }

    public void addWins() {
        this.wins ++;
    }

    public int getWins() {
        return wins;
    }
}
