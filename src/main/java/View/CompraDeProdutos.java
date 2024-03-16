package View;

import Model.ProdutoDAO;
import java.util.Scanner;

public class CompraDeProdutos {

    public static void executar(Scanner teclado, ProdutoDAO produtoDao) {
        System.out.println("COMPRAR PRODUTOS");
        System.out.println("================");
        System.out.println("Digite o código do produto que deseja comprar:");
        int codigo = Integer.parseInt(teclado.nextLine()); // Obtém o código do produto do usuário.
        System.out.println("Digite a quantidade:");
        int quantidade = Integer.parseInt(teclado.nextLine()); // Obtém a quantidade desejada.

        // Tentativa de realizar a compra do produto com o código e quantidade fornecidos.
        try {
            produtoDao.comprarProduto(codigo, quantidade);
        } catch (Exception e) {
            System.err.println("Não foi possível realizar a compra: " + e.getMessage());
        }
    }
}
