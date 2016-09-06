package test.com.swordsdragon;

import com.swordsdragons.characters.GameCharacter;
import com.swordsdragons.potions.Potion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by link on 28/07/16.
 */
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
    public void drinkPotion() {
        Potion potion = new Potion();
        potion.setHp(20);

        GameCharacter p1 = new GameCharacter();
        p1.setMaxHP(50);
        p1.setHp(50);

        potion.drink(p1);

        assertEquals(p1.getHP(), 50);

        p1.setHp(45);

        potion.drink(p1);

        assertEquals(p1.getHP(), 50);


    }


}
