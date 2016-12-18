package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ajuda extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextArea txtrAjuda;
	public String[] ajuda = {
		"------ SOBRE ------\n"
		+ "\n"
		+ "Este programa é um gerador de povoamentos para modelos relacionais implementados em Oracle SQL+.",
		"------ COMO USAR ------\n"
		+ "\n"
		+ "*No campo \"Nome da Tabela\", insira o nome da tabela e em \"Saídas\" insira a quantidade de inserções (inserções > 0) que deseja"
		+ " gerar.\n\n"
		+ "*No espaço da esquerda, digite os nomes dos atributos e seus tipos, separados por espaço (' '). Cada atributo e tipo devem estar em sua"
		+ " própria linha. Assim como o SQL+, o programa não é case-sensitive. No caso de chaves para outras tabelas, use o tipo da chave da tabela\n\n"
		+ "*Por fim, clique em \"Povoar\". O povoamento gerado aparecerá no espaço da direita.",
		"------ TIPOS DE ENTRADA ------\n"
		+ "\n"
		+ "*CEP: Gera um CEP no formato 'xxxxx-xxx'\n\n"
		+ "*CELULAR: Gera um número de celular no formato '9xxxxxxxx'\n\n"
		+ "*CELULAR_DDD: Gera um número de celular no formato 'xx9xxxxxxxx'\n\n"
		+ "*CELULAR_FORMATADO: Gera um número de celular no formato '9xxxx-xxxx'\n\n"
		+ "*CELULAR_FORMATADO_DDD: Gera um número de celular no formato '(xx)9xxxx-xxxx'\n\n"
		+ "*CHAVE_INT: Gera um valor que começa em 0 e é incrementado em cada inserção gerada. Deve ser usado para gerar as chaves caso a tabela use"
		+ " uma chave inteira\n\n"
		+ "*CHAVE_STRING: Gera um valor que começa em '0' e é incrementado em cada inserção gerada. Deve ser usado para gerar as chaves caso a"
		+ " tabela use uma chave texto\n\n"
		+ "*CPF: Gera um CPF no formato 'xxxxxxxxxxx'\n\n"
		+ "*CPF_FORMATADO: Gera um CPF no formato 'xxx.xxx.xxx-xx'\n\n"
		+ "*EMAIL: Retorna um email com uma sequencia de letras e uma terminação aleatórias. Se for usado após NOME, usará as iniciais do nome"
		+ " gerado.\n\n"
		+ "*IDADE_ADOLESCENTE: Gera uma idade inteira de 13 a 17\n\n"
		+ "*IDADE_ADULTO: Gera uma idade de 18 a 64\n\n"
		+ "*IDADE_CRIANCA: Gera uma idade de 0 a 12\n\n"
		+ "*IDADE_MENOR: Gera uma idade de 0 a 17\n\n"
		+ "*INT(min, max): Gera um valor inteiro de min a max\n\n"
		+ "*NOME: Gera um nome com 1 ou 2 nomes e 1 ou 2 sobrenomes sorteados aleatoriamente.\n\n"
		+ "*PAIS: Retorna um país sorteado aleatoriamente\n\n"
		+ "*PROFISSAO: Retorna uma profissão sorteada aleatoriamente\n\n"
		+ "*SEXO: Retorna 'M' (masculino) ou 'F' (feminino). Caso NOME e SEXO sejam ambos usados, o programa gera nomes e sexos compatíveis."};

	/**
	 * Create the frame.
	 */
	public Ajuda() {
		setTitle("Ajuda");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				atualizaTexto();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sobre", "Como usar", "Tipos de entrada"}));
		comboBox.setBounds(10, 11, 424, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 424, 218);
		contentPane.add(scrollPane);
		
		txtrAjuda = new JTextArea();
		txtrAjuda.setEditable(false);
		txtrAjuda.setText(ajuda[0]);
		txtrAjuda.setWrapStyleWord(true);
		txtrAjuda.setLineWrap(true);
		scrollPane.setViewportView(txtrAjuda);
	}
	
	void atualizaTexto() {
		txtrAjuda.setText(ajuda[comboBox.getSelectedIndex()]);
	}
}
