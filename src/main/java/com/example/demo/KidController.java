package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KidController {
    @Autowired
    KidService kidService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getKids() {
        return kidService.findAllKids();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public void addKid(@RequestBody Kid kid) {
        kidService.addKid(kid);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public void deleteKid(@RequestBody int id) {
        kidService.deleteKid(id);
    }

    @RequestMapping(path = "/subject", method = RequestMethod.GET)
    public String getSubjects() {
        return kidService.findAllSubjects();
    }

    @RequestMapping(path = "/subject", method = RequestMethod.POST)
    public void addSubject(@RequestBody Subject subject) {
        kidService.addSubject(subject);
    }

    @RequestMapping(path = "/subject", method = RequestMethod.DELETE)
    public void deleteSubject(@RequestBody int id) {
        kidService.deleteSubject(id);
    }

    @RequestMapping(path = "/join", method = RequestMethod.PATCH)
    public void joinSubToKid(@RequestParam int kidId, @RequestParam int subId) {
        kidService.addSubToKid(kidId, subId);
    }
}
