import java.util.HashMap;
import java.util.Map;

public abstract class MapProdutos implements IMapProdutos {
    Map<Integer, Produto> mapProdutos = new HashMap<>();

    @Override
    public void addProduto(Produto produto) {
        mapProdutos.put(mapProdutos.size() + 1, produto);
    }

    @Override
    public void delProduto(Produto produto) {
        mapProdutos.remove(produto.getNome());
    }
}
