//import com.company.travel.entity.Journey;
//import com.company.travel.entity.Route;
//import com.company.travel.service.JourneyService;
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
// * TestJourney
// */
//@ContextConfiguration(value = {"classpath:application-config.xml"})
//@Ignore
//public class TestJourney extends AbstractTransactionalJUnit4SpringContextTests {
//
//    @Resource
//    private JourneyService journeyService;
//    @Resource
//    private RouteService routeService;
//
//    @Test
//    @Rollback(value = false)
//    public void testSave(){
//        Journey journey = new Journey();
//        journey.setLive("三亚特色酒店");
//        journey.setMeal("无");
//        journeyService.save(journey);
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void testUpdate(){
//        Journey journey = journeyService.get("accommodatior" , "三亚特色酒店");
//        journey.setDescription("很好玩222");
//        journeyService.update(journey);
//    }
//
//    @Test
//    @Rollback(value = false)
//    public void testDelete(){
//        Journey journey = journeyService.get("accommodatior" , "三亚特色酒店");
//        journeyService.delete(journey);
//    }
//}
