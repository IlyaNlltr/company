package com.project.company.comtroller;
import com.project.company.dao.CompRepository;
import com.project.company.model.Comp;
import com.project.company.model.Share;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class CompRestController {

    private final CompRepository compRepository;

    public CompRestController(CompRepository listSRepository) {
        this.compRepository = listSRepository;
    }

    //Получить список листов
    @GetMapping
    public ResponseEntity<Iterable<Comp>> getCompList() {
        return new ResponseEntity<>(compRepository.findAll(), HttpStatus.OK);
    }

    //получить список компаний по имени
    @GetMapping("{name}")
    public ResponseEntity<Comp> getByName(@RequestParam(value = "name") String name) {
        if (compRepository.findByName(name) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(compRepository.findByName(name), HttpStatus.OK);
        }
    }

}
