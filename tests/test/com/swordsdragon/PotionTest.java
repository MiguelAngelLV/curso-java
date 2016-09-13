package test.com.swordsdragon;

import com.swordsdragons.characters.GameCharacter;
import com.swordsdragons.items.Item;
import com.swordsdragons.items.Potion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class PotionTest {


    @Test
    public void createPotion() {
        Potion potion = new Potion();
        potion.setHp(20);

        assertEquals(potion.getHp(), 20);

        potion.setHp(0);
        assertEquals(potion.getHp(), 0);

        potion.setHp(-1);

        assertEquals(potion.getHp(), 0);

        potion.setHp(101);

        assertEquals(potion.getHp(), 100);

    }

    @Test
    public void potionIsItem() {
        Potion potion = new Potion();

        assertTrue(potion instanceof Item);
    }

    @Test
    public void drinkPotion() {
        Potion potion = new Potion();
        potion.setHp(20);

        GameCharacter p1 = new GameCharacter();
        p1.setMaxHP(50);
        p1.setHp(50);

        potion.use(p1);

        assertEquals(p1.getHP(), 50);

        p1.setHp(45);

        potion.use(p1);

        assertEquals(p1.getHP(), 50);


    }

    @Test
    public void notRevive() {
        GameCharacter gameCharacter = new GameCharacter();
        gameCharacter.setMaxHP(10);
        gameCharacter.setHp(-1);

        assertFalse(gameCharacter.isAlive());

        Potion potion = new Potion();
        potion.setHp(20);

        potion.use(gameCharacter);

        assertFalse(gameCharacter.isAlive());

    }


}
