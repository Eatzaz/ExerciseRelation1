package com.example.exerciserelation.Controller;

import com.example.exerciserelation.Api.ApiResponse;
import com.example.exerciserelation.DTO.AddressDTO;
import com.example.exerciserelation.Model.Address;
import com.example.exerciserelation.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/address")
public class AddressController {
    private final AddressService addressService;
    @GetMapping("get")
    public ResponseEntity getAddress(){
        return ResponseEntity.status(200).body(addressService.get());
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid AddressDTO address){
        addressService.addAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("Success"));
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid AddressDTO addressDTO){
        addressService.update(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Success"));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        addressService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Success"));
    }
}
