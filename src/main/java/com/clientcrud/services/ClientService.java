package com.clientcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientcrud.dto.ClientDTO;
import com.clientcrud.entities.Client;
import com.clientcrud.repositories.ClientRepository;
import com.sun.el.stream.Optional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> listPaged = clientRepository.findAll(pageRequest);
		return listPaged.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = clientRepository.findById(id).get();
		return new ClientDTO(client);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		copyDtoToEntity(dto, client);
		client = clientRepository.save(client);
		return new ClientDTO(client);
	}
	
	@Transactional
	public ClientDTO update(Long id,ClientDTO dto) {
		Client client = clientRepository.getOne(id);
		copyDtoToEntity(dto, client);
		client = clientRepository.save(client);
		return new ClientDTO(client);
	}
	
	@Transactional
	public void delete(Long id) {
		Client client = clientRepository.getOne(id);
		clientRepository.delete(client);
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client client) {
		client.setName(dto.getName());
		client.setIncome(dto.getIncome());
		client.setCpf(dto.getCpf());
		client.setChildren(dto.getChildren());
		client.setBirthDate(dto.getBirthDate());
	}
	
	
	
	
	

}
