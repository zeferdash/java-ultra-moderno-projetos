import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.application.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ProjetoCalculadoraIMC extends Application {
	@Override
	public void start ( Stage palco ) {

		// Etiquetas para campo de entrada
		Label weightLabel = new Label("Peso: ");
		Label heightLabel = new Label("Altura: ");
		
		// Campo de texto referente as etiquetas
		TextField weightField = new TextField();
		weightField.setPromptText("Peso em KG's");
		TextField heightField = new TextField();
		heightField.setPromptText("Altura em metros");

		// Etiqueta que receberá o IMC
		Label imcResult = new Label();
		
		// Botão para calcular o IMC
		Button calculateIMC = new Button("Calcular IMC");
		// Lógica do botão para calcular o IMC ao ser pressionado
		calculateIMC.setOnAction( e -> {
			try{
				double weight = Double.parseDouble(weightField.getText().replace(',','.'));
				double height = Double.parseDouble(heightField.getText().replace(',','.'));
			
				double imc = weight / ( height * height );
			
				imcResult.setText(String.format("Seu IMC é: %.2f", imc));
			} catch	(NumberFormatException ex){
				imcResult.setText("Por favor, insira números válidos para peso e altura.");
			}
		});

		// Setando o layout como vertical ( pros elementos da cena aparecerem na vertical )
		VBox layout = new VBox(10, weightLabel, weightField, heightLabel, heightField, calculateIMC, imcResult);

		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);

		// Cena e palco
		Scene cena = new Scene(layout, 300, 250);
		palco.setTitle("Calculadora de IMC");
		palco.setScene(cena);
		palco.show();
	}

	public static void main ( String [] args ){
		launch(args);
	}
}