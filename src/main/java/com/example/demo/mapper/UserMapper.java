package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserMapper {



    @Select("SELECT * FROM user")
    List<User> findAll();

    @Update("INSERT INTO `user` ( `name`, `address`, `age`, `sex`, `phone`) VALUES (#{name},#{address},#{age},#{sex},#{phone});")
    @Transactional
    void save(User user) ;

    @Update("update user set name=#{name},address=#{address},age=#{age},sex=#{sex},phone=#{phone} where id = #{id}")
    @Transactional
    void updateById(User user);

    @Delete("delete from user where id = #{id}")
    void deleteById(Long id);
}
