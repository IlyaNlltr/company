package com.project.company.comtroller;

import com.project.company.dao.ShareRepository;
import com.project.company.model.Share;

import com.project.company.model.Staff;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/share")
public class ShareRestController {

    private final ShareRepository shareRepository;

    public ShareRestController(ShareRepository shareRepository) {
        this.shareRepository = shareRepository;
    }

    //Получить список контактов
    @GetMapping
    public ResponseEntity<Iterable<Share>> getPersonList() {
        return new ResponseEntity<>(shareRepository.findAll(), HttpStatus.OK);
    }

    //получить контакты по номеру телефона
    @GetMapping("{phone}")
    public ResponseEntity<Share> getByPhone(@RequestParam(value = "phone") String phone) {
        if (shareRepository.findShareByPhone(phone) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(shareRepository.findShareByPhone(phone), HttpStatus.OK);
        }
    }


}
