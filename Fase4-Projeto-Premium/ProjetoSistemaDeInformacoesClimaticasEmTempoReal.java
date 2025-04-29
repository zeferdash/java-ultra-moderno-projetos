import org.json.JSONObject;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class ProjetoSistemaDeInformacoesClimaticasEmTempoReal {
	
	public static void main ( String [] args ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome da cidade: ");
		String cidade = sc.nextLine(); // Lê a cidade que a pessoa quer buscar

		try {
			String dadosClimaticos = getDadosClimaticos(cidade); // Retorna um JSON e insere na dadosClimaticos
			
			// HTTP Status Code:400	Error Code:1006	No location found matching parameter 'q'
			if (dadosClimaticos.contains("\"code\": 1006")) { // \"code\":1006 representa "code":1006 no JSON.
				System.out.println("Localização não encontrada. Por favor, tente novamente.");
			} else {
				imprimirDadosClimaticos(dadosClimaticos);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getDadosClimaticos(String cidade) throws Exception {
		String apiKey = Files.readString( Paths.get("api-key.txt")).trim();

		String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
		String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade;
		HttpRequest request = HttpRequest.newBuilder() // Começa a construção de uma nova solicitação HTTP.
			.uri(URI.create(apiUrl)) // Cria uma URI ( Como se fosse uma identificação ) da solicitação HTTP.
			.build(); // Finaliza a construção da solicitação HTTP.

		// Criar objeto enviar solicitações HTTP e receber respostas HTTP, para acessar o site da WeatherAPI.
		HttpClient client = HttpClient.newHttpClient();
		
		// Agora vamos enviar requisições HTTP e receber respostas HTTP, comunicar com o site da WeatherAPI.
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response.body(); // Retorna os dados meteorológicos obtidos no site da API (WeatherAPI).
	}

	// Método para imprimir os dados meteorológicos de forma organizada:
	public static void imprimirDadosClimaticos(String dados) {
		// System.out.println("Dados originais (JSON) obtidos no site meteorológico" + dados);

		JSONObject dadosJson = new JSONObject(dados);
		JSONObject informacoesMeteorologicas = dadosJson.getJSONObject("current");

		// Extrai os dados da localização
		String cidade = dadosJson.getJSONObject("location").getString("name");
		String pais = dadosJson.getJSONObject("location").getString("country");

		// Extrai os dados adicionais
		String condicaoTempo = informacoesMeteorologicas.getJSONObject("condition").getString("text");
		int umidade = informacoesMeteorologicas.getInt("humidity");
		float velocidadeDoVento = informacoesMeteorologicas.getFloat("wind_kph");
		float pressaoAtmosferica = informacoesMeteorologicas.getFloat("pressure_mb");
		float sensacaoTermica = informacoesMeteorologicas.getFloat("feelslike_c");
		float temperaturaAtual = informacoesMeteorologicas.getFloat("temp_c");

		//Extrai data e hora da string retornada pela API
	 	String dataHoraString = informacoesMeteorologicas.getString("last_updated");

		// Imprime as informações atuais
		System.out.println("Informações Meteorológicas para: " + cidade + ", " + pais);
		System.out.println("Data e Hora: " + dataHoraString);
		System.out.println("Temperatura atual: " + temperaturaAtual + "ºC");
		System.out.println("Sensação Térmica: " + sensacaoTermica + "ºC");
		System.out.println("Condição do Tempo: " + condicaoTempo);
		System.out.println("Umidade: " + umidade + "%");
		System.out.println("Velocidade do Vento: " + velocidadeDoVento + "km/h");
		System.out.println("Pressão Atmosférica: " + pressaoAtmosferica + "mb");
	}
}