package com.boobCoder.blog.repository;

import com.boobCoder.blog.entity.Blog;
import com.boobCoder.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
