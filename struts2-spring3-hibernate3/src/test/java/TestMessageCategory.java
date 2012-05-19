import com.company.travel.entity.MessageCategory;
import com.company.travel.service.MessageCategoryService;
import com.company.travel.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Author: Hu jing ling
 * Date: 12-5-19
 * Description: put description for the type here...
 */
@ContextConfiguration(value = {"classpath:application-config.xml"})
@Ignore
public class TestMessageCategory extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private MessageCategoryService messageCategoryService;

    @Test
    @Rollback(value = false)
    public void initData() {
        messageCategoryService.save(new MessageCategory("假期" , 0));
        messageCategoryService.save(new MessageCategory("通知" , 1));
        messageCategoryService.save(new MessageCategory("其它A" , 2));
        messageCategoryService.save(new MessageCategory("其它B" , 3));
        messageCategoryService.save(new MessageCategory("其它C" , 4));
    }

}
