package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import povoadorSQL.geradores.*;

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
		+ "*Por fim, clique em \"Povoar\". O povoadorSQL.povoamento gerado aparecerá no espaço da direita, automaticamente identado.",
		"------ POVOAMENTO OBJETO-RELACIONAL ------\n"
		+ "*Para gerar um povoadorSQL.povoamento objeto-relacional, basta usar o comando TIPO em alguma parte no espaço da esquerda.\n\n"
		+ "*A sintaxe é nome_do_tipo TIPO(numero_de parametros)\n\n"
		+ "Ex. (1 saída):\n"
		+ "Entrada:\n"
		+ "tp_teste TIPO(2)\n"
		+ "	cep " + GeradorCep.NOME_COMANDO + "\n"
		+ "	tp_pessoa TIPO(2)\n"
		+ "		cpf " + GeradorCpf.NOME_COMANDO + "\n"
		+ "		nome " + GeradorNome.NOME_COMANDO + "\n\n"
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
		+ "Obs.: A identação é opcional.",
		"------ TIPOS DE ENTRADA ------\n"
		+ "\n"
		+ "*" + GeradorCep.NOME_COMANDO + ": Gera um CEP no formato 'xxxxx-xxx'.\n\n"
		+ "*" + GeradorCelular.NOME_COMANDO + ": Gera um número de celular no formato '9xxxxxxxx'.\n\n"
		+ "*" + GeradorCelularDdd.NOME_COMANDO + ": Gera um número de celular no formato 'xx9xxxxxxxx'.\n\n"
		+ "*" + GeradorCelularFormatado.NOME_COMANDO + ": Gera um número de celular no formato '9xxxx-xxxx'.\n\n"
		+ "*" + GeradorCelularDddFormatado.NOME_COMANDO + ": Gera um número de celular no formato '(xx)9xxxx-xxxx'.\n\n"
		+ "*" + GeradorChave.NOME_COMANDO + GeradorChave.INTEIRO + "(inicio): Gera um valor que começa em inicio e é incrementado em cada inserção"
		+ " gerada. Deve  ser usado para gerar as chaves caso a tabela use uma chave inteira.\n\n"
		+ "*" + GeradorChave.NOME_COMANDO + GeradorChave.VARCHAR + "(inicio): Igual ao " + GeradorChave.NOME_COMANDO + GeradorChave.INTEIRO
		+ "(inicio). Deve ser usado para gerar as chaves caso a tabela use uma chave VARCHAR.\n\n"
		+ "*" + GeradorCnpj.NOME_COMANDO + ": Gera um CNPJ no formato 'xx.xxx.xxx/xxxx-xx'.\n\n"
		+ "*" + GeradorCpf.NOME_COMANDO + ": Gera um CPF no formato 'xxxxxxxxxxx' (VARCHAR de 11 dígitos).\n\n"
		+ "*" + GeradorCpfFormatado.NOME_COMANDO + ": Gera um CPF no formato 'xxx.xxx.xxx-xx'.\n\n"
		+ "*" + GeradorData.NOME_COMANDO + "(min, max): Gera uma data entre a data em min e a data em max. Ambos min e max devem ser inseridos na"
		+ " forma DD/MM/AAAA.\n\n"
		+ "*" + GeradorDecimal.NOME_COMANDO + "(antesPonto, depoisPonto): Gera um número decimal com um número de algarismos a esquerda menor ou"
		+ " igual a antesPonto e um número de algarismos a direita igual ao valor em depoisPonto.\n\n"
		+ "*" + GeradorEmail.NOME_COMANDO + ": Retorna um email com uma sequencia de letras e uma terminação aleatórias. Se for usado junto com "
		+ GeradorNome.NOME_COMANDO + ", usará as iniciais do nome gerado anteriormente.\n\n"
		+ "*" + GeradorEstado.NOME_COMANDO + ": Retorna o nome de um estado brasileiro.\n\n"
		+ "*" + GeradorEstadoSigla.NOME_COMANDO + ": Retorna a sigla de um estado brasileiro.\n\n"
		+ "*" + GeradorIdadeAdolescente.NOME_COMANDO + ": Gera uma idade inteira de 13 a 17 anos.\n\n"
		+ "*" + GeradorIdadeAdulto.NOME_COMANDO + ": Gera uma idade de 18 a 64 anos.\n\n"
		+ "*" + GeradorIdadeCrianca.NOME_COMANDO + ": Gera uma idade de 0 a 12 anos.\n\n"
		+ "*" + GeradorIdadeMenor.NOME_COMANDO + ": Gera uma idade de 0 a 17 anos.\n\n"
		+ "*" + GeradorInt.NOME_COMANDO + "(min, max): Gera um valor INTEIRO no intervalo [min, max].\n\n"
		+ "*" + GeradorNome.NOME_COMANDO + ": Gera um nome com 1 ou 2 nomes e 1 ou 2 SOBRENOMES sorteados aleatoriamente. Se for usado junto com "
		+ GeradorEmail.NOME_COMANDO + ", retornará um nome cujas iniciais serão iguais ao email gerado anteriormente.\n\n"
		+ "*" + GeradorPais.NOME_COMANDO + ": Retorna um país sorteado aleatoriamente.\n\n"
		+ "*" + GeradorPlaca.NOME_COMANDO + ": Retorna uma placa no formato '@@@-####', onde @ é uma letra maiúscula e # é um algarismo.\n\n"
		+ "*" + GeradorProfissao.NOME_COMANDO + ": Retorna uma profissão sorteada aleatoriamente, com gênero consistente com o definido em SEXO.\n\n"
		+ "*" + GeradorSexo.NOME_COMANDO + ": Retorna 'M' (masculino) ou 'F' (feminino). Caso " + GeradorNome.NOME_COMANDO + " e "
		+ GeradorSexo.NOME_COMANDO + " sejam ambos usados, o programa gera nomes e sexos consistentes.",
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
		+ ");",
		"------ LINGUAGENS REGULARES ------\n"
		+ "\n"
		+ "É possível usar uma linguagem regular para gerar entradas. Para isso, deve-se inserir a linguagem regular dentro de parênteses (\"\").\n"
		+ "Caracteres Especiais:\n"
		+ "@	Gera uma letra minúscula aleatória.\n"
		+ "#	Gera um algarismo aleatório.\n"
		+ "\\	Use antes de um caractere especial para que ele apareça na saída.\n"
		+ "+	Use após um caractere qualquer para que ele possa aparecer ou não. Repetindo esse caractere N vezes fará com que os N caracteres"
		+ " antes dele possam aparecer ou não."
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
				"Escolhendo suas próprias entradas", "Linguagens Regulares"}));
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
