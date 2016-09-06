package test.com.swordsdragon;


import com.swordsdragons.characters.GameCharacter;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CharacterTest {


    @Test
    public void createCharacters() {
        GameCharacter p1 = new GameCharacter();

        p1.setName("P1");
        p1.setAttack(20);
        p1.setMaxHP(30);
        p1.setHp(30);

        assertEquals(p1.getName(),"P1");
        assertEquals(p1.getHP(), 30);
        assertEquals(p1.getMaxHP(), 30);
        assertEquals(p1.getAttack(), 20);

        p1.setHp(31);
        assertEquals(p1.getHP(), 30);


        p1.setHp(0);
        assertEquals(p1.getHP(), 0);

        p1.setHp(-1);
        assertEquals(p1.getHP(), 0);

        p1.setHp(25);
        assertEquals(p1.getHP(), 25);

        p1.setMaxHP(20);
        assertEquals(p1.getMaxHP(), 20);
        assertEquals(p1.getHP(), 20);


        p1.setMaxHP(30);
        assertEquals(p1.getHP(), 20);


        p1.setMaxHP(-1);
        assertEquals(p1.getMaxHP(), 1);
        assertEquals(p1.getHP(), 1);


        p1.setAttack(-1);
        assertEquals(p1.getAttack(), 1);


    }


    @Test
    public void attacks() {
        GameCharacter p1 = new GameCharacter();
        p1.setName("P1");
        p1.setMaxHP(30);
        p1.setHp(30);
        p1.setAttack(10);

        GameCharacter p2 = new GameCharacter();
        p2.setName("P2");
        p2.setMaxHP(30);
        p2.setHp(30);
        p2.setAttack(11);


        assertEquals(p1.attacksToKill(p2), 3);
        assertEquals(p2.attacksToKill(p1), 3);

        assertEquals(p1.wouldWin(p2, true), true);
        assertEquals(p1.wouldWin(p2, false), false);

        assertEquals(p2.wouldWin(p1, true), true);
        assertEquals(p2.wouldWin(p1, false), false);

        p1.setAttack(5);

        assertEquals(p1.attacksToKill(p2), 6);

        assertEquals(p1.wouldWin(p2, true), false);
        assertEquals(p1.wouldWin(p2, false), false);

        p1.attack(p2);
        assertEquals(p2.getMaxHP(), 30);
        assertEquals(p2.getHP(), 25);

        assertEquals(p1.attacksToKill(p2), 5);


        p1.attack(p2); //20
        p1.attack(p2); //15

        assertEquals(p1.attacksToKill(p2), 3);

        assertEquals(p1.wouldWin(p2, true), true);
        assertEquals(p1.wouldWin(p2, false), false);

        assertEquals(p2.wouldWin(p1, true), true);
        assertEquals(p2.wouldWin(p1, false), false);

    }


    @Test
    public void testConstructor() {
        //Name, Max HP, HP, Attack
        GameCharacter p1 = new GameCharacter("P1", 50, 50, 20);

        assertEquals(p1.getHP(), 50);
        assertEquals(p1.getName(), "P1");
        assertEquals(p1.getMaxHP(), 50);
        assertEquals(p1.getAttack(), 20);

        GameCharacter p2 = new GameCharacter("P2", 0, 60, -1);
        assertEquals(p2.getHP(), 1);
        assertEquals(p2.getName(), "P2");
        assertEquals(p2.getMaxHP(), 1);
        assertEquals(p2.getAttack(), 1);
    }
}
