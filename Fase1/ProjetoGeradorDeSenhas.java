import java.security.SecureRandom;
import java.util.Scanner;

public class ProjetoGeradorDeSenhas {
	private static final String CARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*()-=+";

	public static String gerarSenha(int comprimento) {
		SecureRandom geradorDeNumeroAleatorio = new SecureRandom();
		StringBuilder senha = new StringBuilder(comprimento);

		for (int i = 0; i < comprimento ; i++){
			int indice = geradorDeNumeroAleatorio.nextInt(CARACTERES.length());
			senha.append(CARACTERES.charAt(indice));
		}

		return senha.toString();
	}
	
	public static void main ( String [] args ){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o comprimento da senha que deseja: ");
		int comprimentoSenha = scanner.nextInt();

		String senha = gerarSenha(comprimentoSenha);
		System.out.println("Senha gerada: " + senha);
	}
}

/*
-- Melhoria para uso e testes, implementação da classe Scanner --
Para facilitar os testes e uso via terminal.

Scanner scanner = new Scanner(System.in); // Cria um Scanner para ler do teclado
System.out.println("Digite o comprimento da senha que deseja: ");
int comprimentoSenha = scanner.nextInt(); // Le o comprimento da senha digitada
*/