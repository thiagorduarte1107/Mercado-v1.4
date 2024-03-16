package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO {

    private static final String DATABASE_URL = "jdbc:sqlite:C:\\Users\\LAB-BABY\\Desktop\\Dev\\Mercado\\Mercado-v1.2\\mercado.db";

    public ProdutoDAO() {
        createNewTable();
    }

    private Connection connect() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private void createNewTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS produtos (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                Nome TEXT NOT NULL,
                Descricao TEXT,
                Preco REAL NOT NULL,
                Codigo INTEGER UNIQUE NOT NULL,
                Estoque INTEGER NOT NULL DEFAULT 0
                );""";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'produtos' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertProduto(Produto produto) {
        String sql = "INSERT INTO produtos(Nome, Descricao, Preco, Codigo, Estoque) VALUES(?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getCodigo());
            pstmt.setInt(5, produto.getEstoque());
            pstmt.executeUpdate();
            System.out.println("Produto inserido com sucesso.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT ID, Nome, Descricao, Preco, Codigo, Estoque FROM produtos";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("ID"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getDouble("Preco"),
                        rs.getInt("Codigo"),
                        rs.getInt("Estoque"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return produtos;
    }

    public void comprarProduto(int codigoProduto, int quantidade) {
        String sqlEstoque = "SELECT Estoque FROM produtos WHERE Codigo = ?";
        String sqlUpdate = "UPDATE produtos SET Estoque = Estoque - ? WHERE Codigo = ?";

        try (Connection conn = connect()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtEstoque = conn.prepareStatement(sqlEstoque)) {
                pstmtEstoque.setInt(1, codigoProduto);
                ResultSet rs = pstmtEstoque.executeQuery();
                if (!rs.next() || rs.getInt("Estoque") < quantidade) {
                    System.out.println("Estoque insuficiente ou produto não encontrado.");
                    conn.rollback();
                    return;
                }
            }

            try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
                pstmtUpdate.setInt(1, quantidade);
                pstmtUpdate.setInt(2, codigoProduto);
                int affectedRows = pstmtUpdate.executeUpdate();
                if (affectedRows > 0) {
                    conn.commit();
                    System.out.println("Compra realizada com sucesso.");
                } else {
                    System.out.println("Atualização de estoque falhou.");
                    conn.rollback();
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Optional<Produto> buscarProdutoPeloCodigo(int codigo) {
        String sql = "SELECT * FROM produtos WHERE Codigo = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("ID"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getDouble("Preco"),
                        rs.getInt("Codigo"),
                        rs.getInt("Estoque"));
                return Optional.of(produto);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

}
