package test.com.swordsdragon;

import com.swordsdragons.characters.GameCharacter;
import com.swordsdragons.equip.Weapon;
import com.swordsdragons.heros.Hero;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WeaponTest {



    @Test
    public void createWeapon() {
        Weapon w1 = new Weapon(10);
        assertEquals(w1.getBonus(), 10);

        Weapon w2 = new Weapon(20);
        assertEquals(w2.getBonus(), 20);

        Weapon w3 = new Weapon(-1);
        assertEquals(w3.getBonus(), 1);
    }


    @Test
    public void attackWithWeapon() {
        Hero p1 = new Hero("P1", 50, 50, 20, 1);
        Hero p2 = new Hero("P2", 50, 45, 25, 1);

        assertEquals(p1.attacksToKill(p2), 3);
        assertEquals(p2.attacksToKill(p2), 2);

        Weapon weapon = new Weapon(15);
        p1.setWeapon(weapon);
        assertEquals(p1.getAttack(), 35);
        assertEquals(p1.attacksToKill(p2), 2);

        p1.setWeapon(null);
        assertEquals(p1.attacksToKill(p2), 3);


    }

}
