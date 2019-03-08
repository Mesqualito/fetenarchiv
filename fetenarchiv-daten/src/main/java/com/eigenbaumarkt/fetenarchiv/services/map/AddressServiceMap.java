package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Address;
import com.eigenbaumarkt.fetenarchiv.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddressServiceMap extends AbstractMapService<Address, Long> implements AddressService {

    @Override
    public Set<Address> findAll() {
        return super.findAll();
    }

    @Override
    public Address findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Address save(Address address) {
        return super.save(address);
    }

    @Override
    public void delete(Address address) {
        super.delete(address);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}