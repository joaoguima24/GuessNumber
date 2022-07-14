package academy.mindswap;

public class Game {


    private static int maxRange;
    private static int minRange;
    private static int betterOF = 3;
    private static int nrOfPlays = 0;
    private static int computerNumber;
    private static boolean onOff = true;


    public static void setMaxRange(int maxRange) {
        if (maxRange <= 1){
            Interface.playMessage("You have to choose a range bigger than 1");
            onOff = false;
            return;
        }
        Game.maxRange = maxRange;
    }
    public static int getMaxRange() {
        return maxRange;
    }

    public static void setMinRange(int minRange) {
        if (minRange >= getMaxRange()){
            Interface.playMessage(("You have to choose a range bigger than " + getMaxRange()));
            onOff = false;
            return;
        }
        Game.minRange = minRange;
    }


    public static void playButton(){
        if (onOff == true){
            gameOn();
        } return;
    }
    public static void gameOn() {
        Player player1 = new Player("João");
        Player player2 = new Player("Guima");
        computerNumber = getRandomNumber();
        Interface.playMessage("The guessing number is: " + computerNumber);

        while(player2.getWins() < betterOF && player1.getWins() < betterOF) {
            int p1Num = getRandomNumber();
            if (guessNumber(p1Num, computerNumber)){
                player1.addWins();
                Interface.playMessage(player1.getName() + " guessed and got:" + player1.getWins() + " points.");
            }
            int p2Num = getRandomNumber();
            if (guessNumber(p2Num, computerNumber) && player2.getWins() < betterOF){
                player2.addWins();
                Interface.playMessage(player2.getName() + " guessed and got:" + player2.getWins() + " points.");
            }
        }
        Interface.playMessage("We tried: " + nrOfPlays + " numbers.");
        if (p1IsTheWinner(player1.getWins(),player2.getWins())) {
            Interface.playMessage(player1.getName() + " is the winner with: " + player1.getWins() + " wins.");
            return;
        } Interface.playMessage(player2.getName() + " is the winner with: " + player2.getWins() + " wins.");

        }

    private static boolean p1IsTheWinner (int p1wins, int p2wins){
        return p1wins > p2wins ? true : false;
    }

    private static boolean guessNumber(int pNum, int computerNum){
        Game.nrOfPlays++;
        return pNum == computerNum ? true: false;
    }

    public static int getRandomNumber(){
        return (int) Math.floor(Math.random()*(maxRange - minRange + 1)+minRange);
    }


    public static void betterOf (int betterOF) {
        if (betterOF < 1){
            onOff = false;
            Interface.playMessage("You can't choose a better of inferior to 1");
        }
        Game.betterOF = betterOF / 2 + 1;
    }


}
