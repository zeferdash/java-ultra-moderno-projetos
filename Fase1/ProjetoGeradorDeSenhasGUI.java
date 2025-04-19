import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class ProjetoGeradorDeSenhasGUI extends Application {
	@Override
	public void start ( Stage palco ) {
		
		palco.setTitle("Gerador de senhas");
		Label labelTamanhoSenha = new Label("Tamanho da senha:");
		TextField campoTamanhoSenha = new TextField();
		campoTamanhoSenha.setText("8"); // Sugestão de tamanho de senha

		Label labelSenhaGerada = new Label("Senha gerada:");
		TextField campoSenhaGerada = new TextField();
		campoSenhaGerada.setStyle("-fx-text-fill: cyan; -fx-background-color: black;");
		campoSenhaGerada.setEditable(false);
		
		Button botaoGerar = new Button("Gerar senha");
		botaoGerar.setOnAction( e -> {
			int tamanhoSenha = Integer.parseInt(campoTamanhoSenha.getText()); // Pego o tamanho desejado
			String senha = ProjetoGeradorDeSenhas.gerarSenha(tamanhoSenha); // Gero a senha
			campoSenhaGerada.setText(senha); // Mostro a senha gerada
		});
		
		VBox vBox = new VBox(labelTamanhoSenha, campoTamanhoSenha, botaoGerar, labelSenhaGerada, campoSenhaGerada);
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(10));
		Scene cena = new Scene(vBox, 250, 200);
		palco.setScene(cena);
		palco.show();
	}
	public static void main ( String [] args ){
		launch(args);
	}
}

/* Melhorias opcionais:
campoSenha.setStyle("-fx-text-fill: cyan; -fx-background-color: black;");
vBox.setSpacing(10); // Configura espaçamento entre os componentes
vBox.setPadding(new Insets(10)); // Adiciona um espaçamento de 10 pixels em todas as bordas
*/

// Não esquecer do import
// import javafx.geometry.Insets;