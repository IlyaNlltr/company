package com.project.company.comtroller;
import com.project.company.dao.AddressRepository;
import com.project.company.model.Address;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressRestController {

    private final AddressRepository addressRepository;

    public AddressRestController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Address>> getAddressList() {
        return new ResponseEntity <>(addressRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> getAddress(@PathVariable String id) {
        return new ResponseEntity <>(addressRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        Address saveAddress = addressRepository.save(address);
        return new ResponseEntity<>(saveAddress, HttpStatus.CREATED);
    }

    @DeleteMapping("/address/delete")
    public ResponseEntity<Address> getByFullAddress(@RequestParam(value = "country") String country,
                                                    @RequestParam(value = "city") String city,
                                                    @RequestParam(value = "street") String street,
                                                    @RequestParam(value = "house") String house) {
            if (addressRepository.findAddressByFullName(country, city, street, house) != null) {
            addressRepository.delete(addressRepository.findAddressByFullName(country, city, street, house));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
