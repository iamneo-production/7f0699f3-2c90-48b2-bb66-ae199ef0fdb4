<<<<<<< HEAD
package com.telecom.customerservice.repository;

import com.telecom.customerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserId(String userId);
}
=======
package com.telecom.customerservice.repository;

import com.telecom.customerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserId(String userId);
}
>>>>>>> 1154ea08bf9a1965144d2ac50ca7de90386cda8e
