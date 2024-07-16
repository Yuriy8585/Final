import java.util.Calendar;
import java.util.Scanner;

public class BabyFeedingCalendar {
    private static Calendar calendar = Calendar.getInstance();
    private static String[][] feedingSchedule = new String[7][3]; // 7 days, 3 meals (breakfast, lunch, dinner)

    public static void main(String[] args) {
        initializeFeedingSchedule();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Baby Feeding Calendar");
            System.out.println("1. View Feeding Schedule");
            System.out.println("2. Add Feeding Time");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    viewFeedingSchedule();
                    break;
                case 2:
                    addFeedingTime(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeFeedingSchedule() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                feedingSchedule[i][j] = "";
            }
        }
    }

    private static void viewFeedingSchedule() {
        System.out.println("Feeding Schedule:");
        for (int i = 0; i < 7; i++) {
            System.out.print(getDayOfWeek(i) + ": ");
            for (int j = 0; j < 3; j++) {
                System.out.print(feedingSchedule[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void addFeedingTime(Scanner scanner) {
        System.out.print("Enter day (0-6, where 0 is Sunday): ");
        int day = scanner.nextInt();
        System.out.print("Enter meal (0-2, where 0 is breakfast): ");
        int meal = scanner.nextInt();
        System.out.print("Enter feeding time (HH:mm): ");
        String time = scanner.next();

        feedingSchedule[day][meal] = time;
        System.out.println("Feeding time added successfully!");
    }

    private static String getDayOfWeek(int day) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[day];
    }
}