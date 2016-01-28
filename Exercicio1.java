import java.util.Scanner;

public class Exercicio1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double[] notas = new double[3];
		double media;

		for (int i = 0; i < notas.length; i++) {
			System.out.println("Digite a nota " + (i + 1) + ":");
			notas[i] = scanner.nextDouble();
		}

		media = (notas[0] + notas[1] * 2 + notas[2] * 3) / 5;

		if (media >= 7) {
			System.out.println("Aluno Aprovado!");
		} else {
			System.out.println("Aluno Reprovado!");
		}

		System.out.println("Média do aluno: " + media);
	}
}
