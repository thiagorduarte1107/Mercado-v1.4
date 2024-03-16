package View;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private static CarrinhoDeCompras instance; // Instância singleton
    private List<CarrinhoItem> itens;

    private CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public static CarrinhoDeCompras getInstance() {
        if (instance == null) {
            instance = new CarrinhoDeCompras();
        }
        return instance;
    }

    public void adicionarItem(CarrinhoItem item) {
        this.itens.add(item);
    }

    public List<CarrinhoItem> getItens() {
        return itens;
    }

    public void visualizarCarrinho() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return;
        }
        System.out.println("Itens no carrinho:");
        for (CarrinhoItem item : itens) {
            System.out.println("Produto: " + item.getProduto().getNome() + ", Quantidade: " + item.getQuantidade() + ", Preço unitário: " + item.getProduto().getPreco());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (CarrinhoItem item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void esvaziar() {
        itens.clear();
        System.out.println("O carrinho foi esvaziado.");
    }
}
