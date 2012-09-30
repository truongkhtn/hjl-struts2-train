import com.company.crm.entity.Role;
import com.company.crm.service.RoleService;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Hu jing ling
 * Date: 12-9-30
 * Description: put description for the type here...
 */
@ContextConfiguration("classpath:application-config.xml")
public class TestRole extends AbstractJUnit4SpringContextTests {

    @Resource
    private RoleService roleService;

    @Test
    public void testBatchSave() {
        Role r1 = new Role();
        r1.setRoleKey("salesman");
        r1.setRoleValue("业务员");
        r1.setRemark("具有客户管理模块功能");
        r1.setSeq(1);
        roleService.save(r1);

        Role r2 = new Role();
        r2.setRoleKey("salesManager");
        r2.setRoleValue("业务经理");
        r2.setRemark("具有客户管理模块,报表管理功能");
        r2.setSeq(2);
        roleService.save(r2);

        Role r3 = new Role();
        r3.setRoleKey("account");
        r3.setRoleValue("财务人员");
        r3.setRemark("具有合同管理模块功能");
        r3.setSeq(3);
        roleService.save(r3);

        Role r4 = new Role();
        r4.setRoleKey("admin");
        r4.setRoleValue("管理员");
        r4.setRemark("具有系统所有功能");
        r4.setSeq(4);
        roleService.save(r4);
    }

}
