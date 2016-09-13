package test.com.swordsdragon;

import com.swordsdragons.characters.GameCharacter;
import com.swordsdragons.items.Lazaro;
import com.swordsdragons.items.Potion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
public class LazaroTest {


    @Test
    public void reviveTest() {
        GameCharacter gameCharacter = new GameCharacter();
        gameCharacter.setMaxHP(10);
        gameCharacter.setHp(-1);

        assertFalse(gameCharacter.isAlive());

        Lazaro lazaro = new Lazaro();

        lazaro.use(gameCharacter);

        assertTrue(gameCharacter.isAlive());
        assertEquals(gameCharacter.getHP(), 5);

    }



    @Test
    public void healTest() {
        GameCharacter gameCharacter = new GameCharacter();
        gameCharacter.setMaxHP(25);
        gameCharacter.setHp(-1);

        assertFalse(gameCharacter.isAlive());

        Lazaro lazaro = new Lazaro();

        lazaro.use(gameCharacter);

        assertTrue(gameCharacter.isAlive());
        assertEquals(gameCharacter.getHP(), 13);

        gameCharacter.setHp(20);
        lazaro.use(gameCharacter);
        assertEquals(gameCharacter.getHP(), 20);



    }

}
