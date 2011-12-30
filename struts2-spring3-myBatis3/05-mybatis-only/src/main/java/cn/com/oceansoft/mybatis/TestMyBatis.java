package cn.com.oceansoft.mybatis;

import cn.com.oceansoft.mybatis.resultHandler.ManagerResultHandler;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import javax.xml.transform.Result;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMyBatis extends TestCase {

    private SqlSession sqlSession;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setUp");

        /* file path */
        String resource = "mybatis-config.xml";

        /*Resources class help load resources from classpath,
        filesystem,or web url*/
        Reader reader = Resources.getResourceAsReader(resource);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        /*take an instance of configuration,
        can be used to create SqlSession instances.*/
        SqlSessionFactory sqlSessionFactory = builder.build(reader);

        /*01. default method
   a transaction scope will be started, none-auto-commit
   a connection will be acquired from default environment
   transaction level set to default by JDBC driver or database
   no prepared statement, no batch updates.*/
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /*enable auto-commit*/
//        SqlSession sqlSession = factory.openSession(true);

        /*use a existing jdbc connection*/
//        SqlSession sqlSession = factory.openSession(anExistingConnection);

        /* for 5 diff transaction iso level */
//        SqlSession sqlSession = factory.openSession(TransactionIsolationLevel.NONE);
//        SqlSession sqlSession = factory.openSession(TransactionIsolationLevel.READ_COMMITTED);
//        SqlSession sqlSession = factory.openSession(TransactionIsolationLevel.READ_UNCOMMITTED);
//        SqlSession sqlSession = factory.openSession(TransactionIsolationLevel.REPEATABLE_READ);
//        SqlSession sqlSession = factory.openSession(TransactionIsolationLevel.SERIALIZABLE);

        /*create new PreparedStatement for each execution of a statement.*/
//        SqlSession sqlSession = factory.openSession(ExecutorType.SIMPLE);

        /*reuse PreparedStatement*/
//        SqlSession sqlSession = factory.openSession(ExecutorType.REUSE);

        /*batch all update statements and demarcate them as necessary
        if SELECT are executed between them*/
//        SqlSession sqlSession = factory.openSession(ExecutorType.BATCH);

        this.sqlSession = sqlSession;
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println("tearDown");
        super.tearDown();
        this.sqlSession.close();
        this.sqlSession.clearCache();
    }

    //testCreate
    public void testCreate() throws Exception {
        User user = new User("1", "user1", new Date());
        sqlSession.insert("cn.com.oceansoft.mybatis.User.saveUser", user);
        sqlSession.commit();
    }

    //testBatchCreate
    public void testBatchCreate() throws Exception {
        for (int i = 0; i < 100; i++) {
            User user = new User(String.valueOf(i), "user" + String.valueOf(i), new Date());
            sqlSession.insert("saveUser", user);
            sqlSession.commit();
        }
    }

    //testRowBounds
    public void testRowBounds() {
        int offset = 50;
        int limit = 10;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List list = sqlSession.selectList("getAll", null, rowBounds);
        System.out.println(list.size());
    }

    //testResultHandler
    public void testResultHandler() {
        int offset = 50;
        int limit = 10;
        RowBounds rowBounds = new RowBounds(offset, limit);
        ResultHandler resultHandler = new ManagerResultHandler();
        sqlSession.select("getAll", null, rowBounds, new ManagerResultHandler());
    }

    //testTransaction
    public void testTransaction() throws Exception {
        boolean flag = true;

        try {
            sqlSession.insert("saveUser", new User("1", "user1", new Date()));
            sqlSession.insert("saveUser", new User("2", "user2", new Date()));
            sqlSession.insert("saveUser", new User("3", "user3", new Date()));
//            throw new RuntimeException("Power down...");
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        } finally {
            if (flag) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
            sqlSession.close();
            sqlSession.clearCache();
        }
    }

    //testGetById
    public void testGetById() {
        User user = (User) sqlSession.selectOne("getById", "1");
        System.out.println("getById: " + user.toString());
    }

    //testGetByName
    public void testGetByName() {
        User user = (User) sqlSession.selectOne("getByName", "user1");
        System.out.println("getByName: " + user.toString());
    }

    //testGetAll
    public void testGetAll() {
        List list = sqlSession.selectList("cn.com.oceansoft.mybatis.User.getAll");
        System.out.println("list size: " + list.size());
    }

    //testCountAll
    public void testCountAll() throws Exception {
        int count = (Integer) sqlSession.selectOne("countAll");
        System.out.println("count: " + count);
    }

    //testUpdate
    public void testUpdate() throws Exception {
        User user = new User("1", "updated name", new Date());
        sqlSession.update("updateUser", user);
        sqlSession.commit();
    }

    //testDelete
    public void testDelete() throws Exception {
        sqlSession.delete("deleteById", "1");
        sqlSession.commit();
    }

    //testGenPK
    public void testGenPK() throws Exception {
        User user = new User();
        user.setName("user name");
        user.setBirthday(new Date());
        sqlSession.insert("saveAutoPK" , user);
        sqlSession.commit();
    }
}
