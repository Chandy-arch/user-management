package com.mahindra.userManagement.repo;

import com.mahindra.userManagement.model.UserMgmt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepo extends JpaRepository<UserMgmt, String> {

    Optional<UserMgmt> findByEmail(String email);
}