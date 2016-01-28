import javax.swing.JFrame;

public class Janela extends JFrame {
	public Janela() {
		super("Exemplo de janela");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Janela();
	}
}
