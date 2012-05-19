//import com.company.travel.entity.Route;
//import com.company.travel.entity.RouteCategory;
//import com.company.travel.service.RouteCategoryService;
//import com.company.travel.service.RouteService;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//import javax.annotation.Resource;
//
///**
// * 测试类 - 旅游线路
// */
//@ContextConfiguration(value = {"classpath:application-config.xml"})
//@Ignore
//public class TestRoute extends AbstractTransactionalJUnit4SpringContextTests {
//
//    @Resource
//    private RouteService routeService;
//    @Resource
//    private RouteCategoryService routeCategoryService;
//
//    @Test
//    @Rollback(value = false)
//    public void testSave(){
//        Route route = new Route();
//        route.setName("海南5日游");
//
//        RouteCategory routeCategory = routeCategoryService.get("name" , "海南专线");
//
//        route.setRouteCategory(routeCategory);
//        routeService.save(route);
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void testUpdate(){
//        Route route = routeService.get("name" , "海南5日游");
//        route.setDays("5天");
//        routeService.update(route);
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void testDelete(){
//        Route route = routeService.get("name" , "海南5日游");
//        routeService.delete(route);
//    }
//
//
//}
