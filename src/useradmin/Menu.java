package useradmin;

import java.util.Scanner;

public class Menu {
    public void run() {
        Scanner input = new Scanner(System.in);
        int choose;
        User user = new User();
        while (true) {
            System.out.println("MENU:\n1. View user list\n2. Create new user\n3. Delete user\n9. Quit \n \n" +
                    "Please choose option:");

            choose = input.nextInt();

            switch (choose) {
                case 1:
                   user.viewUserList();

                    break;
                case 2:

                    user.creatNewUser();

                    break;
                case 3:
                    user.deletUser();
                    break;

                case 9:
                    System.out.println("Quite");


            }
            if (choose == 9) {
                break;
            }
        }
    }
}


