package com.mulato.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mulato.log.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}