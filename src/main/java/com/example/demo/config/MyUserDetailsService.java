package com.example.demo.config;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(customerName);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer not found : Error 404 ");
        }
        return new UserPrincipal(customer);
    }
}
