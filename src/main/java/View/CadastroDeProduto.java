package View;

import Model.ProdutoDAO;
import Model.Produto;
import java.util.Scanner;

public class CadastroDeProduto {

    public static void executar(Scanner teclado, ProdutoDAO produtoDao) {
        System.out.println("CADASTRO DE PRODUTO");
        System.out.println("===================");
        System.out.print("INFORME O NOME DO PRODUTO: ");
        String nome = teclado.nextLine();
        System.out.print("INFORME A DESCRIÇÃO DO PRODUTO: ");
        String descricao = teclado.nextLine();
        System.out.print("INFORME O PREÇO DO PRODUTO: ");
        double preco = Double.parseDouble(teclado.nextLine());
        System.out.print("INFORME O CÓDIGO DO PRODUTO: ");
        int codigo = Integer.parseInt(teclado.nextLine());
        System.out.print("INFORME A QUANTIDADE EM ESTOQUE DO PRODUTO: ");
        int estoque = Integer.parseInt(teclado.nextLine());

        Produto produto = new Produto(0, nome, descricao, preco, codigo, estoque);
        produtoDao.insertProduto(produto);
        System.out.println("O PRODUTO " + nome + " FOI CADASTRADO COM SUCESSO.");



    }
}
