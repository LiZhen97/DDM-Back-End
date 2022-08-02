package com.project.ddm.repository;
import com.project.ddm.model.Order;
import com.project.ddm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountInfoRepository extends JpaRepository<User, String>{

    User findByUserId(String name);

}
