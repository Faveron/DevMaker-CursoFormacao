public class Estoque extends MapProdutos {
    public Estoque() {
        mapProdutos.put(mapProdutos.size() + 1, new Produto("Camiseta", 10, 10.0));
        mapProdutos.put(mapProdutos.size() + 1, new Produto("Calça", 10, 50.0));
        mapProdutos.put(mapProdutos.size() + 1, new Produto("Blusa", 10, 100.0));
    }

    @Override
    public void listar() {
        if (mapProdutos.size() > 0) {
            System.out.println("\n\tLISTA DE PRODUTOS\n");
            for (int key : mapProdutos.keySet()) {
                System.out.printf("Código: %03d - %-20s R$ %.2f\n", key, mapProdutos.get(key).getNome(), mapProdutos.get(key).getPreco());
            }
        } else {
            System.out.println("\n\tNENHUM PRODUTO CADASTRADO!!");
        }
    }
}
