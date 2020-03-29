package com.project.company.comtroller;

import com.project.company.dao.AddressRepository;
import com.project.company.dao.TagsRepository;
import com.project.company.model.Address;
import com.project.company.model.Client;
import com.project.company.model.Share;
import com.project.company.model.Tags;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagsRestController {
    private final TagsRepository tagsRepository;

    public TagsRestController(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
        }

    //получить список всех тегов
    @GetMapping
    public ResponseEntity<Iterable<Tags>> getTagsList() {
        return new ResponseEntity <>(tagsRepository.findAll(), HttpStatus.OK);
    }

    //получить данные по тегу
    @GetMapping("{tags}")
    public ResponseEntity<Tags> getByTags(@RequestParam(value = "tags") String tag) {
        if (tagsRepository.findByTags(tag) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(tagsRepository.findByTags(tag), HttpStatus.OK);
        }
    }
}
