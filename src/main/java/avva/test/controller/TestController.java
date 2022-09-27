package avva.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/avva")
public class TestController {
   // private final SessionFactory sessionFactory;
    @GetMapping(value = "/envById")
    public List<String> recordsById(@RequestParam(value = "id", required = false) Integer id) {
List ret =  new ArrayList<String>();
String PLAYER_INITIAL_LIVES = System.getenv("PLAYER_INITIAL_LIVES");
        String UI_PROPERTIES_FILE_NAME = System.getenv("UI_PROPERTIES_FILE_NAME");

        ret.add("PLAYER_INITIAL_LIVES "+PLAYER_INITIAL_LIVES);
        ret.add("UI_PROPERTIES_FILE_NAME "+UI_PROPERTIES_FILE_NAME);
       // ret.add("avva/test");
        ret.add("avva/test");
        return ret;
    }

    @GetMapping(value = "/getmonitor")
    public  String  getmonitor( ) {
        //api_http_requests_total{method="POST", handler="/messages"}
        return "hrenota_metric{param=\"figota\", valueparam=\"300\"}";
    }

/*
    void processData(SessionFactory sessionFactory, ConcurrentLinkedQueue<AuditTrailSaveRequest> unProcessQueue, Integer batchCount) {
        List<AuditTrailSaveRequest> processList = new ArrayList<>();
        int i = 0;
        AuditTrailSaveRequest item = unProcessQueue.poll();
        if (item != null) {
            Session session = null;
            Transaction transaction = null;
            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                while (i < batchCount && item != null) {
                    if (item != null) {
                        processList.add(item);
                        String subSystem = item.getSubSystem();
                        if (!checkPartition(subSystem)) {
                            createPartition(subSystem);
                            init();
                        }
                        Query query = session.createNativeQuery("INSERT INTO audit_trail_" + subSystem + "(id, sys_create_time, ip, system, subsystem," +
                                " event, act, login, main_object, secondary_object, parent_object, additional_info)" +
                                " VALUES (:id, :sysCreateTime, :ip, :system, :subsystem," +
                                " :event, :act, :login, :mainObject, :secondaryObject, :parentObject, to_json(:additionalInfo::json))");
                        query.setParameter("id", UUID.randomUUID().toString());
                        query.setParameter("sysCreateTime", new Date());
                        query.setParameter("ip", item.getIp());
                        query.setParameter("system", item.getSystem());
                        query.setParameter("subsystem", item.getSubSystem());
                        query.setParameter("event", item.getEvent());
                        query.setParameter("act", item.getAction());
                        query.setParameter("login", item.getLogin());
                        query.setParameter("mainObject", item.getMainObject());
                        query.setParameter("secondaryObject", item.getSecondaryObject());
                        query.setParameter("parentObject", item.getParentObject());
                        query.setParameter("additionalInfo", item.getAdditionalInfo());
                        log.info(query.getQueryString());
                        query.executeUpdate();
                    }
                    i++;
                    if (i < batchCount) {
                        item = unProcessQueue.poll();
                    }
                }
                session.flush();
                session.getTransaction().commit();
            } catch (Exception ex) {
                log.error("Insert LOG. Process exception:", ex);
                if (transaction != null && TransactionStatus.ACTIVE.equals(transaction.getStatus())) {
                    transaction.rollback();
                }
            } finally {
                if (session != null && session.isOpen()) {
                    try {
                        session.close();
                    } catch (HibernateException e) {
                        log.error("processData", e);
                    }
                }
            }
        }
    }
*/



}
