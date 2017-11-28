package test.model.deck

import model.deck.Attack
import model.deck.Card
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AttackTest {


    val DEFAULT_SUIT = "Spade";
    val SUIT_TWO = "Clubs";
    val SUIT_THREE = "Hearts";

    @Test
    fun identicalDeck_attackFails() {
        val attackDeck = ArrayList<Card>();
        val defendDeck = ArrayList<Card>();
        for (i in 1..2) {
            attackDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
            defendDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        }

        val attack = Attack(attackDeck, defendDeck);
        assertFalse(attack.attackSucceeds())
    }

    @Test
    fun testAttack_WithTwoSuits_Succeeds_AgainstOneSuit_SameNumber() {
        val attackDeck = ArrayList<Card>();
        val defendDeck = ArrayList<Card>();
        for(i in 1..2) {
            defendDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        }
        attackDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        attackDeck.add(Card.createCombatCard(1, SUIT_TWO));

        val attack = Attack(attackDeck, defendDeck);
        assertTrue(attack.attackSucceeds());
    }

    @Test
    fun testAttack_WithTwoSuits_Succeeds_AgainstOneSuit_HigherTotal() {
        val attackDeck = ArrayList<Card>();
        val defendDeck = ArrayList<Card>();
        for(i in 1..2) {
            defendDeck.add(Card.createCombatCard(3, DEFAULT_SUIT));
        }
        attackDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        attackDeck.add(Card.createCombatCard(1, SUIT_TWO));

        val attack = Attack(attackDeck, defendDeck);
        assertTrue(attack.attackSucceeds());
    }

    @Test
    fun testAttack_WithTwoNumbersInARow_Succeeds_AgainstOneNumberInARow_AndSameNumberOfSuits() {
        val attackDeck = ArrayList<Card>();
        val defendDeck = ArrayList<Card>();

        defendDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        defendDeck.add(Card.createCombatCard(1, SUIT_TWO));
        attackDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        attackDeck.add(Card.createCombatCard(2, SUIT_TWO));

        val attack = Attack(attackDeck, defendDeck);
        assertTrue(attack.attackSucceeds());
    }

    @Test
    fun testAttack_WithThreeNumbersInARow_Succeeds_AgainstTwoNumbersInARow_AndSameNumberOfSuits() {
        val attackDeck = ArrayList<Card>();
        val defendDeck = ArrayList<Card>();

        defendDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        defendDeck.add(Card.createCombatCard(1, SUIT_TWO));
        defendDeck.add(Card.createCombatCard(2, SUIT_TWO));
        attackDeck.add(Card.createCombatCard(1, DEFAULT_SUIT));
        attackDeck.add(Card.createCombatCard(2, SUIT_TWO));
        attackDeck.add(Card.createCombatCard(3, SUIT_TWO));

        val attack = Attack(attackDeck, defendDeck);
        assertTrue(attack.attackSucceeds());
    }

    @Test
    fun testAttack_WithHigherTotal_SucceedsAgainst_DefenderWithSameNumberOfSuits_AndNumbersInARow() {
        val attackDeck = ArrayList<Card>();
        val defendDeck = ArrayList<Card>();

        defendDeck.add(Card.createCombatCard(1, SUIT_TWO));
        defendDeck.add(Card.createCombatCard(2, SUIT_TWO));
        attackDeck.add(Card.createCombatCard(2, DEFAULT_SUIT));
        attackDeck.add(Card.createCombatCard(3, SUIT_TWO));

        val attack = Attack(attackDeck, defendDeck);
        assertTrue(attack.attackSucceeds());
    }
}