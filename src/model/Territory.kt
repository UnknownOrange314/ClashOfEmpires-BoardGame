package model

class Territory(){

    var troops = ArrayList<Troop>();
    var borders = HashSet<Territory>();

    var owner:Player
        get() = owner
        set(player) {
            owner = player
        }
    fun getNumTroops():Int {
        return troops.size;
    }

    fun addTroop(troop: Troop) {
        troops.add(troop);
    }

    fun removeTroop() {
        if (!troops.isEmpty()) {
            troops.removeAt(troops.size - 1);
        }
    }

    fun addBorder(territory: Territory) {
        borders.add(territory);
    }

    fun isBorder(territory: Territory): Boolean {
        return borders.contains(territory);
    }

    fun numBorders(): Int {
        return borders.size;
    }


}

