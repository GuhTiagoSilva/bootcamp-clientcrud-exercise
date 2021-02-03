package com.clientcrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientcrud.dto.ClientDTO;
import com.clientcrud.dto.ClientInsertDTO;
import com.clientcrud.entities.Client;
import com.clientcrud.repositories.ClientRepository;
import com.clientcrud.services.exceptions.DatabaseException;
import com.clientcrud.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> listPaged = clientRepository.findAll(pageRequest);
		return listPaged.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		try {
			Optional<Client> obj = clientRepository.findById(id);
			Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
			return new ClientDTO(client);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}

	}

	@Transactional
	public ClientDTO insert(ClientInsertDTO dto) {
		Client client = new Client();
		copyDtoToEntity(dto, client);
		client.setPassword(passwordEncoder.encode(dto.getPassword()));
		client = clientRepository.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client client = clientRepository.getOne(id);
			copyDtoToEntity(dto, client);
			client = clientRepository.save(client);
			return new ClientDTO(client);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	@Transactional
	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}catch(DatabaseException e) {
			throw new DatabaseException("Integrity violation");
		}

	}

	private void copyDtoToEntity(ClientDTO dto, Client client) {
		client.setName(dto.getName());
		client.setEmail(dto.getEmail());
		client.setBirthDate(dto.getBirthDate());
		client.setIncome(dto.getIncome());
		client.setCpf(dto.getCpf());
		client.setChildren(dto.getChildren());
		client.setBirthDate(dto.getBirthDate());
	}

}
