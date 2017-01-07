package gui;

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
		+ "*No campo \"Nome da Tabela\", insira o nome da tabela (nome != \"\") e em \"Saídas\" insira a quantidade de inserções (inserções > 0)"
		+ " que deseja gerar.\n\n"
		+ "*No espaço da esquerda, digite os nomes dos atributos e seus tipos, separados por espaço (' '). Cada atributo e tipo devem estar em sua"
		+ " própria linha. Assim como o SQL+, o programa não é case-sensitive. No caso de chaves para outras tabelas, use o tipo da chave da"
		+ " tabela.\n\n"
		+ "*Por fim, clique em \"Povoar\". O povoamento gerado aparecerá no espaço da direita, automaticamente identado.",
		"------ POVOAMENTO OBJETO-RELACIONAL ------\n"
		+ "*Para gerar um povoamento objeto-relacional, basta usar o comando TIPO em alguma parte no espaço da esquerda.\n\n"
		+ "*A sintaxe é nome_do_tipo TIPO(numero_de parametros)\n\n"
		+ "Ex. (1 saída):\n"
		+ "Entrada:\n"
		+ "tp_teste TIPO(2)\n"
		+ "	cep CEP\n"
		+ "	tp_pessoa TIPO(2)\n"
		+ "		cpf CPF\n"
		+ "		nome NOME\n\n"
		+ "Saída:\n"
		+ "INSERT INTO teste VALUES (\n"
		+ "	tp_teste(\n"
		+ "		'67986-971',\n"
		+ "		tp_pessoa(\n"
		+ "			'590108591',\n"
		+ "			'Natália Ana Isgária'\n"
		+ "		)\n"
		+ "	)\n"
		+ ");\n\n"
		+ "Obs.: A identação é sempre opcional.",
		"------ TIPOS DE ENTRADA ------\n"
		+ "\n"
		+ "*CEP: Gera um CEP no formato 'xxxxx-xxx'.\n\n"
		+ "*CELULAR: Gera um número de celular no formato '9xxxxxxxx'.\n\n"
		+ "*CELULAR_DDD: Gera um número de celular no formato 'xx9xxxxxxxx'.\n\n"
		+ "*CELULAR_FORMATADO: Gera um número de celular no formato '9xxxx-xxxx'.\n\n"
		+ "*CELULAR_FORMATADO_DDD: Gera um número de celular no formato '(xx)9xxxx-xxxx'.\n\n"
		+ "*CHAVE_INT: Gera um valor que começa em 0 e é incrementado em cada inserção gerada. Deve ser usado para gerar as chaves caso a tabela"
		+ " use uma chave inteira.\n\n"
		+ "*CHAVE_STRING: Gera um valor que começa em '0' e é incrementado em cada inserção gerada. Deve ser usado para gerar as chaves caso a"
		+ " tabela use uma chave texto.\n\n"
		+ "*CPF: Gera um CPF no formato 'xxxxxxxxxxx'.\n\n"
		+ "*CPF_FORMATADO: Gera um CPF no formato 'xxx.xxx.xxx-xx'.\n\n"
		+ "*DATA(min, max): Gera uma data entre a data em min e a data em max. Ambos min e max devem ser inseridos na forma DD/MM/AAAA.\n\n"
		+ "*DECIMAL(antesPonto, depoisPonto): Gera um número decimal com um número de algarismos a esquerda menor ou igual a antesPonto e um número"
		+ " de algarismos a direita igual ao valor em depoisPonto.\n\n"
		+ "*EMAIL: Retorna um email com uma sequencia de letras e uma terminação aleatórias. Se for usado após NOME, usará as iniciais do nome"
		+ " gerado anteriormente.\n\n"
		+ "*IDADE_ADOLESCENTE: Gera uma idade inteira de 13 a 17.\n\n"
		+ "*IDADE_ADULTO: Gera uma idade de 18 a 64.\n\n"
		+ "*IDADE_CRIANCA: Gera uma idade de 0 a 12.\n\n"
		+ "*IDADE_MENOR: Gera uma idade de 0 a 17.\n\n"
		+ "*INT(min, max): Gera um valor inteiro de min a max.\n\n"
		+ "*NOME: Gera um nome com 1 ou 2 nomes e 1 ou 2 sobrenomes sorteados aleatoriamente. Se for usado após EMAIL, retornará um nome cujas"
		+ " iniciais serão iguais ao email gerado anteriormente.\n\n"
		+ "*PAIS: Retorna um país sorteado aleatoriamente.\n\n"
		+ "*PROFISSAO: Retorna uma profissão sorteada aleatoriamente.\n\n"
		+ "*SEXO: Retorna 'M' (masculino) ou 'F' (feminino). Caso NOME e SEXO sejam ambos usados, o programa gera nomes e sexos compatíveis.",
		"------ ESCOLHENDO SUAS PRÓPRIAS ENTRADAS ------\n"
		+ "\n"
		+ "É possível usar seu próprio conjunto de entradas no povoador. Para isso, no lugar do tipo, use chaves ({, }), e coloque as entradas"
		+ " dentro, separadas por vírgula.\n\n"
		+ "Ex. (3 saídas):\n"
		+ "Entrada:\n"
		+ "fruta {'Abacaxi', 'Banana', 'Melancia'}\n\n"
		+ "Saída:\n"
		+ "INSERT INTO teste (fruta) VALUES (\n"
		+ "	'Melancia'\n"
		+ ");\n"
		+ "INSERT INTO teste (fruta) VALUES (\n"
		+ "	'Abacaxi'\n"
		+ ");\n"
		+ "INSERT INTO teste (fruta) VALUES (\n"
		+ "	'Banana'\n"
		+ ");"
		};

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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sobre", "Como usar", "Povoamento Objeto-Relacional", "Tipos de entrada",
				"Escolhendo suas próprias entradas"}));
		comboBox.setBounds(10, 11, 424, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 424, 218);
		contentPane.add(scrollPane);
		
		txtrAjuda = new JTextArea();
		txtrAjuda.setTabSize(2);
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
