package com.tony.mybatiswebproject;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
//   @Insert("INSERT INTO USER VALUES (#{idx}, #{name}, #{local})")
   void insert(@Param("idx") Long idx, @Param("name") String name, @Param("local") String local);

//   @Select("SELECT * FROM USER WHERE IDX = #{idx}")
   List<User> findByIdx(@Param("idx") Long idx);

//   @Delete("DELETE FROM USER WHERE IDX = #{idx}")
   void deleteByIdx(@Param("idx") Long idx);

//   @Update("UPDATE USER SET NAME = #{name} WHERE IDX = #{idx}")
   void setFixedNameByIdx(@Param("name") String name, @Param("idx") Long idx);
}
