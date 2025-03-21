package demo5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import demo5.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
