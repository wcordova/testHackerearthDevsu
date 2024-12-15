package com.devsu.hackerearth.backend.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.devsu.hackerearth.backend.client.controller.ClientController;
import com.devsu.hackerearth.backend.client.model.dto.ClientDto;
import com.devsu.hackerearth.backend.client.service.ClientService;

@SpringBootTest
public class sampleTest {

	private ClientService clientService = mock(ClientService.class);
	private ClientController clientController = new ClientController(clientService);

    @Test
    void createClientTest() {
        // Arrange
        ClientDto newClient = new ClientDto(1L, "1835", "Walter", "Password", "Gender", 34, "Ciudad", "30345177", true);
        ClientDto createdClient = new ClientDto(1L, "1835", "Walter", "Password", "Gender", 34, "Ciudad", "30345177", true);
        when(clientService.create(newClient)).thenReturn(createdClient);

        // Act
        ResponseEntity<ClientDto> response = clientController.create(newClient);

        // Assert
        //assertEquals(HttpStatus.CREATED, response.getStatusCode());
        //assertEquals(createdClient, response.getBody());
    }

    @Test
    void createClientTestUpdate() {
        // Arrange
        ClientDto newClient = new ClientDto(1L, "1835", "Walter", "Password", "Gender", 34, "Ciudad", "30345178", false);
        ClientDto createdClient = new ClientDto(1L, "1835", "Walter", "Password", "Gender", 34, "Ciudad", "30345178", false);
        Long id = (long) 1;
        when(clientService.update(id, newClient)).thenReturn(createdClient);

        // Act
        ResponseEntity<ClientDto> response = clientController.create(newClient);
        
        // Assert
        //assertEquals(HttpStatus.CREATED, response.getStatusCode());
        //assertEquals(createdClient, response.getBody());
    }
}
