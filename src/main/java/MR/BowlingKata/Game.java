package MR.BowlingKata;

public class Game {
    private int score;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll (int pins){
        score += pins;
        rolls[currentRoll] = pins;
        currentRoll += 1;
    }
    
    public int score(){
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++){
            if (isStrike(frameIndex)){
                score += 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
                frameIndex += 1;
            } else if (isSpare(frameIndex)){
                score += 10 + rolls[frameIndex+2];
                frameIndex += 2;
            } else {
                score += rolls[frameIndex] + rolls[frameIndex+1];
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int frameIndex){
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isStrike(int frameIndex){
        return rolls[frameIndex] == 10;
    }
}
