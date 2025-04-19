import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ProjetoJogoDaForca {
	public static void main ( String [] args ){
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> palavrasSecretas = new ArrayList<>();
		palavrasSecretas.add("cobra");
		palavrasSecretas.add("urubu");
		palavrasSecretas.add("elefante");
		
		Random random = new Random();
		int tamanhoDoArrayList = palavrasSecretas.size();
		int indiceDaPalavraAleatoriaGerada = random.nextInt(tamanhoDoArrayList);
		String palavraSecreta = palavrasSecretas.get(indiceDaPalavraAleatoriaGerada); // Seleciona uma palavra secreta aleatoriamente.

		ArrayList<Character> letrasDescobertas = new ArrayList<>(); // ArrayList para armazenar as letras descobertas

		for (int i = 0; i < palavraSecreta.length(); i++) {
			letrasDescobertas.add('_'); // Inicializa com traços para cada letra
		}

		int tentativas = 6; // Número máximo de tentativas
		boolean palavraFoiDescoberta = false; // Adiciona uma flag para verificar se a palavra foi descoberta

		// Enquanto a palavraFoiDescoberta não for descoberta
		// ou ainda houver tentativas para descobrir, o programa continuará
		while(!palavraFoiDescoberta && tentativas > 0){
			System.out.println();
			System.out.println("Palavra: " + letrasDescobertas);
			System.out.print("Chute uma letra: ");
			char chute = scanner.next().charAt(0);
			
			boolean acertou = false;
			for (int i = 0; i < palavraSecreta.length(); i++) { // Passo por cada letra da palavra
				if (palavraSecreta.charAt(i) == chute) { // Verifico cada letra da palavra secreta se é igual ao chute
					letrasDescobertas.set(i, chute); // Caso for igual, aqui troca a letra na posição I pela letra do chute
					acertou = true;
				}
			}

			if (!acertou) {
				tentativas--;
				System.out.println("Você tem mais " + tentativas + " tentativas restantes");
			}
			
			// Verifica se a palavra foi completamente descoberta
			palavraFoiDescoberta = !letrasDescobertas.contains('_');
		}

		if(palavraFoiDescoberta) {
			System.out.println("Parabéns, você acertou e a palavra era: " + palavraSecreta);
		} else {
			System.out.println("Infelizmente você perdeu! a palavra correta era: " + palavraSecreta);
		}
	}
}
				