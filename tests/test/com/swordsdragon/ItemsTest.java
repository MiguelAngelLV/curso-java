package test.com.swordsdragon;


import com.swordsdragons.heros.Hero;
import com.swordsdragons.items.Item;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;


public class ItemsTest {


    @Test
    public void addItems() {
        Hero hero = new Hero();
        assertEquals(hero.getTotalItems(), 0);

        Item item = new Item();
        hero.addItem(item);
        assertEquals(hero.getTotalItems(), 1);


        Item item2 = new Item();
        hero.addItem(item2);

        assertEquals(hero.getTotalItems(), 2);
    }


    @Test
    public void addMassiveItems() {
        Hero hero = new Hero();
        assertEquals(hero.getTotalItems(), 0);
        Item items[] = new Item[100];


        for (int i = 0; i < 100; i++) {
            items[i] = new Item();
            hero.addItem(items[i]);
            assertEquals(hero.getTotalItems(), i + 1);
            assertEquals(hero.getItem(i), items[i]);
        }

    }

    @Test
    public void checkDuplicate() {
        Hero hero = new Hero();
        assertEquals(hero.getTotalItems(), 0);

        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        hero.addItem(item1);
        hero.addItem(item2);

        assertEquals(hero.getTotalItems(), 2);

        hero.addItem(item1);
        hero.addItem(item2);

        assertEquals(hero.getTotalItems(), 2);

        hero.addItem(item3);
        assertEquals(hero.getTotalItems(), 3);

    }


    @Test
    public void checkNulls() {
        Hero hero = new Hero();
        assertEquals(hero.getTotalItems(), 0);

        assertNull(hero.getItem(100));

        Item item1 = new Item();
        hero.addItem(item1);
        assertNull(hero.getItem(1));

        Item item2 = new Item();
        hero.addItem(item2);
        assertEquals(hero.getItem(1),  item2);

        assertNull(hero.getItem(-1));


    }

    @Test
    public void removeItem() {
        Hero hero = new Hero();
        assertEquals(hero.getTotalItems(), 0);

        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        hero.addItem(item1);
        hero.addItem(item2);
        hero.addItem(item3);

        assertEquals(hero.getTotalItems(), 3);

        hero.removeItem(0);
        assertEquals(hero.getTotalItems(), 2);


        hero.removeItem(1);
        assertEquals(hero.getTotalItems(), 1);

        hero.removeItem(1);
        assertEquals(hero.getTotalItems(), 1);

        hero.removeItem(0);
        assertEquals(hero.getTotalItems(), 0);


        hero.addItem(item1);
        hero.addItem(item2);
        hero.addItem(item3);

        assertEquals(hero.getTotalItems(), 3);


        hero.removeItem(item3);
        hero.removeItem(item3);
        hero.removeItem(item3);
        assertEquals(hero.getTotalItems(), 2);
        assertEquals(hero.getItem(0), item1);
        assertEquals(hero.getItem(1), item2);


        hero.removeItem(item1);
        assertEquals(hero.getTotalItems(), 1);
        assertEquals(hero.getItem(0), item2);

        assertNull(hero.getItem(1));


        hero.removeItem(item1);
        hero.removeItem(-1);

        assertEquals(hero.getTotalItems(), 1);


    }
}
