package Model;

public class Produto {
    // Atributos da classe Produto
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int codigo;
    private int estoque;

    // Construtor que inclui o ID
    public Produto(int id, String nome, String descricao, double preco, int codigo, int estoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.codigo = codigo;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format("Código: %d - Nome: %s - Descrição: %s - Preço: R$%.2f - Estoque: %d", codigo, nome, descricao, preco, estoque);
    }
}
