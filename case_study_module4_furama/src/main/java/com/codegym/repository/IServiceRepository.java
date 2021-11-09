package com.codegym.repository;

import com.codegym.dto.ServiceDetail;
import com.codegym.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service, Long> {
    @Query(value="CALL get_service_detail()", nativeQuery = true)
    List<ServiceDetail> listServiceDetail();

    @Query(value="CALL get_service_detail_by_id(:id)", nativeQuery = true)
    List<ServiceDetail> listServiceDetailById(@Param("id") Integer id);
}
