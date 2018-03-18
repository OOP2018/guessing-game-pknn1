import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

import java.util.Observable;
import java.util.Observer;

public class GuessingUIController implements Observer {

    @FXML
    private FlowPane supervisor;

    @FXML
    private MenuItem randomButton;

    @FXML
    private MenuItem guideButton;

    @FXML
    private Button guessButton;

    @FXML
    private Label result;

    @FXML
    private Label tryFrom;

    @FXML
    private Label tryTo;

    @FXML
    private TextField to;

    @FXML
    private TextField inputField;

    private NumberGame game;

    private boolean isUpperBoundConfirmed;

    private int guessNumber = 0;
    private int upperBound;
    private int lowerBound = 1;

    @FXML
    void initialize() {
        supervisor.setVisible(false);
        isUpperBoundConfirmed = false;
        Platform.runLater(() -> to.requestFocus());
        inputField.setDisable(true);
        guideButton.setDisable(true);
        randomButton.setDisable(true);

        keyHandler();

        guessButton.setDisable(true);
        guessButton.setText("Confirm");

        result.setText("Please set upper bound above");
    }

    @FXML
    void buttonHandler(ActionEvent event) {
        if (!isUpperBoundConfirmed) {
            start();
            upperBound = game.getUpperBound();
            return;
        }

        if (event.getSource().equals(guessButton)) {
            guessNumber = Integer.valueOf(inputField.getText());
            if (game.guess(guessNumber)) {
                guessButton.setDisable(true);
                showWinningDialog(true);
            } else {
                result.setText(game.getMessage());
            }
        } else {
            showWinningDialog(false);
        }
    }

    @FXML
    void menuHandler(ActionEvent event) {
        if (event.getSource().equals(guideButton)) {
            System.out.println("AA");
            supervisor.setVisible(true);
            game.addObserver(this);
        }
    }

    private void showWinningDialog(boolean isWon) {
        Alert alert;
        if (isWon) {
            alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to play again?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("Congratulation!!");
            alert.setTitle("You've Won!!");
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION, "Test your luck again?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("Don't you dare buy lottery.");
            alert.setTitle("Maybe next time!!");
        }
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            restart();
        } else {
            Platform.exit();
        }
    }

    private void start() {
        isUpperBoundConfirmed = true;
        to.setDisable(true);
        guessButton.setText("GUESS");
        result.setText("Start!!");
        inputField.setDisable(false);
        guideButton.setDisable(false);
        randomButton.setDisable(false);
    }

    private void restart() {
        lowerBound = 1;
        to.setText("");
        inputField.setText("");
        to.setDisable(false);
        initialize();
    }

    private void keyHandler() {
        to.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (to.getLength() == 0 || !to.getText().matches("^[\\d]+$") || Integer.valueOf(to.getText()) <= 1) {
                    guessButton.setDisable(true);
                } else {
                    game = new PakanonGame(Integer.valueOf(to.getText()));
                    guessButton.setDisable(false);
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        to.removeEventHandler(KeyEvent.KEY_RELEASED, this);
                        guessButton.fire();
                    }
                }

            }
        });

        inputField.setOnKeyReleased(event -> {
            if (inputField.getLength() == 0 || !inputField.getText().matches("^[\\d]+$")) {
                guessButton.setDisable(true);
            } else {
                guessButton.setDisable(false);
            }
        });
    }

    private void updateGuide() {
        if (result.getText().contains("large")) {
            upperBound = guessNumber - 15;
        } else if (result.getText().contains("small")) {
            lowerBound = guessNumber + 15;
        }

        int guide = (upperBound - lowerBound) / 2 + lowerBound;
        tryFrom.setText(String.valueOf(guide - 5));
        tryTo.setText(String.valueOf(guide + 5));
    }

    @Override
    public void update(Observable o, Object arg) {
        updateGuide();
    }
}
