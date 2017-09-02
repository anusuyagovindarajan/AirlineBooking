package com.company.repository;

import com.company.vo.LocationVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationVO, Integer> {
}
