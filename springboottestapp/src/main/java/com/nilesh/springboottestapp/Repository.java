package com.nilesh.springboottestapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface Repository extends JpaRepository< Model, Integer> {

}
