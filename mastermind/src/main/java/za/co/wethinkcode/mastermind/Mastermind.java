package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public void runGame(){

        int turns = 12;
        Player player = this.player;

        System.out.println("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.");

        while(true){
            int perfectDigitAndPosition = 0;
            int correctDigitOnly = 0;
            turns--;
            String userInput = player.getGuess();

            for(int i = 0;i < 4;i++){
                if (userInput.charAt(i) == code.charAt(i)){
                    perfectDigitAndPosition++;
                }
                else if(userInput.contains(String.valueOf(code.charAt(i)))){
                    correctDigitOnly++;
                }
            }
            System.out.println("Number of correct digits in correct place: " + perfectDigitAndPosition);
            System.out.println("Number of correct digits not in correct place: " + correctDigitOnly);

             if (userInput.equals("quit") || userInput.equals("exit")) {
                 break;
             }
            else if (perfectDigitAndPosition == 4){
                System.out.println("Congratulations! You are a codebreaker!");
                System.out.println("The code was: " + code);
                break;
            }
            else if (turns >= 1){
                System.out.println("Turns left: " + turns);
            }
            else {
                System.out.println("No more turns left.");
                System.out.println("The code was: " + code);
                break;
            }
        }

    }

    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}