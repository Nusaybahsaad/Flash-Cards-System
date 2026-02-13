import java.util.List;

/**
 * Interface for organizing/sorting flashcards
 */
public interface CardOrganizer {
    /**
     * Organizes a list of cards according to the implementation's strategy
     * @param cards the list of cards to organize
     * @return a new organized list of cards
     */
    List<Card> organize(List<Card> cards);
    
}
