package mainpackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author David david.bajko@senacor.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/spring-application-test-context.xml"})
public class VotesDaoImplTest {

    @Autowired
    private VotesDao votesDao;

    @Test
    public void getVotesByUserTest(){
        User user = prepareUser();
        Restaurant restaurant = prepateRestaurant();
        Votes vote = prepareVote(user, restaurant);

        votesDao.create(vote);
        List<Object[]> resultList = votesDao.getVotesByUser(user.getId());
        assertEquals(vote.getTimeFrom(), resultList.get(0)[0]);
        assertEquals(restaurant.getTittle(), resultList.get(0)[1]);
    }

    private Votes prepareVote(User user, Restaurant restaurant){
        Votes vote = new Votes();
        vote.setAddingTime(new Date(123456789));
        vote.setTimeFrom(new Date(123456451));
        vote.setTimeTo(new Date(5165165));

        vote.setRestaurant(restaurant);
        vote.setUser(user);
        return vote;
    }

    private User prepareUser(){
        User user = new User();
        user.setAcountName("david");
        user.setPassword("1511515");
        user.setAddress("KVP");
        user.setFirstName("david");
        user.setLastName("Bajko");
        user.setEmail("david.bajko@senacor.com");
        user.setIsActive(false);
        user.setIsBanned(false);
        user.setPhoneNumber("0919284526");

        return user;
    }
    private Restaurant prepateRestaurant(){
        Restaurant restaurant = new Restaurant();
        restaurant.setTittle("U Mnicha");
        restaurant .setPhoneNumber("445515");
        restaurant.setWeb("neviem.com");
        restaurant.setAddress("Hlavna 27");
        restaurant.setEmail("email.rest@mail.com");
        restaurant.setType("prvy");
        restaurant.setDescription("desc");

        return restaurant;
    }
}