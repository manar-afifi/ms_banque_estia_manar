package fr.estia.mbds.customer.services;

import fr.estia.mbds.customer.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);
}
