package br.com.zup.lead_collector.lead;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired
    LeadService leadService;
    @Autowired
    ModelMapper modelMapper;

    @PutMapping
    public Lead cadastrarLead(@RequestBody Lead leadCadastrado){
       return leadService.salvarLead(leadCadastrado);
    }

    @GetMapping
    public List<Lead> buscarLeadsPorProduto(@RequestParam String nomeProduto){
        return leadService.buscarLeadsPorProduto(nomeProduto);
    }

}
