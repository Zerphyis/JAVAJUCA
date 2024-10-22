package JavaTrab.Java.Model;

import JavaTrab.Java.Tabela.Produto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    RepositoryProduto repositoryProduto;

    public void adicionarProdutos(List<ProdutosDto> produtos) {
        for (ProdutosDto produtoDto : produtos) {
            Produto produto = new Produto(
                    produtoDto.id(),
                    produtoDto.nome(),
                    produtoDto.tipo(),
                    produtoDto.valor(),
                    produtoDto.quantidade()
            );
            repositoryProduto.save(produto);
        }
    }
    public List<Produto> buscarProdutos() {
        return repositoryProduto.findAll();
    }
    public void atualizarProduto(Long id, ProdutosDto produtoDto) {

        Optional<Produto> produtoOptional = repositoryProduto.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNome(produtoDto.nome());
            produto.setTipo(produtoDto.tipo());
            produto.setValor(produtoDto.valor());
            produto.setQuantidade(produtoDto.quantidade());

            repositoryProduto.save(produto);
        } else {
            throw new EntityNotFoundException("Produto com ID " + id + " não encontrado.");
        }
    }

    public void excluirProduto(Long id) {
        if (repositoryProduto.existsById(id)) {
            repositoryProduto.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto com ID " + id + " não encontrado.");
        }
    }
}
