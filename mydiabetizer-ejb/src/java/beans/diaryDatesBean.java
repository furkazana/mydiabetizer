/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.ChartEntity;
import ent.Diarydates;
import ent.TimeSlots;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rock n Roll
 */
@Stateless
@LocalBean
public class diaryDatesBean {

    @PersistenceContext(unitName = "mydiabetizer-ejbPU")
    private EntityManager em;

    private final String queries[] = {"Oob.findByOobUserDateId", "Bb.findByBbUserDateId", "Bplus2.findByB2UserDateId",
        "Bl.findByBlUserDateId", "Lplus2.findByL2UserDateId",
        "Bd.findByBdUserDateId", "Dplus2.findByD2UserDateId",
        "Bbed.findByBbedUserDateId", "Random.findByRandomUserDateId"};

    private final String userIds[] = {"oobUserDateId", "bbUserDateId", "b2UserDateId",
        "blUserDateId", "l2UserDateId",
        "bdUserDateId", "d2UserDateId",
        "bbedUserDateId", "randomUserDateId"};//need to be udated

    public Diarydates addUserAndDate(int id, String ill) {

        Query q = em.createNamedQuery("Diarydates.findHighestTableNumber");
        int tableId = (int) q.getSingleResult() + 1;
        Diarydates diary = new Diarydates();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        Date date1 = new Date();
        Timestamp timestamp = new Timestamp(date1.getTime());

        diary.setDiarydateId(tableId);
        diary.setUserId(id);
        diary.setIll(ill);
        diary.setDate(dateFormat.format(date));
        diary.setCreatedAt(timestamp);

        em.persist(diary);
        return diary;
    }

    public List<List<ChartEntity>> createGraphsData(int userId) {
        Query q = em.createNativeQuery("INSERT INTO graphs_table(id, sugar, insulin, time, date) SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, bb.BB_SUGAR as sugar, bb.BB_INSULIN as insulin, bb.BB_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.BB AS bb, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = bb.BB_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as bb "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, bbed.BBED_SUGAR as sugar, bbed.BBED_INSULIN as insulin, bbed.BBED_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.BBED AS bbed, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = bbed.BBED_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as bbed "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, bd.BD_SUGAR as sugar, bd.BD_INSULIN as insulin, bd.BD_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.BD AS bd, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = bd.BD_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as bd "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, bl.BL_SUGAR as sugar, bl.BL_INSULIN as insulin, bl.BL_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.BL AS bl, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = bl.BL_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as bl "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, bplus2.B2_SUGAR as sugar, bplus2.B2_INSULIN as insulin, bplus2.B2_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.BPLUS2 AS bplus2, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = bplus2.B2_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as bplus2 "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, dplus2.D2_SUGAR as sugar, dplus2.D2_INSULIN as insulin, dplus2.D2_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.DPLUS2 AS dplus2, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = dplus2.D2_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as dplus2 "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, lplus2.L2_SUGAR as sugar, lplus2.L2_INSULIN as insulin, lplus2.L2_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.LPLUS2 AS lplus2, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = lplus2.L2_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as lplus2 "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, oob.OOB_SUGAR as sugar, oob.OOB_INSULIN as insulin, oob.OOB_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.OOB AS oob, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = oob.OOB_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as oob "
                + " UNION ALL "
                + " SELECT * FROM ( "
                + "    SELECT dd.DIARYDATE_ID as id, r.RANDOM_SUGAR as sugar, r.RANDOM_INSULIN as insulin, r.RANDOM_TIME as \"time\", dd.\"DATE\" as \"date\" FROM APP.RANDOM AS r, APP.DIARYDATES AS dd  "
                + "    WHERE dd.DIARYDATE_ID = r.RANDOM_USER_DATE_ID AND dd.USER_ID = ? "
                + ") as r "
                + " ORDER BY \"date\", \"time\"");
        q.setParameter(1, userId);
        q.setParameter(2, userId);
        q.setParameter(3, userId);
        q.setParameter(4, userId);
        q.setParameter(5, userId);
        q.setParameter(6, userId);
        q.setParameter(7, userId);
        q.setParameter(8, userId);
        q.setParameter(9, userId);
        q.executeUpdate();
        
        Query q1 = em.createNativeQuery("SELECT * FROM APP.GRAPHS_TABLE "
                    +" WHERE HOUR(time) BETWEEN 12 AND 17 AND MINUTE(time) BETWEEN 0 AND 59", ChartEntity.class);
        List<ChartEntity> twelveToSix = (List<ChartEntity>) q1.getResultList();
        
        Query q2 = em.createNativeQuery("SELECT * FROM APP.GRAPHS_TABLE "
                    +" WHERE HOUR(time) BETWEEN 18 AND 23 AND MINUTE(time) BETWEEN 0 AND 59", ChartEntity.class);
        List<ChartEntity> eighteenToEleven = (List<ChartEntity>) q2.getResultList();
        
        Query q3 = em.createNativeQuery("SELECT * FROM APP.GRAPHS_TABLE "
                    +" WHERE HOUR(time) BETWEEN 0 AND 5 AND MINUTE(time) BETWEEN 0 AND 59", ChartEntity.class);
        List<ChartEntity> zeroToSix = (List<ChartEntity>) q3.getResultList();
        
        Query q4 = em.createNativeQuery("SELECT * FROM APP.GRAPHS_TABLE "
                    +" WHERE HOUR(time) BETWEEN 6 AND 11 AND MINUTE(time) BETWEEN 0 AND 59", ChartEntity.class);
        List<ChartEntity> sixToTwelve = (List<ChartEntity>) q4.getResultList();
        
        
        Query delete = em.createNativeQuery("DELETE FROM graphs_table");
       
        delete.executeUpdate();
        
        List<List<ChartEntity>> entities = new ArrayList<>();
        entities.add(sixToTwelve);
        entities.add(twelveToSix);
        entities.add(eighteenToEleven);
        entities.add(zeroToSix);
        
        return entities;

    }

