public interface IMapProdutos<T extends Produto> {
    void addProduto(T t);

    void delProduto(T t);
    void listar();
}
