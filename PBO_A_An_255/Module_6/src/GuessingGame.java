import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class GuessingGame extends Application {

    private Random random = new Random();
    private int randomNumber;
    private int attempts;

    private Label feedbackLabel;
    private Label attemptsLabel;
    private TextField guessInput;
    private Button guessButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Guessing Game");

        // Initialize UI elements
        guessInput = new TextField();
        guessInput.setPromptText("Enter your guess (1-100)");
        guessInput.setMaxWidth(150);

        guessButton = new Button("Try Guessing!");
        feedbackLabel = new Label("Good luck!");
        attemptsLabel = new Label("Attempts: 0");

        // Initialize game
        generateNewNumber();

        // Event handler for the button
        guessButton.setOnAction(event -> handleGuess());
        guessInput.setOnAction(event -> handleGuess()); // Allow pressing Enter in TextField

        // Layouts
        HBox inputBox = new HBox(10, new Label("Your Guess:"), guessInput);
        inputBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20); // Spacing between elements
        root.setPadding(new Insets(20)); // Padding around the VBox
        root.setAlignment(Pos.CENTER); // Center elements in VBox
        root.getChildren().addAll(inputBox, guessButton, feedbackLabel, attemptsLabel);

        Scene scene = new Scene(root, 350, 250); // Adjusted scene size
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateNewNumber() {
        randomNumber = random.nextInt(100) + 1; // Generates a number between 1 and 100
        attempts = 0;
        feedbackLabel.setText("New game started! Guess a number.");
        attemptsLabel.setText("Attempts: " + attempts);
        guessButton.setText("Try Guessing!");
        guessInput.clear();
        guessInput.setDisable(false); // Enable input for new game
    }

    private void handleGuess() {
        if (guessButton.getText().equals("Play Again")) {
            generateNewNumber();
            return;
        }

        String guessText = guessInput.getText();
        int guess;

        try {
            guess = Integer.parseInt(guessText);
            if (guess < 1 || guess > 100) {
                feedbackLabel.setText("Please enter a number between 1 and 100.");
                guessInput.selectAll();
                guessInput.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Invalid input. Please enter a number.");
            guessInput.selectAll();
            guessInput.requestFocus();
            return;
        }

        attempts++;
        attemptsLabel.setText("Attempts: " + attempts);

        if (guess == randomNumber) {
            feedbackLabel.setText("Guess correct! 🎉");
            guessButton.setText("Play Again");
            guessInput.setDisable(true); // Disable input until "Play Again" is clicked
        } else if (guess < randomNumber) {
            feedbackLabel.setText("Too small!");
        } else {
            feedbackLabel.setText("Too big!");
        }
        guessInput.selectAll();
        guessInput.requestFocus();
    }
}