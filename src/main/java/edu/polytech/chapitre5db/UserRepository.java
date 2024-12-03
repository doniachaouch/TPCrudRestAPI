package edu.polytech.chapitre5db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("from User u where u.email = :givenemail")
    public List<User>findAllByEmail(String givenemail);

    @Query("from User u where u.tel = :tel")
    public List<User> findByTelephone( int tel);


    public User findByName(String name);

   public User findByNameAndEmail(String name , String email);
}
