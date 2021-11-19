package br.com.zup.lead_collector.lead;

import br.com.zup.lead_collector.produto.Produto;
import br.com.zup.lead_collector.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    LeadRepository leadRepository;
    @Autowired
    ProdutoRepository produtoRepository;


    public List<Produto> atualizarProdutos(List<Produto> produtosRecebidos) {
        List<Produto> listaAtualizada = new ArrayList<>();

        for (Produto referencia : produtosRecebidos) {
            if (produtoRepository.existsById(referencia.getNomeProduto())) {
                listaAtualizada.add(produtoRepository.findByNomeProduto(referencia.getNomeProduto()));
            } else {
                listaAtualizada.add(referencia);
            }
        }

        return listaAtualizada;
    }

    public Lead buscarLead(Lead lead) {

        Optional<Lead> leadOptional = leadRepository.findById(lead.getEmail());

        if (leadOptional.isPresent()) {
            for (Produto referencia : lead.getProdutos()) {
                if (!leadOptional.get().getProdutos().contains(referencia)) {
                    leadOptional.get().getProdutos().add(referencia);
                }
            }

            return leadOptional.get();
        }

        return lead;
    }

    public Lead salvarLead(Lead leadRecebido) {
        List<Produto> produtos = atualizarProdutos(leadRecebido.getProdutos());
        leadRecebido.setProdutos(produtos);
        Lead lead = buscarLead(leadRecebido);

        return leadRepository.save(lead);
    }

    public List<Lead> buscarLeadsPorProduto(String nomeProduto) {
        return leadRepository.findAllByProdutosNomeProduto(nomeProduto);
    }
}
