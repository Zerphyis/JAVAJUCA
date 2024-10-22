package JavaTrab.Java.Dao;

import JavaTrab.Java.Model.ProdutoService;
import JavaTrab.Java.Model.ProdutosDto;
import JavaTrab.Java.Tabela.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class ProdutosDaoController {
    @Autowired
    ProdutoService repositorio;

    @PostMapping//C
    public ResponseEntity<Produto> criandoProdutos(@RequestBody List<ProdutosDto> dados) {
        repositorio.adicionarProdutos(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping//R
    public ResponseEntity<List<Produto>> buscarProdutos() {
        List<Produto> produtos = repositorio.buscarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}") // U
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody ProdutosDto produtoDto) {
        repositorio.atualizarProduto(id, produtoDto);
        return ResponseEntity.ok("Produto com ID " + id + " atualizado com sucesso.");
    }

    @DeleteMapping("/{id}") // D
    public ResponseEntity<String> excluirProduto(@PathVariable Long id) {
        repositorio.excluirProduto(id);
        return ResponseEntity.ok("Produto com ID " + id + " excluído com sucesso.");
    }
}
