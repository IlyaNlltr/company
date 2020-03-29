package com.project.company.comtroller;

import com.project.company.dao.StaffRepository;
import com.project.company.model.Client;
import com.project.company.model.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffRestController {

    private final StaffRepository staffRepository;

    public StaffRestController(StaffRepository staffRepository) {

        this.staffRepository = staffRepository;
    }

    //Получить список персонала
    @GetMapping
    public ResponseEntity<Iterable<Staff>> getPersonList() {
        return new ResponseEntity<>(staffRepository.findAll(), HttpStatus.OK);
    }

    //Получить данные по id персонала
    @GetMapping("{id}")
    public ResponseEntity<Staff> getPersonId(@PathVariable String id) {
        return new ResponseEntity<>(staffRepository.findById(id).orElseThrow(RuntimeException::new), HttpStatus.OK);
    }

    //Получить данные по персоналу
    @GetMapping("/findStaff")
    public ResponseEntity<Staff> getByFullName(@RequestParam(value = "name") String name,
                                               @RequestParam(value = "surname") String surname,
                                               @RequestParam(value = "patronymic") String patronymic) {
        if (staffRepository.findPersonByFullName(name, surname, patronymic) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(staffRepository.findPersonByFullName(name, surname, patronymic), HttpStatus.OK);
        }
    }


    //Получить список персонал по должности
    @GetMapping("{position}")
    public ResponseEntity<Staff> getByPosition(@RequestParam(value = "position") String position) {
        return new ResponseEntity<>(staffRepository.findByPosition(position), HttpStatus.OK);
    }

    //Получить список персонала по полу
    @GetMapping("{gender}")
    public ResponseEntity<Staff> getByGender(@RequestParam(value = "gender") String gender) {
        return new ResponseEntity<>(staffRepository.findByGender(gender), HttpStatus.OK);
    }

    //Добавить персонал
    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff saveStaff = staffRepository.save(staff);
        return new ResponseEntity<>(saveStaff, HttpStatus.CREATED);
    }

    //Удалить кого-то из персонала
    @DeleteMapping("/delete")
    public ResponseEntity<Staff> getByName(@RequestParam(value = "name") String name,
                                           @RequestParam(value = "surname") String surname,
                                           @RequestParam(value = "patronymic") String patronymic) {
        if (staffRepository.findPersonByFullName(name, surname, patronymic) != null) {
            staffRepository.delete(staffRepository.findPersonByFullName(name, surname, patronymic));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
