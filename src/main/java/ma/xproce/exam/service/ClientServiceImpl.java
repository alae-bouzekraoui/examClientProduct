package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Client;
import ma.xproce.exam.dao.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl {
    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(Long id) {
        Client client = clientRepository.getById(id);
        return client;
    }
}
