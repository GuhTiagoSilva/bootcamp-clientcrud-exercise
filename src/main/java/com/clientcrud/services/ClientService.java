package com.clientcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.clientcrud.dto.ClientDTO;
import com.clientcrud.entities.Client;
import com.clientcrud.repositories.ClientRepository;
import com.sun.el.stream.Optional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> listPaged = clientRepository.findAll(pageRequest);
		return listPaged.map(x -> new ClientDTO(x));
	}

	public ClientDTO findById(Long id) {
		Client client = clientRepository.findById(id).get();
		return new ClientDTO(client);
	}

}
