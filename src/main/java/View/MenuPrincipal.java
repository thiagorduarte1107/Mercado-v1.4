package View;

import Helper.Utils;
import Model.ProdutoDAO;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner teclado;
    private ProdutoDAO produtoDao;

    public MenuPrincipal(Scanner teclado, ProdutoDAO produtoDao) {
        this.teclado = teclado;
        this.produtoDao = produtoDao;
    }

    public void exibir() {
        while (true) { // Mantém o menu rodando até que o usuário escolha sair
            System.out.println("=================================");
            System.out.println("========= BEM-VINDO(A) ==========");
            System.out.println("======== MERCADO CENTRAL ========");
            System.out.println("=================================");
            System.out.println(" Selecione uma opção abaixo: ");
            System.out.println("1 - CADASTRAR PRODUTO");
            System.out.println("2 - LISTAR PRODUTOS");
            System.out.println("3 - COMPRAR PRODUTO");
            System.out.println("4 - VISUALIZAR CARRINHO");
            System.out.println("5 - SAIR");

            try {
                int opcao = lerOpcaoDoUsuario();
                if (!processarOpcaoMenu(opcao)) break; // Sai do loop se processarOpcaoMenu retornar false
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                Utils.pausar(2);
                // Não precisa chamar exibir() novamente, pois o loop while já faz isso
            }
        }
    }

    private int lerOpcaoDoUsuario() {
        String entrada = teclado.nextLine();
        return Integer.parseInt(entrada);
    }

    private boolean processarOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                CadastroDeProduto.executar(teclado, produtoDao);
                return true;
            case 2:
                ListagemDeProdutos.executar(produtoDao);
                return true;
            case 3:
                CompraDeProdutos.executar(teclado, produtoDao);
                return true;
            case 4:
                VisualizacaoDoCarrinho.executar();
                return true;
            case 5:
                System.out.println("===== OBRIGADO E VOLTE SEMPRE ======");
                Utils.pausar(2);
                return false; // Indica que deve sair do loop e terminar a execução
            default:
                System.out.println("OPÇÃO INVÁLIDA.");
                Utils.pausar(2);
                return true; // Continua no menu
        }
    }
}
