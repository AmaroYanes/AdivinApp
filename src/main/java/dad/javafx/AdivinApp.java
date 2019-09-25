package dad.javafx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AdivinApp extends Application  {
	private Alert victoria,casi,error;
	private Label explicacionLabel;
	private Button checkButton;
	private TextField numeroText;
	private int intentos = 0;
	private int numeroGenerado = (int)(Math.random()*100)+1;
	public void start(Stage primaryStage) throws Exception {
		numeroText = new TextField();
		numeroText.setPromptText("1 a 100");
		numeroText.setMaxWidth(150);
		
		checkButton = new Button("Comprobar");
		checkButton.setDefaultButton(true);
		checkButton.setOnAction(e -> onComprobarButtonAction(e));
		
		explicacionLabel = new Label("Introduce un numero del 1 al 100");
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(explicacionLabel,numeroText, checkButton);
		
		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		victoria = new Alert(AlertType.INFORMATION);
		victoria.setTitle("AdivinApp");
		victoria.setHeaderText("!Has ganado¡");
		
		casi= new Alert(AlertType.WARNING);
		casi.setTitle("AdivinApp");
		casi.setHeaderText("!Has fallado¡");
		
		error = new Alert(AlertType.ERROR);
		error.setTitle("AdivinApp");
		error.setHeaderText("ERROR");
		error.setContentText("Numero no bueno");
		

	}
	
	private void onComprobarButtonAction(ActionEvent e) {
		try {
			int numero = Integer.parseInt(numeroText.getText());
			intentos++;
			if(numero > 100 || numero < 0);
			if(numero > numeroGenerado) {
				casi.setContentText("El numero es menor que "+numero);
				casi.showAndWait();

			}else if(numero < numeroGenerado){
				casi.setContentText("el numero es mayor que "+numero);
				casi.showAndWait();

			}else {
				victoria.setContentText("Solo has necesitado "+intentos+" intentos\n\nVuelve a jugar y Hazlo mejor");
				victoria.showAndWait();
				intentos = 0;
				numeroGenerado = (int)(Math.random()*100)+1;
			}
		} catch (NumberFormatException e1) {
			error.showAndWait();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
