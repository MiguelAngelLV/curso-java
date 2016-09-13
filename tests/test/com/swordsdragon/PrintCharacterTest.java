package test.com.swordsdragon;

import com.swordsdragons.characters.GameCharacter;
import com.swordsdragons.equip.Weapon;
import com.swordsdragons.heros.Hero;
import org.junit.Test;

/**
 * Created by link on 13/09/16.
 */
public class PrintCharacterTest {

    @Test
    public void printCharacter() {
        GameCharacter character = new GameCharacter();
        character.setName("Personaje 1");
        character.setMaxHP(50);
        character.setHp(30);
        character.setAttack(20);
        System.out.println(character);
    }

    @Test
    public void printHero() {
        Hero hero = new Hero();
        hero.setName("Heroe 1");
        hero.setMaxHP(75);
        hero.setHp(75);
        hero.addPXs(9000);
        hero.setAttack(30);
        hero.setWeapon(new Weapon(20));


        System.out.println(hero);
    }
}
