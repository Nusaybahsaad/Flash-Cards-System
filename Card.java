import java.time.LocalDateTime;

/**
 * Represents a flashcard with a question, answer, and mistake tracking
 */
public class Card {
    private String question;
    private String answer;
    private int mistakeCount;
    private LocalDateTime lastMistakeTime;
    private boolean wasIncorrectLastRound;
    
    public Card(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.mistakeCount = 0;
        this.lastMistakeTime = null;
        this.wasIncorrectLastRound = false;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public int getMistakeCount() {
        return mistakeCount;
    }
    
    public LocalDateTime getLastMistakeTime() {
        return lastMistakeTime;
    }
    
    public boolean wasIncorrectLastRound() {
        return wasIncorrectLastRound;
    }
    
    /**
     * Records a mistake for this card
     */
    public void recordMistake() {
        this.mistakeCount++;
        this.lastMistakeTime = LocalDateTime.now();
        this.wasIncorrectLastRound = true;
    }
    
    /**
     * Marks this card as answered correctly in the last round
     */
    public void recordCorrect() {
        this.wasIncorrectLastRound = false;
    }
    
    /**
     * Resets mistake tracking
     */
    public void resetMistakes() {
        this.mistakeCount = 0;
        this.lastMistakeTime = null;
        this.wasIncorrectLastRound = false;
    }
    
    @Override
    public String toString() {
        return "Q: " + question + " | A: " + answer + 
               " | Mistakes: " + mistakeCount +
               " | Incorrect last round: " + wasIncorrectLastRound;
    }
}
