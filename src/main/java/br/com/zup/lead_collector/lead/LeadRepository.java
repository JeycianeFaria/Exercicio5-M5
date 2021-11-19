package br.com.zup.lead_collector.lead;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeadRepository extends CrudRepository<Lead,String> {

    List<Lead> findAllByProdutosNomeProduto(String nomeProduto);

}
