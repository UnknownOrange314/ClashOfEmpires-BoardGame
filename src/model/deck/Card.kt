package model.deck

import model.deck.Action

class Card(cardAction: Action, combatVal: Int, combatSuit: String) {

    val action: Action = cardAction;
    val baseCombatStr = combatVal;
    val combatType = combatSuit;

    companion object {
        fun createCombatCard(cVal:Int, cSuit: String): Card {
            return Card(EmptyAction(), cVal, cSuit);
        }
    }
}