package com.example.exerciserelation.Service;

import com.example.exerciserelation.Api.ApiException;
import com.example.exerciserelation.Model.Teacher;
import com.example.exerciserelation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public List<Teacher>getAllTeacher(){
      return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
teacherRepository.save(teacher);
    }
    public void update(Integer id,Teacher teacher){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("Teacher Not Found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setSalary(teacher.getSalary());
        teacher1.setAddress(teacher.getAddress());
        teacher1.setEmail(teacher.getEmail());
        teacherRepository.save(teacher1);
    }
    public void delete(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher Not Found");
        }
        teacherRepository.delete(teacher);
    }
}
