package avva.test.controller.probes;

//import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Controller

public class ProbeController {
//
//    @RequestMapping(value = "/liveness", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    byte[] livenessProbe(HttpServletResponse response) {
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("date", new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));
//        result.put("value", "liveness");
//        result.put("service", "cdpaudit");
//        result.put("PLAYER_INITIAL_LIVES", PLAYER_INITIAL_LIVES);
//        return JSON.toJSONString(result).replaceAll("\\\\u0000", "").getBytes(StandardCharsets.UTF_8);
//    }
//
//    @RequestMapping(value = "/readiness", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    byte[] readinessProbe(HttpServletResponse response) {
//        Map<String, Object> result = new HashMap<>();
//        result.put("date", new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));
//        result.put("value", "readness");
//        result.put("service", "cdpaudit");
//        return JSON.toJSONString(result).replaceAll("\\\\u0000", "").getBytes(StandardCharsets.UTF_8);
//    }
}
