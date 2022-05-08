package com.amedev.scms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amedev.scms.model.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
