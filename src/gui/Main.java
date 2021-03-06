package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import povoadorSQL.exception.NumeroInvalidoException;
import povoadorSQL.povoamento.Povoamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblSaidas;
	private JTextField txtNumSaidas;
	private JTextArea taEntrada;
	private JTextArea taSaida;
	private Ajuda frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Povoador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaTabela = new JLabel("Nome da Tabela");
		lblNomeDaTabela.setBounds(10, 8, 95, 20);
		contentPane.add(lblNomeDaTabela);
		
		txtNome = new JTextField();
		txtNome.setBounds(115, 8, 249, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblSaidas = new JLabel("Sa\u00EDdas");
		lblSaidas.setBounds(374, 8, 40, 20);
		contentPane.add(lblSaidas);
		
		txtNumSaidas = new JTextField();
		txtNumSaidas.setBounds(424, 8, 60, 20);
		contentPane.add(txtNumSaidas);
		txtNumSaidas.setColumns(10);
		
		JScrollPane spEntrada = new JScrollPane();
		spEntrada.setBounds(10, 39, 240, 321);
		contentPane.add(spEntrada);
		
		taEntrada = new JTextArea();
		taEntrada.setTabSize(1);
		spEntrada.setViewportView(taEntrada);
		
		JScrollPane spSaida = new JScrollPane();
		spSaida.setBounds(260, 39, 424, 321);
		contentPane.add(spSaida);
		
		taSaida = new JTextArea();
		taSaida.setTabSize(2);
		taSaida.setEditable(false);
		spSaida.setViewportView(taSaida);
		
		JButton btnPovoar = new JButton("Povoar");
		btnPovoar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				povoar();
			}
		});
		btnPovoar.setBounds(494, 7, 90, 23);
		contentPane.add(btnPovoar);
		
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ajuda();
			}
		});
		btnAjuda.setBounds(594, 7, 90, 23);
		contentPane.add(btnAjuda);
	}
	
	private void povoar() {
		try {
			String[] colunas = taEntrada.getText().split("\n");
			Povoamento povoador = new Povoamento(txtNome.getText(), colunas);
			int saidas;
			try {
				saidas = Integer.parseInt(txtNumSaidas.getText());
			} catch (NumberFormatException e) {
				throw new NumeroInvalidoException(txtNumSaidas.getText(), lblSaidas);
			}
			taSaida.setText(povoador.povoar(saidas));
		} catch (Exception e) {
			erro(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void ajuda() {
		frame = new Ajuda();
		frame.setVisible(true);
	}
	
	private void erro(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
}
