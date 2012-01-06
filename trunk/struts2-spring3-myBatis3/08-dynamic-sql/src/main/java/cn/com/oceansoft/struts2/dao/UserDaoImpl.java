package cn.com.oceansoft.struts2.dao;


import cn.com.oceansoft.struts2.entity.User;
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
        this.getSqlSession().insert("saveUser", user);
    }

    public void update(User user) {
//        this.getSqlSession().update("updateUser", user);
        this.getSqlSession().update("updateIfNecessary", user);
    }

    public void delete(String userId) {
        this.getSqlSession().delete("deleteById", userId);
    }

    public User getById(String id) {
        return (User) this.getSqlSession().selectOne("getById", id);
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

    public void deleteAll() {
        this.getSqlSession().delete("deleteAll");
    }

    public List<User> getActiveUserByNameLike(User user) {
        return this.getSqlSession().selectList("getActiveUserByNameLike" , user);
    }

    public List<User> getActiveUserLike(User user) {
        return this.getSqlSession().selectList("getActiveUserLike" , user);
    }

    public List<User> getUserLike(User user) {
        return this.getSqlSession().selectList("getUserLike" , user);
    }

    public List<User> getByIds(List<String> selectedIds) {
        return this.getSqlSession().selectList("getByIds" , selectedIds);
    }
}
