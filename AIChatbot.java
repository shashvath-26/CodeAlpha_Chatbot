import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbot {
    
    private Map<String, String> faqDatabase;
    private Scanner scanner;
    
    public AIChatbot() {
        scanner = new Scanner(System.in);
        faqDatabase = new HashMap<>();
        initializeFAQs();
    }
    
    private void initializeFAQs() {
        faqDatabase.put("hello", "Hello! Welcome to the CodeAlpha AI Chatbot. How can I help you today?");
        faqDatabase.put("hi", "Hi there! I'm your AI assistant. What would you like to know?");
        faqDatabase.put("how are you", "I'm doing great, thank you for asking! How about you?");
        faqDatabase.put("what is java", "Java is a high-level, object-oriented programming language known for its portability across platforms.");
        faqDatabase.put("what is oop", "OOP stands for Object-Oriented Programming. It's a programming paradigm based on objects containing data and methods.");
        faqDatabase.put("what is internship", "An internship is a period of work experience offered by an organization for a limited time, usually to students or trainees.");
        faqDatabase.put("what is codealpha", "CodeAlpha is a platform that provides internship opportunities and training in various tech domains including Java, Web Development, and more.");
        faqDatabase.put("help", "I can help you with FAQs about Java, OOP, Internships, CodeAlpha, and more. Just type your question!");
        faqDatabase.put("bye", "Goodbye! Have a great day ahead! Come back anytime.");
    }
    
    public String getResponse(String userInput) {
        String input = userInput.toLowerCase().trim();
        
        if (faqDatabase.containsKey(input)) {
            return faqDatabase.get(input);
        }
        
        for (String key : faqDatabase.keySet()) {
            if (input.contains(key)) {
                return faqDatabase.get(key);
            }
        }
        
        return "I'm not sure about that. Try asking about Java, OOP, Internships, CodeAlpha, or type 'help' for assistance.";
    }
    
    public void startChat() {
        System.out.println("=================================");
        System.out.println("   Welcome to AI Chatbot!   ");
        System.out.println("=================================");
        System.out.println("Type your message (or 'bye' to exit):");
        System.out.println();
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("bye") || userInput.equalsIgnoreCase("exit")) {
                System.out.println("Bot: " + getResponse("bye"));
                break;
            }
            
            String response = getResponse(userInput);
            System.out.println("Bot: " + response);
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        AIChatbot chatbot = new AIChatbot();
        chatbot.startChat();
    }
}
