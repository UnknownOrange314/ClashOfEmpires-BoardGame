package test.model

import model.Territory
import model.Troop
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class TerritoryTest {

    val MockTroop:Troop = Troop();

    fun setup(): Territory {
        return Territory();
    }

    @Test
    fun testAddTroop() {
        val territory = setup();
        territory.addTroop(Troop.createTroop())
        assertEquals(territory.getNumTroops(), 1);
    }

}