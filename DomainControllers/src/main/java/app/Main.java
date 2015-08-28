package app;

import mainpackage.VotesDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by lrelovsky on 24.08.2015.
 */
public class Main {


    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/spring-application-context.xml");
        VotesDao votesDao =  appContext.getBean(VotesDao.class);
    }



}
