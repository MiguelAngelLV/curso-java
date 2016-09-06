package test.com.swordsdragon;


import com.swordsdragons.characters.GameCharacter;
import com.swordsdragons.heros.Hero;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;

public class HeroTest {


    @Test
    public void createCharacter() {
        Hero p1 = new Hero("P1", 50, 50, 20, 1);

        assertEquals(p1.getHP(), 50);
        assertEquals(p1.getName(), "P1");
        assertEquals(p1.getMaxHP(), 50);
        assertEquals(p1.getAttack(), 20);
        assertEquals(p1.getLevel(), 1);
        assertEquals(p1.getPxToNextLevel(), 1000);
        assertEquals(p1.getPXRequiredToNextLevel(), 1000);

        assertEquals(p1 instanceof GameCharacter, true);
    }


    /**
     * Los PXs para el siguiente nivel se calcula con nivelActual^2 * 1000
     */
    @Test
    public void checkRequiredPXs() {
        Hero p1 = new Hero("P1", 50, 50, 20, 1);
        assertEquals(p1.getPxToNextLevel(), 1000);
        assertEquals(p1.getPXRequiredToNextLevel(), 1000);

        Hero p2 = new Hero("P2", 50, 50, 20, 2);
        assertEquals(p2.getPxToNextLevel(), 4000);
        assertEquals(p2.getPXRequiredToNextLevel(), 4000);


        Hero p3 = new Hero("P3", 50, 50, 20, 3);
        assertEquals(p3.getPxToNextLevel(), 9000);
        assertEquals(p3.getPXRequiredToNextLevel(), 9000);
    }



    @Test
    public void gainPX() {
        Hero p1 = new Hero("P1", 50, 50, 20, 1);
        assertEquals(p1.getPxToNextLevel(), 1000);
        assertEquals(p1.getPXRequiredToNextLevel(), 1000);

        p1.addPXs(1);

        assertEquals(p1.getPXs(), 1);
        assertEquals(p1.getPxToNextLevel(), 999);
        assertEquals(p1.getPXRequiredToNextLevel(), 1000);

        p1.addPXs(999);

        assertEquals(p1.getLevel(), 2);

        p1.addPXs(4000+9500);

        assertEquals(p1.getLevel(), 4);

        assertEquals(p1.getPXs(), 14500);

        assertEquals(p1.getPxToNextLevel(), 1500);
        assertEquals(p1.getPXRequiredToNextLevel(), 16000);
    }


}
