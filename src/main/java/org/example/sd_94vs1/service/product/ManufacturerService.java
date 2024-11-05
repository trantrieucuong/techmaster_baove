package org.example.sd_94vs1.service.product;

import lombok.AllArgsConstructor;
import org.example.sd_94vs1.entity.product.Manufacturer;
import org.example.sd_94vs1.repository.Product.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    public List<Manufacturer> getAll(){
        return manufacturerRepository.findAll();
    }

}
