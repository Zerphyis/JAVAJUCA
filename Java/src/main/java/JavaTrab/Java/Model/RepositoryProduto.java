package JavaTrab.Java.Model;

import JavaTrab.Java.Tabela.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto,Long> {

}
