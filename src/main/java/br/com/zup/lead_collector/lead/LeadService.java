package br.com.zup.lead_collector.lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    @Autowired
    LeadRepository leadRepository;

}
