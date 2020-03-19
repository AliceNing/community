package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO NING.USER(name,account_id,token,gmt_create,gmt_modified,avatar_url) VALUES (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from NING.user where token = #{token}")
    User findByToken(String token);

    @Select("select * from ning.user where id = #{id}")
    User findById(Integer creator);

    @Select("select * from ning.user where account_id = #{accountId}")
    User findByAccountId(String accountId);

    @Update("update ning.user set name=#{name}, token = #{token}, gmt_modified=#{gmtModified}, avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);
}
