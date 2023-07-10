
package com.glc.hotelmanagemnt.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.hotelmanagemnt.Model.Hotel;
import com.glc.hotelmanagemnt.Repository.HotelRespository;

@RestController
@RequestMapping("/hotel") // http://localhost:8080/hotel
@CrossOrigin(origins = "http://localhost:3000") 

public class HotelController {
  private final HotelRespository hotelRespository;

  public HotelController(HotelRespository hotelRespository) {
    this.hotelRespository = hotelRespository;
  }

  @PostMapping("/add") // http://localhost:8080/hotel/add
  public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
    return ResponseEntity.ok().body(hotelRespository.save(hotel));
  }

  @GetMapping("/getall") // http://localhost:8080/hotel/getall
  public List<Hotel> getHotelall() {
    return hotelRespository.findAll();
  }

  @GetMapping("/getbyid/{id}") // http://localhost:8080/hotel/getbyid/{id}
  public Hotel getHotelById(@PathVariable Long id) {
    return hotelRespository.findById(id).orElse(null);
  }

  @DeleteMapping("/delete/{id}") // http://localhost:8080/hotel/delete/{id}
  public void deleteBook(@PathVariable Long id) {
    hotelRespository.deleteById(id);

  }
}