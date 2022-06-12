package com.headacheIT.todoList.Controllers;

import com.headacheIT.todoList.Models.HeadacheUser;
import com.headacheIT.todoList.Services.HeadacheUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class HeadacheUserController{
    @Autowired
    private HeadacheUserService headacheUserService;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public HeadacheUser getUserInfo(@PathVariable int userId){
        Optional<HeadacheUser> user = headacheUserService.getUser(userId);
        HeadacheUser result = new HeadacheUser();

        if(!user.isPresent()){
            result.setResultCode("404");
            result.setResultMsg("사용자가 없네유..ㅜㅜ");
        }else{
            result = user.get();
            result.setResultCode("200");
        }

        return result;
    }
    // 회원가입
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String registerUser(@RequestBody HeadacheUser user){
        // id 중복 여부확인
        // email 형식 충족여부
        // 비밀번호 형식 충족여부
        user.setRegisteredAt(LocalDateTime.now());

        user = headacheUserService.registerUser(user);

        return user.getUsername();
    }
    // 회원정보수정
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PATCH)
    public String updateUser(@PathVariable int userId, @RequestBody HeadacheUser user){
        Optional<HeadacheUser> userInfo = headacheUserService.getUser(userId);
        if(userInfo.isPresent()){
            userInfo.get().setNickname(user.getNickname());
            userInfo.get().setPassword(user.getPassword());
            headacheUserService.saveUser(userInfo.get());
        }else{
            // 회원정보 없음 에러
            return "실패";
        }

        return "성공";
    }
    // 회원탈퇴
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int userId){
        Optional<HeadacheUser> userInfo = headacheUserService.getUser(userId);
        if(userInfo.isPresent()){
            headacheUserService.deleteUser(userId);
        }

        return "삭제되었습니다.";
    }
}