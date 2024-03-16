package View;

public class VisualizacaoDoCarrinho {
    public static void executar() {
        CarrinhoDeCompras carrinho = CarrinhoDeCompras.getInstance();

        System.out.println("Conteúdo do Carrinho:");
        carrinho.visualizarCarrinho();

        double totalCompra = carrinho.calcularTotal();
        System.out.printf("Total da compra: R$%.2f%n", totalCompra);
    }
}
