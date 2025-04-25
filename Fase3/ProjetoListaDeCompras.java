import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProjetoListaDeCompras extends Application {
	private ArrayList<String> listaDeCompras = new ArrayList<>();
	private ListView<String> listaVisualizavel = new ListView<>(); // Exibir os itens da lista de compras.

	@Override
	public void start(Stage palco) {
		palco.setTitle("Lista de Compras");
		
		Label labelAdicionar = new Label("Digite o item que deseja adicionar:");
		TextField textFieldDescricaoItem = new TextField();
		Button botaoAdicionar = new Button("Adicionar item");
		
		Label labelListaDeCompras = new Label("Lista de compras: ");
		Button botaoExportar = new Button("Exportar Lista");

		// Criação do objeto ObservableList a partir da lista de compras.
		ObservableList<String> observableListaDeCompras = FXCollections.observableArrayList(listaDeCompras); // Transformando a ArrayList "listaDeCompras" em uma lista observável/visualizavel.
		listaVisualizavel.setItems(observableListaDeCompras);

		VBox vBox = new VBox();
		vBox.getChildren().addAll(labelAdicionar, textFieldDescricaoItem, botaoAdicionar);
		vBox.getChildren().addAll(labelListaDeCompras, listaVisualizavel, botaoExportar);
		vBox.setSpacing(10); // Espaçamento vertical de 10 pixels entre os componentes da VBox.
		vBox.setPadding(new Insets(10)); // Espaçamento interno de 10 pixels em relação ao VBox.

		botaoAdicionar.setOnAction ( e -> {
			String item = textFieldDescricaoItem.getText(); // pega o texto digitado no textFieldDescricaoItem e armazena ele numa variável "item"
			if (!item.isEmpty()) {
				listaDeCompras.add(item); // O texto digitado é adicionado no ArrayList listaDeCompras
				listaVisualizavel.getItems().add(item); // Adicionamos o texto no ArrayList listaVisualizavel
				textFieldDescricaoItem.clear(); // Limpamos o textField para que possa ser adicionado novos valores.
			}
		});

		botaoExportar.setOnAction ( e -> {
			try {
				File arquivo = new File("listaDeCompras.txt"); // Ao selecionar o botão exportar, será criado um arquivo chamado "listaDeCompras.txt".
				PrintWriter writer = new PrintWriter(arquivo); // O PrintWriter é usado para gravar os itens da lista no arquivo.
			for (String item : listaDeCompras) {
				writer.println(item); // Escrevemos cada item da lista no arquivo, separados por quebra de linha.
			}
			writer.close();
		}catch (Exception ex) { 
			System.out.println("Erro ocorrido: " + ex.getMessage());
		}
	});

	Scene scene = new Scene(vBox, 350, 300);
	palco.setScene(scene);
	palco.show();
	}

	public static void main ( String [] args ){
		launch(args);
	}
}
