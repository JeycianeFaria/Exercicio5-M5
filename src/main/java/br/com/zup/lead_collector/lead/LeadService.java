package br.com.zup.lead_collector.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    @Autowired
    LeadRepository leadRepository;

    public Lead salvarLead(Lead leadRecebido){
        return leadRepository.save(leadRecebido);
    }

    public List<Lead> buscarLeadsPorProduto(String nomeProduto){
        return leadRepository.findAllByProdutosNomeProduto(nomeProduto);
    }
}
