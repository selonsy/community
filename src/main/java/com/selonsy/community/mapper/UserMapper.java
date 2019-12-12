package com.selonsy.community.mapper;

import com.selonsy.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Copyright：Sichen International Co. Ltd.
 *
 * @author selonsy
 * Created on 2019/12/11.
 * Desc : none
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER(name,account_id,token,gmt_create,gmt_modified) VALUES(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("SELECT * FROM USER WHERE TOKEN=#{token}")
    User findByToken(@Param("token") String token);
}
