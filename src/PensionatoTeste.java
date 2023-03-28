

	import java.util.Locale;
	import java.util.Scanner;

	public class PensionatoTeste {

		public static void main(String[] args) {

			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);

			System.out.println("Quantas pessoas deseja registar?");
			int n = sc.nextInt();

			while (n > 10 || n < 1) {
				System.out.println("Número inválido, escolha um valor entre 1 e 10");
				n = sc.nextInt();
			}

			Pensionato[] alugar = new Pensionato[n];

			for (int i = 0; i < alugar.length; i++) {
				System.out.println("NOME: ");
				sc.nextLine();
				String nome = sc.nextLine();

				System.out.println("EMAIL");
				String email = sc.nextLine();

				System.out.println("QUARTO");
				int quarto = sc.nextInt();
				if (quarto < 1 || quarto > 10) {
					System.out.println("Não existe um quarto referente à esse número, digite um valor válido");
					while (quarto < 1 || quarto > 10) {
						quarto = sc.nextInt();
						System.out.println("Não existe um quarto referente à esse número, digite um valor válido");
					}
				}

				alugar[i] = new Pensionato(nome, email, quarto);

			}

			int aux = 0;
			boolean controle;
			for (int i = 0; i < alugar.length; i++) {
				controle = true;
				for (int j = 0; j < (alugar.length - 1); j++) {

					if (alugar[j].getQuarto() > alugar[j + 1].getQuarto()) {
						aux = alugar[j].getQuarto();
						alugar[j].setQuarto(alugar[j + 1].getQuarto());
						alugar[j + 1].setQuarto(aux);
						controle = false;
					}
				}
				if (controle) {
					break;
				}
			}
			
			System.out.println();
			System.out.println("LISTA COMPLETA:");
			
			for (int i = 0; i < alugar.length; i++) {
				
				System.out.print(alugar[i].getQuarto() + ": ");
				System.out.println(alugar[i].toString());
			}

		}

	}
	

