package com.company.repository;

import com.company.vo.FlightVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightVO, String> {
}
