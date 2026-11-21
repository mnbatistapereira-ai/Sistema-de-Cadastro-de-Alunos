
import javax.swing.JOptionPane;

public class Main {

    static String[] titulos = new String[100];
    static String[] diretores = new String[100];
    static int[] anos = new int[100];
    static String[] generos = new String[100];

    static int quantidade = 0;

    public static void main(String[] args) {

        int opcao = 0;

        while (opcao != 6) {

            String menu = "===== SISTEMA DE CADASTRO DE FILMES =====\n\n"
                    + "1 - Cadastrar filme\n"
                    + "2 - Listar filmes\n"
                    + "3 - Pesquisar filme\n"
                    + "4 - Atualizar filme\n"
                    + "5 - Remover filme\n"
                    + "6 - Sair\n\n"
                    + "Escolha uma opção:";

            try {
                opcao = Integer.parseInt(
                        JOptionPane.showInputDialog(menu)
                );
            } catch (Exception e) {
                break;
            }

            switch (opcao) {

                case 1:
                    cadastrarFilme();
                    break;

                case 2:
                    listarFilmes();
                    break;

                case 3:
                    pesquisarFilme();
                    break;

                case 4:
                    atualizarFilme();
                    break;

                case 5:
                    removerFilme();
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null,
                            "Programa encerrado!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção inválida!");
            }
        }
    }

    // CADASTRAR FILME
    public static void cadastrarFilme() {

        if (quantidade >= 100) {
            JOptionPane.showMessageDialog(null,
                    "Limite de filmes atingido!");
            return;
        }

        String titulo = JOptionPane.showInputDialog(
                "Digite o título do filme:"
        );

        if (titulo == null || titulo.trim().isEmpty()) {
            return;
        }

        String diretor = JOptionPane.showInputDialog(
                "Digite o nome do diretor:"
        );

        if (diretor == null || diretor.trim().isEmpty()) {
            return;
        }

        try {

            int ano = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Digite o ano de lançamento:"
                    )
            );

            String genero = JOptionPane.showInputDialog(
                    "Digite o gênero do filme:"
            );

            if (ano <= 0 || genero == null
                    || genero.trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Dados inválidos!");
                return;
            }

            titulos[quantidade] = titulo;
            diretores[quantidade] = diretor;
            anos[quantidade] = ano;
            generos[quantidade] = genero;

            quantidade++;

            JOptionPane.showMessageDialog(null,
                    "Filme cadastrado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Ano inválido!");
        }
    }

    // LISTAR FILMES
    public static void listarFilmes() {

        if (quantidade == 0) {
            JOptionPane.showMessageDialog(null,
                    "Nenhum filme cadastrado!");
            return;
        }

        String lista = "===== FILMES CADASTRADOS =====\n\n";

        for (int i = 0; i < quantidade; i++) {

            lista += "Título: " + titulos[i] + "\n";
            lista += "Diretor: " + diretores[i] + "\n";
            lista += "Ano: " + anos[i] + "\n";
            lista += "Gênero: " + generos[i] + "\n";
            lista += "-------------------------\n";
        }

        JOptionPane.showMessageDialog(null, lista);
    }

    // PESQUISAR FILME
    public static void pesquisarFilme() {

        String busca = JOptionPane.showInputDialog(
                "Digite o título do filme:"
        );

        if (busca == null) {
            return;
        }

        boolean encontrado = false;

        for (int i = 0; i < quantidade; i++) {

            if (titulos[i].equalsIgnoreCase(busca)) {

                JOptionPane.showMessageDialog(null,
                        "Filme encontrado!\n\n"
                        + "Título: " + titulos[i] + "\n"
                        + "Diretor: " + diretores[i] + "\n"
                        + "Ano: " + anos[i] + "\n"
                        + "Gênero: " + generos[i]);

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null,
                    "Filme não encontrado!");
        }
    }

    // ATUALIZAR FILME
    public static void atualizarFilme() {

        String busca = JOptionPane.showInputDialog(
                "Digite o título do filme que deseja atualizar:"
        );

        if (busca == null) {
            return;
        }

        for (int i = 0; i < quantidade; i++) {

            if (titulos[i].equalsIgnoreCase(busca)) {

                String novoTitulo = JOptionPane.showInputDialog(
                        "Digite o novo título:"
                );

                if (novoTitulo == null
                        || novoTitulo.trim().isEmpty()) {
                    return;
                }

                String novoDiretor = JOptionPane.showInputDialog(
                        "Digite o novo diretor:"
                );

                if (novoDiretor == null
                        || novoDiretor.trim().isEmpty()) {
                    return;
                }

                try {

                    int novoAno = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Digite o novo ano:"
                            )
                    );

                    String novoGenero = JOptionPane.showInputDialog(
                            "Digite o novo gênero:"
                    );

                    if (novoAno <= 0 || novoGenero == null
                            || novoGenero.trim().isEmpty()) {

                        JOptionPane.showMessageDialog(null,
                                "Dados inválidos!");
                        return;
                    }

                    titulos[i] = novoTitulo;
                    diretores[i] = novoDiretor;
                    anos[i] = novoAno;
                    generos[i] = novoGenero;

                    JOptionPane.showMessageDialog(null,
                            "Filme atualizado com sucesso!");

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null,
                            "Ano inválido!");
                }

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Filme não encontrado!");
    }

    // REMOVER FILME
    public static void removerFilme() {

        String busca = JOptionPane.showInputDialog(
                "Digite o título do filme que deseja remover:"
        );

        if (busca == null) {
            return;
        }

        for (int i = 0; i < quantidade; i++) {

            if (titulos[i].equalsIgnoreCase(busca)) {

                for (int j = i; j < quantidade - 1; j++) {

                    titulos[j] = titulos[j + 1];
                    diretores[j] = diretores[j + 1];
                    anos[j] = anos[j + 1];
                    generos[j] = generos[j + 1];
                }

                quantidade--;

                JOptionPane.showMessageDialog(null,
                        "Filme removido com sucesso!");

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Filme não encontrado!");
    }
}
