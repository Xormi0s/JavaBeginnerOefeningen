package persistance;

/**
 * @author mathypaesen
 * @apiNote Dynamic Database selection
 */
public enum DatabaseEnumeration {
    DERBY ("DERBY"), MYSQL ("MYSQL"), PROPERTIES ("PROPERTIES");
    private final String name;

    DatabaseEnumeration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
