package designPattern.command;

import designPattern.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class GetReasonTest {

  @Autowired private GetReason getReasonUnderTest;

  @Test
  public void testGetReason() {
    final Map<String, String> result = getReasonUnderTest.getReason("item01");
    for (String k : result.keySet()) {
      System.out.println(k + ":" + result.get(k));
    }
  }
}
