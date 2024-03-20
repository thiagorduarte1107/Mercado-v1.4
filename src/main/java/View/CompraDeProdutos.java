package View;

import Model.ProdutoDAO;
import Helper.Utils; // Assumindo que você tem uma classe Helper com uma função de pausa
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
            System.out.println("Escolha a forma de pagamento:");
            System.out.println("1 - Débito");
            System.out.println("2 - Crédito");
            System.out.println("3 - Dinheiro");
            System.out.println("4 - PIX");
            System.out.print("Opção: ");
            int opcaoPagamento = Integer.parseInt(teclado.nextLine());

            switch (opcaoPagamento) {
                case 1:
                    System.out.println("Processando pagamento no débito...");
                    break;
                case 2:
                    System.out.println("Processando pagamento no crédito...");
                    break;
                case 3:
                    System.out.println("Processando pagamento em dinheiro...");
                    break;
                case 4:
                    System.out.println("Processando pagamento via PIX...");
                    break;
                default:
                    System.out.println("Opção de pagamento inválida.");
                    return; // Retorna para sair do método caso a opção de pagamento seja inválida.
            }

            Utils.pausar(5); // Simula o processamento do pagamento com uma pausa de 5 segundos.
            System.out.println("Pagamento realizado com sucesso!");

        } catch (Exception e) {
            System.err.println("Não foi possível realizar a compra: " + e.getMessage());
        }
    }
}
