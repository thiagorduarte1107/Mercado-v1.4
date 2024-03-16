package View;

import Model.ProdutoDAO;

public class ListagemDeProdutos {
    public static void executar(ProdutoDAO produtoDao) {
        System.out.println("LISTAGEM DE PRODUTOS");
        System.out.println("--------------------");

        // Aqui fazemos a listagem dos produtos usando o ProdutoDAO passado como argumento
        produtoDao.listarProdutos().forEach(produto ->
                System.out.println(produto.toString())
        );
    }
}
