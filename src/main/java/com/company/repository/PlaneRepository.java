package com.company.repository;

import com.company.vo.PlaneVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<PlaneVO, String> {
}
