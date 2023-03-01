public class Cliente extends MapProdutos {
    private String nome;
    private final String LOGIN;
    private String senha;

    public Cliente(String nome, String LOGIN, String senha) {
        this.nome = nome;
        this.LOGIN = LOGIN;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public void listar() {
        if (mapProdutos.size() > 0) {
            System.out.println("\n\tLISTA DE PRODUTOS NO CARRINHO\n");
            for (int key : mapProdutos.keySet()) {
                System.out.printf("- %-20s R$ %.2f   %d uni.\n", mapProdutos.get(key).getNome(), mapProdutos.get(key).getPreco(), mapProdutos.get(key).getQuantidade());
            }
        } else {
            System.out.println("\n\tCARRINHO VAZIO!!");
        }
    }
}
