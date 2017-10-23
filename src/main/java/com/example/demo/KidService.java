package com.example.demo;

public interface KidService {
    Kid addKid(Kid kid);
    String findAllKids();
    Kid findKid(int id);
    void deleteKid(int id);

    Subject addSubject(Subject subject);
    String findAllSubjects();
    Subject findSubject(int id);
    void deleteSubject(int id);

    void addSubToKid(int kidId, int subId);
}
