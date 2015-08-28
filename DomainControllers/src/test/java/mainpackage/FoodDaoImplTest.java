package mainpackage;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-application-test-context.xml"})
public class FoodDaoImplTest {

    private static Logger LOGGER = LoggerFactory.getLogger(FoodDaoImplTest.class);

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static void setLOGGER(Logger LOGGER) {
        FoodDaoImplTest.LOGGER = LOGGER;
    }

    public MenuDao getMenuDao() {
        return menuDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Autowired
    protected FoodDao foodDao;

    @Autowired
    protected MenuDao menuDao;

    @Test
    public void testFindById() throws Exception{
        Food food = foodDao.create(prepareFood());
        Food foundFood = foodDao.findById(food.getId()); // TEST
        assertEquals(food, foundFood);
    }

    @Test
    public void createFood() throws InterruptedException {
        Food food = prepareFood();
//        TimeUnit.SECONDS.sleep(10000);
        Food createdFood = foodDao.create(food); // TEST

        assertNotNull(createdFood.getId());
    }

    private static Food prepareFood() {
       Food food = new Food();
        food.setDescription("nieco");
        food.setPrice(15);
        food.setTittle("aaa");
        food.setType("abc");
        return food;
    }
}