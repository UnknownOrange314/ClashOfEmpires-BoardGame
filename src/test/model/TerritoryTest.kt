package test.model

import model.Territory
import model.Troop
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TerritoryTest {

    fun setup(): Territory {
        return Territory();
    }

    @Test
    fun testNewTerritoryHasNoTroops() {
        val territory = setup();
        assertEquals(territory.getNumTroops(), 0);
    }

    @Test
    fun testAddOneTroop_CorrectNumberOfTroops() {
        val territory = setup();
        territory.addTroop(Troop.createTroop())
        assertEquals(territory.getNumTroops(), 1);
    }

    @Test
    fun testAddMultipeTroops_CorrectNumberOfTroops() {
        val territory = setup();
        val numTroops = 100;
        for (i in 1..numTroops) {
            territory.addTroop(Troop.createTroop());
        }
        assertEquals(territory.getNumTroops(), numTroops);
    }

    @Test
    fun testAddOneTroop_AndRemoveOneTroop_EmptyTerritory() {
        val territory = setup();
        territory.addTroop(Troop.createTroop());
        territory.removeTroop();
        assertEquals(territory.getNumTroops(), 0);

    }

    @Test
    fun testRemoveTroopFromEmptyTerritory_DoesNothing() {
        val territory = setup();
        territory.removeTroop();
        assertEquals(territory.getNumTroops(), 0);
    }

    fun testNewTerritory_NoBorder() {
        val brittany = Territory();
        assertEquals(brittany.numBorders(), 0);
    }
    @Test
    fun testDistantTerritories_NoBorder() {
        val catalonia = Territory();
        val prussia = Territory();
        assertFalse(catalonia.isBorder(prussia));
    }

    @Test
    fun testAddSingleTerritoryBorder_savesBorder() {
        val madrid = Territory();
        val toledo = Territory();
        madrid.addBorder(toledo);
        toledo.addBorder(madrid);
        assertTrue(madrid.isBorder(toledo));
        assertTrue(toledo.isBorder(madrid));
    }

    @Test
    fun testAddSameBorderTwice_createsOnlyOneBorder() {
        val madrid = Territory();
        val toledo = Territory();
        madrid.addBorder(toledo);
        madrid.addBorder(toledo);
        assertEquals(madrid.numBorders(), 1);
    }
    @Test
    fun testAddMultipleTerritoryBorders_savesAllBorders() {
        val cordoba = Territory();
        val seville = Territory();
        val granada = Territory();

        cordoba.addBorder(seville);
        cordoba.addBorder(granada);

        assertTrue(cordoba.isBorder(seville));
        assertTrue(cordoba.isBorder(granada));
        assertEquals(cordoba.numBorders(), 2);
    }
}