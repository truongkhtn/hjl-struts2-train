//import com.company.travel.entity.RouteCategory;
//import com.company.travel.service.RouteCategoryService;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * 测试类 - 旅游线路类型
// */
//@ContextConfiguration(value = {"classpath:application-config.xml"})
//@Ignore
//public class TestRouteCategory extends AbstractTransactionalJUnit4SpringContextTests {
//
//    @Resource
//    private RouteCategoryService routeCategoryService;
//
//    @Test
//    public void simple(){
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void testSave(){
//        RouteCategory routeCategory = new RouteCategory();
//        routeCategory.setName("海南专线");
////        routeCategory.setBankAccount("开户行：农行\n" +
////                "户名：任应永\n" +
////                "帐号：6228 4803 2096 5091 715");
////        routeCategory.setContactInfo("散客：小雷：固话：0571-85461944 手机13989843525 ");
////        routeCategory.setNews("xxxx");
//        routeCategoryService.save(routeCategory);
//    }
//
//    @Test
//    public void testQueryList(){
//        List<RouteCategory> list = routeCategoryService.getList("name" , "海南专线");
//        System.out.println(list.size());
//        RouteCategory routeCategory = list.get(0);
//        System.out.println(routeCategory.getRoutes().size());
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void testUpdate(){
//        RouteCategory routeCategory = routeCategoryService.get("name" , "海南专线");
////        routeCategory.setNews("OOOOO");
//        routeCategoryService.update(routeCategory);
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void testDelete(){
//        RouteCategory routeCategory = routeCategoryService.get("name" , "海南专线");
//        routeCategoryService.delete(routeCategory);
//    }
//
//}