    public Diarydates resultExistForTheDay(int id) {
        Diarydates nul;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        List<Diarydates> dd;

        try {
            Query q = em.createNamedQuery("Diarydates.findByUserIdAndDate");
            q.setParameter("date", dateFormat.format(date));
            q.setParameter("userId", id);
            dd = q.getResultList();
            int size = dd.size();
            if (size == 0) {
                nul = null;//return true if list is empty
            } else {
                nul = dd.get(0);//return false if there is a addition to the list
            }
        } catch (javax.ejb.EJBException e) {
            nul = null;//return true if catch ejb exception -posible when can find data in the data base

        }
        return nul;
    }

    public boolean isTimeLine(int id, int qNumber) {
        List<TimeSlots> ob;
        boolean nul;

        try {
            // Query q= em.createNamedQuery(queries[qNumber]);
            //     q.setParameter(userIds[qNumber],id); 
            //     ob = q.getResultList();
            Query q = em.createNamedQuery(queries[qNumber]);
            q.setParameter(userIds[qNumber], id);
            ob = q.getResultList();

            int size = ob.size();
            if (size == 0) {
                nul = true;//return true if list is empty
            } else {
                nul = false;//return false if there is a addition to the list
            }
        } catch (javax.ejb.EJBException e) {
            nul = true;//return true if catch ejb exception -posible when can find data in the data base

        }
        if (qNumber == 8)//always return true if its about random//random can have multiple inputs for same user on a same date
        {
            nul = true;
        }

        return nul;
    }

    public void addSingleLineResult(TimeSlots o, Diarydates d, String type) {

        DiaryFactory dFactory = new DiaryFactory();

        TimeSlots oob = dFactory.getTimeSlots(type);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        if (type.equalsIgnoreCase("rSL"))//only in case values for a random input has been made,Random table has unique id
        {
            Query q = em.createNamedQuery("Random.getHighestRandomID");
            int id = (int) q.getSingleResult() + 1;
            oob.setRandomId(id);
        }
        oob.setUserDateId(d.getDiarydateId());
        oob.setInsulin(o.getInsulin());
        oob.setSugar(o.getSugar());
        oob.setTime(dateFormat.format(date));

        em.persist(oob);

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
