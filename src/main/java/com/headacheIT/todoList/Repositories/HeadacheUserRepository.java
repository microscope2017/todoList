package com.headacheIT.todoList.Repositories;

import com.headacheIT.todoList.Models.HeadacheUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface HeadacheUserRepository extends CrudRepository<HeadacheUser, Integer> {

}
