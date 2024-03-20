package View;

import Helper.Utils;
import java.util.Scanner;
import Model.ProdutoDAO;

public class MenuPrincipal {
    private Scanner teclado;
    private ProdutoDAO produtoDao;
    private static final String SENHA_ADM = "senha123"; // Senha predefinida para o administrador

    public MenuPrincipal(Scanner teclado, ProdutoDAO produtoDao) {
        this.teclado = teclado;
        this.produtoDao = produtoDao;
    }

    public void exibir() {
        exibirMenu(); // Chama o método exibirMenu para mostrar o menu principal.
    }

    private void exibirMenu() {
        System.out.println("=================================");
        System.out.println("========= BEM-VINDO(A) ==========");
        System.out.println("======== MERCADO CENTRAL ========");
        System.out.println("=================================");
        System.out.println(" SELECIONE UMA OPÇÃO ABAIXO: ");
        System.out.println("1 - CADASTRAR PRODUTO");
        System.out.println("2 - LISTAR PRODUTOS");
        System.out.println("3 - COMPRAR PRODUTO");
        System.out.println("4 - VISUALIZAR CARRINHO");
        System.out.println("5 - ÁREA DO ADMINISTRADOR");
        System.out.println("6 - SAIR");

        try {
            int opcao = lerOpcaoDoUsuario();
            processarOpcaoMenu(opcao);
        } catch (NumberFormatException e) {
            System.out.println("ENTRADA INVÁLIDA. POR FAVOR, INSIRA UM NÚMERO.");
            Utils.pausar(2);
            exibirMenu();
        }
    }

    private int lerOpcaoDoUsuario() {
        String entrada = teclado.nextLine();
        return Integer.parseInt(entrada);
    }

    private void processarOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                CadastroDeProduto.executar(teclado, produtoDao);
                break;
            case 2:
               ListagemDeProdutos.executar(produtoDao);
                break;
            case 3:
                CompraDeProdutos.executar(teclado, produtoDao);
                break;
            case 4:
                 VisualizacaoDoCarrinho.executar();
                break;
            case 5:
                AcessarAreaAdministrativa areaAdm = new AcessarAreaAdministrativa(teclado, produtoDao, this);
                areaAdm.exibir();
                break;
            case 6:
                System.out.println("===== OBRIGADO E VOLTE SEMPRE ======");
                Utils.pausar(2);
                System.exit(0);
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA.");
                Utils.pausar(2);
                exibirMenu(); // Assegura que o usuário retorne ao menu após ver a mensagem.
                break;
        }
    }
}
