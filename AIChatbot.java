import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private Map<String, String> faqDatabase;
    private Scanner scanner;

    public Main() {
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

        return "Sorry, I don't understand that. Type 'help' to see what I can answer.";
    }

    public void startChat() {
        System.out.println("AI Chatbot is now running. Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            String response = getResponse(userInput);
            System.out.println("Bot: " + response);

            if (userInput.equalsIgnoreCase("bye")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Main chatbot = new Main();
        chatbot.startChat();
    }
}
