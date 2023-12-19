import javax.swing.*;

public class Driver {
    public static void main (String[] args)
    {
        Table[] tables = createTables();

       WaiterLogin login = new WaiterLogin();




    }

    //<editor-fold desc="Create Tables">
    public static Table[] createTables() {
        Table[] tables = new Table[36];
        int yellowTablesCount = 4;
        int redTablesCount = 3;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int row = i + 1;
                int col = Integer.parseInt(Character.toString("ABCDEF".charAt(j)), 16);
                int tableID = (row * row) + (col * col);
                boolean isDirty = false;
                boolean isOccupied = false;

                if ((i == 0 && (j == 2 || j == 3)) || (i == 1 && (j == 2 || j == 3)) ||
                        (i == 2 && (j == 2 || j == 3)) || (i == 3 && (j == 2 || j == 3))) {
                    if (isBarTable(tableID)) {
                        tables[i * 6 + j] = new Table(tableID, new Order(1,tableID, 0), false, false);
                    } else {
                        tableID = 0;
                        tables[i * 6 + j] = new Table(tableID, new Order(1,tableID, 0), false, false);
                    }
                } else {
                    if (yellowTablesCount > 0 && Math.random() < 0.2) {
                        isDirty = true;
                        yellowTablesCount--;
                    } else if (redTablesCount > 0 && Math.random() < 0.15) {
                        isOccupied = true;
                        redTablesCount--;
                    }
                    tables[i * 6 + j] = new Table(tableID, new Order(1,tableID, 0), isOccupied, isDirty);
                }
            }
        }

        return tables;
    }
    //</editor-fold>
    //<editor-fold desc="Method to Check if Table is a Bar Table">
    public static boolean isBarTable(int tableID) {
        int[] barTables = {197, 226, 200, 229, 205, 234, 212, 241};
        for (int id : barTables) {
            if (tableID == id) {
                return true;
            }
        }
        return false;
    }
    //</editor-fold>
}
