package test.com.swordsdragon;

import com.swordsdragons.characters.GameCharacter;
import com.swordsdragons.equip.Weapon;
import com.swordsdragons.heros.Hero;
import com.swordsdragons.items.Potion;
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

        System.out.println(hero);
    }


    @Test
    public void printHeroItems() {
        Hero hero = new Hero();
        hero.setName("Heroe 1");
        hero.setMaxHP(75);
        hero.setHp(75);
        hero.addPXs(9000);
        hero.setAttack(30);
        hero.setWeapon(new Weapon(20));

        Potion potion1 = new Potion();
        potion1.setHp(20);
        Potion potion2 = new Potion();
        potion2.setHp(15);
        Potion potion3 = new Potion();
        potion3.setHp(50);

        hero.addItem(potion1);
        hero.addItem(potion2);
        hero.addItem(potion3);

        System.out.println(hero);
    }
}
