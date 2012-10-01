package tem;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Hu jing ling
 * Date: 12-10-1
 * Description: put description for the type here...
 */
public class TestSet {

    @Test
    public void testSet(){
        Set<String> set = new HashSet<String>();
        boolean  b = set.contains("1");
        System.out.println(b);
    }

}
