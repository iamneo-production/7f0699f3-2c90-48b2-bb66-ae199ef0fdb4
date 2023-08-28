<<<<<<< HEAD
package com.telecom.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_PROFILE")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;
}
=======
package com.telecom.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_PROFILE")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;
}
>>>>>>> 1154ea08bf9a1965144d2ac50ca7de90386cda8e
