package com.appWeb.myApp.repository;

import com.appWeb.myApp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {


      Role findByName(String name);
}
