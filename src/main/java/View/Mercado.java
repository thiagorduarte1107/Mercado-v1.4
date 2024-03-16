package View;

import Model.ProdutoDAO;
import java.util.Scanner;

public class Mercado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ProdutoDAO produtoDao = new ProdutoDAO();

        MenuPrincipal menuPrincipal = new MenuPrincipal(teclado, produtoDao);
        menuPrincipal.exibir(); // Exibe o menu principal e processa a escolha do usuário
    }
}
