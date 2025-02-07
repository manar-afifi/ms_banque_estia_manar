package fr.estia.mbds.customer.mappers;


import fr.estia.mbds.customer.Customer;
import fr.estia.mbds.customer.dtos.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer)
    {
        return new CustomerDTO(customer.getId(), customer.getFirstName(),
                customer.getLastName(), customer.getEmail());
    }
    public Customer toCustomer(CustomerDTO customerDTO)
    {
        if (customerDTO != null)
            return new Customer(null, customerDTO.getFirstName(),
                    customerDTO.getLastName(), customerDTO.getEmail());
        return null;
    }


}
