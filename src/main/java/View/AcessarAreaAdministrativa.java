package View;

import Helper.Utils;
import java.util.Scanner;
import Model.ProdutoDAO;

public class AcessarAreaAdministrativa {
    private Scanner teclado;
    private ProdutoDAO produtoDao;
    private MenuPrincipal menuPrincipal;
    private static final String SENHA_ADM = "142536"; // Senha predefinida para o administrador ajustada aqui

    public AcessarAreaAdministrativa(Scanner teclado, ProdutoDAO produtoDao, MenuPrincipal menuPrincipal) {
        this.teclado = teclado;
        this.produtoDao = produtoDao;
        this.menuPrincipal = menuPrincipal;
    }

    public void exibir() {
        System.out.print("DIGITE A SENHA DO ADMINISTRADOR: ");
        String senha = teclado.nextLine();
        if (SENHA_ADM.equals(senha)) { // Comparação da senha digitada com a constante
            System.out.println("ACESSO CONCEDIDO.");
            // Aqui pode seguir com a lógica específica da área do administrador
        } else {
            System.out.println("SENHA INCORRETA.");
            Utils.pausar(2);
            menuPrincipal.exibir();
        }
    }
}
