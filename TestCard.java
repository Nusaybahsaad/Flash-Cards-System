import java.util.ArrayList;
import java.util.List;

public class TestCard {
    public static void main(String[] args) {
        // Create a list of flashcards
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("What come first design or code?", "design"));
        cards.add(new Card("Protecting data by restricting access?", "Encapsulation"));
        cards.add(new Card("Same method, different behaviors?", "Polymorphism"));
        cards.add(new Card("Hiding details and showing essentials?", "Abstraction"));
        cards.add(new Card("Redefining a parent class method in a child class?", "Overriding"));
        
        System.out.println("ORIGINAL ORDER OF CARDS:");
        printCards(cards);
      
        cards.get(1).recordMistake();  
        cards.get(3).recordMistake();  
        
        // Mark others as correct
        cards.get(0).recordCorrect();  
        cards.get(2).recordCorrect();  
        cards.get(4).recordCorrect();  
        
        System.out.println("\n AFTER MARKING MISTAKES ");
        printCards(cards);
        
        // Use the RecentMistakesFirstSorter to reorganize
        CardOrganizer organizer = new RecentMistakesFirstSorter();
        List<Card> organizedCards = organizer.organize(cards);
        
        System.out.println("\n AFTER ORGANIZING (Mistakes First) ");
        printCards(organizedCards);
        
        List<Card> allCorrectOrganized = organizer.organize(cards);
        System.out.println("\n Original order preserved when no mistakes:");
        printCards(allCorrectOrganized);
    }
    
    private static void printCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.println(i + ". " + card);
        }
    }
}
