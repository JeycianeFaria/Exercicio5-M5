package br.com.zup.lead_collector.produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,String> {

    Produto findByNomeProduto(String nomeProduto);

}
