package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.utils.UuidUtil;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User Dao 实现类
 *
 * @author 胡荆陵
 */
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public void save(User user) {
        user.setId(UuidUtil.genUuid());
        this.getSqlSession().insert("saveUser", user);
    }

    public void update(User user) {
        this.getSqlSession().update("updateUser", user);
    }

    public void delete(String userId) {
        this.getSqlSession().delete("deleteById", userId);
    }

    public User getById(String userId) {
        return (User) this.getSqlSession().selectOne("getById", userId);
    }

    public User getByName(String name) {
        return (User) this.getSqlSession().selectOne("getByName", name);
    }

    public List<User> getAll() {
        return this.getSqlSession().selectList("getAll");
    }

    public int countAll() {
        return (Integer) this.getSqlSession().selectOne("countAll");
    }
}
