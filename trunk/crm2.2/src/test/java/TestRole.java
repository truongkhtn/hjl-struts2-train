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

}
