import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private int id;
    private int capacity;
    private boolean isAvailable;
    private long availableUntil;

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.isAvailable = true;
        this.availableUntil = 0;
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void reserve(long duration) {
        this.isAvailable = false;
        this.availableUntil = System.currentTimeMillis() + duration;
    }

    public long getAvailableUntil() {
        return this.availableUntil;
    }

    public void makeAvailable() {
        this.isAvailable = true;
        this.availableUntil = 0;
    }
}



public class TableManager {
    private List<Table> tables;

    public TableManager() {
        this.tables = new ArrayList<>();
        // initialize tables with ids and capacities
        this.tables.add(new Table(1, 4));
        this.tables.add(new Table(2, 6));
        this.tables.add(new Table(3, 8));
        // add more tables as needed
    }

    public List<Table> getAvailableTables() {
        
    }

    public Table reserveTable(int numPeople, long duration) {
        List<Table> availableTables = getAvailableTables();
        for (Table table : availableTables) {
            if (table.getCapacity() >= numPeople) {
                table.reserve(duration);
                return table;
            }
        }
        return null; // no available table with enough capacity
    }


    public void makeTableAvailable(Table table) {
        table.makeAvailable();
    }
}

