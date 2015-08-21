package mainpackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.LoggerFactory;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/spring-application-test-context.xml"})
public class MenuDaoImplTest {
    private Logger logger = LoggerFactory.getLogger(MenuDaoImplTest.class);

    @Autowired
    protected MenuDao menuDao;

    @Test
    public void testCreateMenu() throws Exception {
        Menu menu = prepareMenu();

        Menu createdMenu = menuDao.create(menu); // TEST
        assertNotNull(createdMenu.getId());
    }

    @Test
    public void testFindById() throws Exception{

        Menu menu = menuDao.create(prepareMenu());
        Menu foundedMenu = menuDao.findById(menu.getId());
        assertEquals(menu, foundedMenu);

    }

    private Food prepareFood(String description){
        Food food = new Food();

        food.setDescription(description);
        food.setPrice(15);
        food.setTittle("aaa");
        food.setType("abc");
        return food;
    }

    private Menu prepareMenu(){
        Menu menu = new Menu();
        menu.setPrice(10);
        menu.setDay((short) 1);


        menu.addFood(prepareFood("a"));
        menu.addFood(prepareFood("b"));
        menu.addFood(prepareFood("c"));

        for(Food food : menu.getFoods()){
            food.setMenu(menu);
        }

        return menu;
    }


    public MenuDao getMenuDao() {
        return menuDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}