import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.File;

import java.io.PrintWriter;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;

public class ProjetoEditorDeTextoBasico extends Application {

    @Override  
    public void start(Stage palco) {
        // Criação do TextArea para o editor de texto
        TextArea areaEditavel = new TextArea();

        // Botão para salvar o texto
        Button botaoSalvar = new Button("Salvar");
        botaoSalvar.setOnAction(e -> salvarTexto(areaEditavel));

        // Barra de ferramentas com o botão de salvar
        ToolBar barraDeFerramentas = new ToolBar(botaoSalvar);

        // Configuração do Layout principal
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(barraDeFerramentas);
        borderPane.setCenter(areaEditavel);

        // Configuração da Cena e do Palco
        Scene cena = new Scene(borderPane, 800, 600);
        palco.setTitle("Editor de texto básico");

        palco.setScene(cena);
        palco.show();

    }

    private void salvarTexto(TextArea textArea){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar arquivo de texto");
        File file = fileChooser.showSaveDialog(null);
        // Essa linha de código abaixo verificará se o campo de File não é nula.
        if (file != null){
            try (PrintWriter writer = new PrintWriter(file)){
                writer.println(textArea.getText());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[]args){
    	launch(args);
	}
}
