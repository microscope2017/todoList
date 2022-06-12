package com.headacheIT.todoList.Services;

import com.headacheIT.todoList.Models.HeadacheUser;
import com.headacheIT.todoList.Repositories.HeadacheUserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeadacheUserService {
    @Autowired
    private HeadacheUserRepository headacheUserRepository;

    // user 데이터 가져오기
    public Optional<HeadacheUser> getUser(int id){
        var user = headacheUserRepository.findById(id);

        return user;
    }
    // user 데이터 저장
    public HeadacheUser registerUser(HeadacheUser user){
        HeadacheUser registerUserModel = headacheUserRepository.save(user);
        return registerUserModel;
    }
    // user 정보 저장
    public HeadacheUser saveUser(HeadacheUser user){
        HeadacheUser saveUserModel = headacheUserRepository.save(user);
        return saveUserModel;
    }
    // user 정보 삭제
    public void deleteUser(int id){
        headacheUserRepository.deleteById(id);
    }
}
