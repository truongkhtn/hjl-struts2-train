package cn.com.oceansoft.struts2.dao;

import cn.com.oceansoft.struts2.entity.User;
import cn.com.oceansoft.struts2.entity.UserExample;
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
        user.setUserId(UuidUtil.genUuid());
        this.getSqlSession().insert("insert", user);
    }

    public void update(User user) {
        this.getSqlSession().update("updateByPrimaryKey", user);
    }

    public void delete(String userId) {
        this.getSqlSession().delete("deleteByPrimaryKey", userId);
    }

    public User getById(String userId) {
        return (User) this.getSqlSession().selectOne("selectByPrimaryKey", userId);
    }

    public User getByExample(UserExample userExample) {
        return (User) this.getSqlSession().selectOne("selectByExample", userExample);
    }

    public List<User> getAll() {
        return this.getSqlSession().selectList("selectByExample" , null);
    }

    public int countAll() {
        return (Integer) this.getSqlSession().selectOne("countAll");
    }
}
