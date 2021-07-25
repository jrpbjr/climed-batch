package com.clinica.climed.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.climed.entities.Doctor;

@Repository
public interface doctorRepository extends JpaRepository<Doctor, Long> {

}
