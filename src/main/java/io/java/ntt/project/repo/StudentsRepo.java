package io.java.ntt.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.ntt.project.Entities.Students;

public interface StudentsRepo extends  JpaRepository<Students,Long>{

}
