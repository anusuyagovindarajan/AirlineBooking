package com.company.repository;

import com.company.vo.SeatVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<SeatVO,String> {
}
