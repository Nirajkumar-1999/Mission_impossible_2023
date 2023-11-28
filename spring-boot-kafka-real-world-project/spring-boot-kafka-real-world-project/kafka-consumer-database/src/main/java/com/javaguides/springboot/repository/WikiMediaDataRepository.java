package com.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.springboot.entity.WikimediaData;

public interface WikiMediaDataRepository extends JpaRepository<WikimediaData, Long>{

}
