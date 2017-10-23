package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KidServiceImpl implements KidService {
    @Autowired
    KidRepository kidRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Kid addKid(Kid kid) {
        return kidRepository.save(kid);
    }

    @Override
    public String findAllKids() {
        return kidRepository.findAll().toString();
    }

    @Override
    public Kid findKid(int id) {
        return kidRepository.findOne(id);
    }

    @Override
    public void deleteKid(int id) {
        kidRepository.delete(id);
    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public String findAllSubjects() {
        return subjectRepository.findAll().toString();
    }

    @Override
    public Subject findSubject(int id) {
        return subjectRepository.findOne(id);
    }

    @Override
    public void deleteSubject(int id) {
        subjectRepository.delete(id);
    }

    @Override
    public void addSubToKid(int kidId, int subId) {
        Kid kid = kidRepository.findOne(kidId);
        Subject subject = subjectRepository.findOne(subId);
        kid.getSubjects().add(subject);
        subject.getKids().add(kid);
        kidRepository.save(kid);
        subjectRepository.save(subject);
    }
}
