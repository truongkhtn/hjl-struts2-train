import com.company.crm.entity.Department;
import com.company.crm.service.DepartmentService;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration("classpath:application-config.xml")
public class TestDepartment extends AbstractJUnit4SpringContextTests {

    @Resource
    private DepartmentService departmentService;

}
