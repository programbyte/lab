import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Janela extends JFrame {
	public Janela() {
		super("Exemplo de janela");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		add(new JLabel("Teste de swing"));
		add(new JButton("Botão Teste");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Janela();
	}
}
