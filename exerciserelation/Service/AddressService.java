package com.example.exerciserelation.Service;

import com.example.exerciserelation.Api.ApiException;
import com.example.exerciserelation.DTO.AddressDTO;
import com.example.exerciserelation.Model.Address;
import com.example.exerciserelation.Model.Teacher;
import com.example.exerciserelation.Repository.AddressRepository;
import com.example.exerciserelation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address>get(){
       return addressRepository.findAll();
    }
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null) {
            throw new ApiException("Teacher Not Found");
        }
        Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuilding_number(),teacher);
addressRepository.save(address);
    }
    public void update(AddressDTO addressDTO){
        Address address=addressRepository.findAddressesById(addressDTO.getTeacher_id());
        if(address==null){
            throw new ApiException("Address Not Found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuilding_number(addressDTO.getBuilding_number());
addressRepository.save(address);
    }
public void delete(Integer id){
    Address address=addressRepository.findAddressesById(id);
    if(address==null){
        throw new ApiException("Address Not Found");
    }
    addressRepository.delete(address);
}

}
