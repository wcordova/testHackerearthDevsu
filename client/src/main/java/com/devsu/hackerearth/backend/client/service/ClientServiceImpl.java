package com.devsu.hackerearth.backend.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.client.model.Client;
import com.devsu.hackerearth.backend.client.model.dto.ClientDto;
import com.devsu.hackerearth.backend.client.model.dto.PartialClientDto;
import com.devsu.hackerearth.backend.client.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public List<ClientDto> getAll() {
		// Get all clients
		List<Client> clients = clientRepository.findAll();
		List<ClientDto> result = new ArrayList();
		for(Client client: clients) {
			result.add(mapperToClient(client));
		}	
		return result;
	}

	private ClientDto mapperToClient(Client client) {
		ClientDto clientDto =  new ClientDto();
		clientDto.setActive(client.isActive());
		clientDto.setAddress(client.getAddress());
		clientDto.setAge(client.getAge());
		clientDto.setDni(client.getDni());
		clientDto.setGender(client.getGender());
		clientDto.setName(client.getName());
		clientDto.setPassword(client.getPassword());
		clientDto.setPhone(client.getPhone());	
		clientDto.setId(client.getId());			
		return clientDto;
	}

	private Client mapperToClientDto(ClientDto clientDto) {
		Client client = new Client();
		client.setActive(clientDto.isActive());		
		client.setAddress(clientDto.getAddress());
		client.setAge(clientDto.getAge());
		client.setDni(clientDto.getDni());
		client.setGender(clientDto.getGender());
		client.setName(clientDto.getName());
		client.setPassword(clientDto.getPassword());
		client.setPhone(clientDto.getPhone());	
		return client;
	}

	@Override
	public Optional<ClientDto> getById(Long id) {
		// Get clients by id
		Optional<Client> client = clientRepository.findById(id);
		if(client.isEmpty()) {
			return null;
		}
		return client.map(this::mapperToClient);				
	}

	@Override
	public ClientDto create(ClientDto clientDto) {
		// Create client
		Client client = mapperToClientDto(clientDto);
		return mapperToClient(clientRepository.save(client));
	}

	@Override
	public ClientDto update(Long id, ClientDto clientDto) {
		// Update client
		Client existClient = clientRepository.findById(id)
			.orElseThrow(null);
		if(existClient == null) {
			return null;
		}
		existClient.setActive(clientDto.isActive());
		existClient.setAddress(clientDto.getAddress());
		existClient.setAge(clientDto.getAge());
		existClient.setDni(clientDto.getDni());
		existClient.setGender(clientDto.getGender());
		existClient.setName(clientDto.getName());
		existClient.setPassword(clientDto.getPassword());
		existClient.setPhone(clientDto.getPhone());

		Client updateClient = clientRepository.save(existClient);

		return mapperToClient(updateClient);
	}

	@Override
    public ClientDto partialUpdate(Long id, PartialClientDto partialClientDto) {
        Client existClient = clientRepository.findById(id)
			.orElseThrow(null);
		if(existClient == null) {
			return null;
		}
		existClient.setActive(partialClientDto.isActive());

		Client updateClient = clientRepository.save(existClient);
		
		return mapperToClient(updateClient);
    }

	@Override
	public void deleteById(Long id) {
		// Delete client
		clientRepository.deleteById(id);
	}
}
