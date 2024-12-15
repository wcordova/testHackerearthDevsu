package com.devsu.hackerearth.backend.client.service;

import java.util.List;
import java.util.Optional;

import com.devsu.hackerearth.backend.client.model.dto.ClientDto;
import com.devsu.hackerearth.backend.client.model.dto.PartialClientDto;

public interface ClientService {

	public List<ClientDto> getAll();
	public Optional<ClientDto> getById(Long id);
	public ClientDto create(ClientDto clientDto);
	public ClientDto update(Long id, ClientDto clientDto);
	public ClientDto partialUpdate(Long id, PartialClientDto partialClientDto);
	public void deleteById(Long id);
}
