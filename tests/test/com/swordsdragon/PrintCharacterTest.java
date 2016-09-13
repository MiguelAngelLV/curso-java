package test.com.swordsdragon;

import com.swordsdragons.characters.GameCharacter;
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
}
