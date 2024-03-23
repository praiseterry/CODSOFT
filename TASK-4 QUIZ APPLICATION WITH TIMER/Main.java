import java.util.*;

class Question {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your choice (1-" + options.size() + "): ");
            int choice = scanner.nextInt();

            if (choice == question.getCorrectOptionIndex() + 1) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Quiz ended. Your score is: " + score + "/" + questions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                Arrays.asList("London", "Paris", "Berlin", "Madrid"), 1));
        questions.add(new Question("What is the largest planet in our solar system?",
                Arrays.asList("Jupiter", "Saturn", "Mars", "Earth"), 0));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?",
                Arrays.asList("William Shakespeare", "Charles Dickens", "Mark Twain", "Jane Austen"), 0));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
