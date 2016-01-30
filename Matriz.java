import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Matriz extends JFrame implements ActionListener {
	MatrizQuadradaModel matrizModel;
	JPanel panelMatriz;
	int ordem;
	
	public Matriz() {
		super("Matriz Quadrada");
		matrizModel = new MatrizQuadradaModel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setSize(600, 400);
		createGUI();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void createGUI() {
		JPanel panel = new JPanel();
		panelMatriz = getPanelMatriz();
		JButton btnTranspor = new JButton("Transpor");
		btnTranspor.addActionListener(this);
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(panelMatriz)
				.addComponent(btnTranspor)
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(panelMatriz)
				.addComponent(btnTranspor)
		);
		add(panel);
	}
	public float[][] getMatriz(JPanel panelMatriz) {
		Component[] componentes = panelMatriz.getComponents();
		int ordem = (int) Math.sqrt(componentes.length);
		float[][] matriz = new float[ordem][ordem];
		int posicaoAtual = 0;
		for (int i = 0; i < ordem; i++) {
			for (int j = 0; j < ordem; j++) {
				JTextField textField = (JTextField) componentes[posicaoAtual];
				matriz[i][j] = Float.parseFloat(textField.getText());
				posicaoAtual++;
			}
		}
		return matriz;
	}
	public void setPanelMatriz(float[][] matriz, JPanel panelMatriz) {
		Component[] componentes = panelMatriz.getComponents();
		int ordem = (int) Math.sqrt(componentes.length);
		int posicaoAtual = 0;
		for (int i = 0; i < ordem; i++) {
			for (int j = 0; j < ordem; j++) {
				JTextField textField = (JTextField) componentes[posicaoAtual];
				float fTemp = matriz[i][j];
				int iTemp = (int) matriz[i][j];
				if ((fTemp - iTemp) == 0.0) {
					textField.setText(Integer.toString((int) matriz[i][j]));					
				} else {
					textField.setText(Float.toString(matriz[i][j]));
				}
				posicaoAtual++;
			}
		}	
	}
	public JPanel getPanelMatriz() {
		JPanel panel = new JPanel();
		int ordem = Integer.parseInt(JOptionPane.showInputDialog(this, "Numero de ordem:", "Matriz Quadrada", JOptionPane.PLAIN_MESSAGE));
		this.ordem = ordem;
		GridLayout layout = new GridLayout(ordem, ordem);
		panel.setLayout(layout);
		for (int i = 0; i < (ordem * ordem); i++) {
			JTextField textField = new JTextField(3);
			textField.setFont(new Font("Arial", Font.PLAIN, 40));
			textField.setHorizontalAlignment(JTextField.CENTER);
			panel.add(textField);
		}
		return panel;
	}
	public void transporMatriz() {
		float[][] matriz = getMatriz(panelMatriz);
		float[][] matrizTransposta = matrizModel.getTransposta(matriz);
		setPanelMatriz(matrizTransposta, panelMatriz);
	}
	public void actionPerformed(ActionEvent e) {
		transporMatriz();
	}
	public static void main(String[] args) {
		new Matriz();
	}
}
class MatrizQuadradaModel {
	public float[][] getTransposta(float[][] matriz) {
		int nLinhas = matriz.length;
		int nColunas = matriz[0].length;
		float[][] matrizTransposta = matriz;
		float[][] controleTroca = new float[nLinhas][nColunas];
		float nTemp;
		for (int i = 0; i < nLinhas; i++) {
			for (int j = 0; j < nColunas; j++) {
				if (controleTroca[i][j] == 1 || controleTroca[j][i] == 1) {
					continue;
				}
				nTemp = matrizTransposta[i][j];
				matrizTransposta[i][j] = matrizTransposta[j][i];
				matrizTransposta[j][i] = nTemp;
				controleTroca[i][j] = 1;
			}
		}
		return matrizTransposta;
	}
	public int getOrdem(float[][] matriz) {
		return matriz[0].length;
	}
	public int getLinhas(float[][] matriz) {
		return matriz.length;
	}
	public int getColunas(float[][] matriz) {
		return matriz[0].length;
	}
	public float getDeterminante2(float[][] matriz2) {
		float determinante2 = (matriz2[0][0] * matriz2[1][1]) - (matriz2[0][1] * matriz2[1][0]);
		return determinante2;
	}
	public float[][] getMenorComplementar(float[][] matriz) {
		int ordem = getOrdem(matriz);
		int novaOrdem = ordem - 1;
		int[][] menorComplementar = new int[novaOrdem][novaOrdem];
		return null;
	}
	public float getDeterminante(float[][] matriz) {
		float determinante = 0.0f;
		if (getOrdem(matriz) != 2) {
			for (int i = 0; i < getOrdem(matriz); i++) {
				 
			}
		} else {
			determinante = getDeterminante2(matriz);			
		}
		return determinante;
	}
}
