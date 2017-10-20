package com.example.demo;

import java.util.List;

public interface KidService {
    Kid addKid(Kid kid);
    List<Kid> findAllKids();
    Kid findKid(int id);
    void deleteKid(int id);

    Subject addSubject(Subject subject);
    List<Subject> findAllSubjects();
    Subject findSubject(int id);
    void deleteSubject(int id);
}
