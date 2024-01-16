package com.proiectfacultate.proiectfacultate.users.repositories;

import com.proiectfacultate.proiectfacultate.users.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Qualifier(value = "jpa")
@Primary
@Repository
public interface UserRepositoryJPA extends CrudRepository<User, Integer> {
    User findByUserName(String userName);

    User findById(Long userId);
}
