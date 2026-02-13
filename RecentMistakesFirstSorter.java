import java.util.ArrayList;
import java.util.List;

/**
 * A CardOrganizer that places cards answered incorrectly in the last round first.
 * Uses stable sorting: maintains relative order of cards within each group
 * (incorrect vs correct).
 */
public class RecentMistakesFirstSorter implements CardOrganizer {
    
    /**
     * Organizes cards so that those answered incorrectly in the last round appear first.
     * Maintains stable ordering: relative positions of cards within the same group
     * (both incorrect or both correct) are preserved.
     * 
     * @param cards the list of cards to organize
     * @return a new list with incorrect cards first, followed by correct cards
     */
    @Override
    public List<Card> organize(List<Card> cards) {
        List<Card> result = new ArrayList<>();
        
        // First pass: add all cards that were incorrect in the last round
        // This preserves their relative order from the original list
        for (Card card : cards) {
            if (card.wasIncorrectLastRound()) {
                result.add(card);
            }
        }
        
        // Second pass: add all cards that were correct in the last round
        // This also preserves their relative order from the original list
        for (Card card : cards) {
            if (!card.wasIncorrectLastRound()) {
                result.add(card);
            }
        }
        
        return result;
    }
}
