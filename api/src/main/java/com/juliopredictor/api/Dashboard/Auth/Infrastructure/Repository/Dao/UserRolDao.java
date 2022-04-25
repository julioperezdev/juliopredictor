package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao;

import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model.UserRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRolDao extends JpaRepository<UserRolEntity, Long> {

}
