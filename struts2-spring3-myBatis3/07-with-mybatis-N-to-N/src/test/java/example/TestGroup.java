package example;

import cn.com.oceansoft.struts2.dao.GroupDao;
import cn.com.oceansoft.struts2.entity.Group;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration({"classpath:application-config.xml"})
public class TestGroup extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private GroupDao groupDao;

    @Test
    public void simple(){
    }

    @Test
    public void testGetById(){
        Group group = groupDao.getById("group1");
        System.out.println(group.toString());
    }

    @Test
    public void testGetAll(){
        List list = groupDao.getAll();
        System.out.println(list.size());
    }

    @Test
    public void testGetByIdLazy(){
        Group group = groupDao.getByIdLazy("group1");
        System.out.println("1111111111111:"+group.getName());
        System.out.println("================================");
        System.out.println("2222222222222:"+group.getUserList().get(0).getName());
    }

}
