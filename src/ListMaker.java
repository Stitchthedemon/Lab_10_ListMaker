import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;

        do {
            System.out.println();
            System.out.println("--- Current List ---");
            if (list.size() == 0) {
                System.out.println("[The list is currently empty]");
            } else {
                for (int i = 0; i < list.size(); i++) {
                    int itemNumber = i + 1;
                    System.out.println(itemNumber + ". " + list.get(i));
                }
            }

            System.out.println("==================================");
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("I - Insert an item into the list");
            System.out.println("P - Print (display) the list");
            System.out.println("Q - Quit the program");
            System.out.println("==================================");

            String choice = SafeInput.getRegExString(in, "Enter your menu choice", "[AaDdIiPpQq]");
            choice = choice.toUpperCase();

            if (choice.equals("A")) {
                String itemToAdd = SafeInput.getNonZeroLenString(in, "Enter the item to add");
                list.add(itemToAdd);
                System.out.println("Item added successfully.");

            } else if (choice.equals("D")) {
                if (list.size() == 0) {
                    System.out.println("The list is empty. Nothing to delete.");
                } else {
                    int deleteNum = SafeInput.getRangedInt(in, "Enter the item number to delete", 1, list.size());
                    int targetIndex = deleteNum - 1;
                    String removedItem = list.remove(targetIndex);
                    System.out.println("Removed item: " + removedItem);
                }

            } else if (choice.equals("I")) {
                String itemToInsert = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
                int insertPos;

                if (list.size() == 0) {
                    insertPos = 1;
                } else {
                    insertPos = SafeInput.getRangedInt(in, "Enter the position number to insert at", 1, list.size() + 1);
                }

                int targetIndex = insertPos - 1;
                list.add(targetIndex, itemToInsert);
                System.out.println("Item inserted successfully.");

            } else if (choice.equals("P")) {
                System.out.println("Printing refreshed list view above.");

            } else if (choice.equals("Q")) {
                boolean confirmQuit = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                if (confirmQuit == true) {
                    done = true;
                }
            }

        } while (done == false);

        System.out.println("Program closed. Goodbye!");
    }
}