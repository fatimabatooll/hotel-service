package com.glc.hotelmanagemnt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glc.hotelmanagemnt.Model.Hotel;

public interface HotelRespository extends JpaRepository<Hotel, Long> {

    public List<Hotel> findAll();

}
