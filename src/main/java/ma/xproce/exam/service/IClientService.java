package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Client;

public interface IClientService {
    public Client getClientById(Long id);
}
