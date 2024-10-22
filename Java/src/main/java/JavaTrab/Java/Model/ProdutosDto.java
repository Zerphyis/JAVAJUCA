package JavaTrab.Java.Model;

import JavaTrab.Java.Tabela.Produto;
import JavaTrab.Java.Tabela.TiposProdutos;

public record ProdutosDto(Long id, String nome, TiposProdutos tipo, Double valor, Integer quantidade) {
    public ProdutosDto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getTipo(), produto.getValor(), produto.getQuantidade());
    }
}
