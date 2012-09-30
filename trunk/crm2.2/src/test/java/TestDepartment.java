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

    @Test
    @Ignore
    public void testSave() {
        DataFactory dataFactory = new DataFactory();
        Department d1 = new Department();
        d1.setDeptName(dataFactory.getRandomWord().toUpperCase());
        departmentService.save(d1);
        for (int i = 0; i < 2; i++) {
            Department d2 = new Department();
            d2.setDeptName(dataFactory.getRandomWord().toUpperCase());
            d2.setParent(d1);
            departmentService.save(d2);
            for (int j = 0; j < 3; j++) {
                Department d3 = new Department();
                d3.setDeptName(dataFactory.getRandomWord().toUpperCase());
                d3.setParent(d2);
                departmentService.save(d3);
            }
        }
    }
}
