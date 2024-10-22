package JavaTrab.Java.Tabela;

import JavaTrab.Java.Model.ProdutosDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@Entity(name = "Produtos")
@Table(name = "produtos")
public class Produto {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private TiposProdutos tipo;

    private  Double valor;

    private Integer  quantidade;

    public Produto(ProdutosDto dados){
        this.id= dados.id();
        this.nome= dados.nome();
        this.valor= dados.valor();
        this.tipo=dados.tipo();
        this.quantidade=dados.quantidade();
    }

    public Produto(Long id, String nome, TiposProdutos tipo, Double valor, Integer quantidade) {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TiposProdutos getTipo() {
        return tipo;
    }

    public void setTipo(TiposProdutos tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
