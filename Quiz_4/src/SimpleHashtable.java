public class SimpleHashtable {
    private StoredPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode()) % hashtable.length;
    }

    public void put(String key, Player player) {
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's already an element at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredPlayer(key, player);
        }
    }

    public Player get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) return null;
        return hashtable[hashedKey].getPlayer();
    }

    public void remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey != -1) {
            hashtable[hashedKey] = null;

            // Rehash the elements in the cluster
            StoredPlayer[] oldHashtable = hashtable;
            hashtable = new StoredPlayer[oldHashtable.length];
            for (StoredPlayer sp : oldHashtable) {
                if (sp != null) {
                    put(sp.getKey(), sp.getPlayer());
                }
            }
        }
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        int stopIndex = hashedKey;

        while (hashtable[hashedKey] != null && !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
            if (hashedKey == stopIndex) {
                return -1; // Key not found
            }
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println("Position " + i + ": " + hashtable[i].getPlayer());
            } else {
                System.out.println("Position " + i + ": empty");
            }
        }
    }
}