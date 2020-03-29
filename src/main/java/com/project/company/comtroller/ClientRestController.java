package com.project.company.comtroller;

import com.project.company.dao.AddressRepository;
import com.project.company.dao.ClientRepository;
import com.project.company.dao.StaffRepository;
import com.project.company.model.Address;

import com.project.company.model.Client;
import com.project.company.model.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientRestController {

    private final ClientRepository clientRepository;

    public ClientRestController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Получить список клиентов
    @GetMapping
    public ResponseEntity<Iterable<Client>> getClientList() {
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    //Получить список клиентов по группе
    @GetMapping("{groups}")
    public ResponseEntity<Client> getClientByGroups(@RequestParam(value = "groups") String groups) {
        return new ResponseEntity<>(clientRepository.findByGroups(groups), HttpStatus.OK);
    }

}
