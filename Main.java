package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean stop;
    static boolean stop2;
    static String coo = "";
    static String c = "";
    static char[] strL;
    static int kf = 1;
    static char[][] fakeField = new char[10][10];
    static char[][] field = new char[10][10];
    static String[] shipN1 = new String[4];
    static String[] shipN2 = new String[3];
    static String[] shipN3 = new String[2];
    static String[] shipN4 = new String[2];
    static String[] shipN5 = new String[1];
    static String[] shipN6 = new String[4];
    static String[] shipN7 = new String[3];
    static String[] shipN8 = new String[2];
    static String[] shipN9 = new String[2];
    static String[] shipN10 = new String[1];
    static char[][] fieldN2 = new char[10][10];
    static char[][] fakeFieldN2 = new char[10][10];
    static String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    static String numbers = "  1 2 3 4 5 6 7 8 9 10";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        main.createField();
    }
    public void createField() {
        createFakeField(field);
        createShip(5, field, shipN1);
        createShip(4, field, shipN2);
        createShip(3, field, shipN3);
        createShip(1, field, shipN4);
        createShip(2, field, shipN5);
        createFakeField(fieldN2);
        enterToCont();
        createShip(5, fieldN2, shipN6);
        createShip(4, fieldN2, shipN7);
        createShip(3, fieldN2, shipN8);
        createShip(1, fieldN2, shipN9);
        createShip(2, fieldN2, shipN10);
        createFakeField(fakeField);
        createFakeField(fakeFieldN2);
        enterToCont();
        while (kf != 0) {
            createShot(fieldN2, fakeFieldN2, 1, field, shipN6, shipN7, shipN8, shipN9, shipN10);
            enterToCont();
            createShot(field, fakeField, 2, fieldN2, shipN1, shipN2, shipN3, shipN4, shipN5);
            enterToCont();
        }

    }
    public void createShip (int len, char[][] field, String[] shipN1) {
        stop = true;
        int count = 0;
        switch (len) {
            case 5:
                System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
                break;
            case 4:
                System.out.println("Enter the coordinates of the Battleship (4 cells):");
                break;
            case 3:
                System.out.println("Enter the coordinates of the Submarine (3 cells):");
                break;
            case 1:
                len +=2;
                System.out.println("Enter the coordinates of the Cruiser (3 cells):");
                break;
            case 2:
                System.out.println("Enter the coordinates of the Destroyer (2 cells):");

        }
        while(stop) {
            coo = scanner.nextLine();
            strL = new char[coo.length()];
            c = coo.replaceAll("\\s+","");
            for (int i = 0; i < coo.length(); i++) {
                strL[i] = coo.charAt(i);
            }
            count = 0;
            for (int i = 1; i < coo.length(); i++) {
                if(coo.charAt(0) == coo.charAt(i)) {
                    count = 1;
                    horizontalShip(len, field, shipN1);
                }
            }
            if (count != 1) {
                verticalShip(len, field, shipN1);
            }
        }
    }
    public void horizontalShip(int len, char[][] field, String[] shipN1) {
        String numb1 = Character.toString(coo.charAt(1)) + Character.toString(coo.charAt(2));
        numb1 = numb1.replace(" ","");
        String numb2 = c.replace(numb1, "");
        numb2 = numb2.replaceAll(Character.toString(coo.charAt(0)), "");
        int num1 = Integer.parseInt(numb1);
        int num2 = Integer.parseInt(numb2);
        int h = num1;
        int f = num2;
        int st = (int) coo.charAt(0);
        if (num1 > num2) {
            if (num1 - num2 == len - 1) {
                int c = 0;
                for (int i = 0; i < len + 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        int p = 66;
                        int q = 0;
                        int k = 0;
                        if (num1 - i < 0) {
                            k += 1;
                        }
                        if (st - p + j - q < 0) {
                            j += 1;
                        }
                        if (num1 - i  > 9) {
                            i += 1;
                        }
                        if (st - p + j - q > 9) {
                            q += 1;
                        }
                        if (field[st - p + j - q][num1 - i + k] == 'O') {
                            c = 1;
                        }
                    }
                }
                if (c == 0) {
                    for (int i = 0; i < shipN1.length; i++) {
                        shipN1[i] = coo.charAt(0) + Integer.toString(num2 + i);
                    }
                    num1 -= 1;
                    num2 -= 1;
                    while(h != num2) {
                        field[st - 65][num1] = 'O';
                        num1--;
                        h--;

                    }
                    System.out.print(numbers);
                    for (int i = 0; i < field.length; i++) {
                        System.out.println();
                        System.out.print(letter[i] + " ");
                        for (int j = 0; j < field[i].length; j++) {
                            System.out.print(field[i][j] + " ");
                        }
                    }
                    System.out.println();
                    stop = false;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else {
                System.out.println("Error! Wrong ship location! Try again:");
            }
        } else {
            if (num2 - num1 == len - 1) {
                int c = 0;
                for (int i = 0; i < len + 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        int p = 66;
                        int q = 0;
                        int k = 0;
                        if (num2 - i < 0) {
                            k += 1;
                        }
                        if (st - p + j - q < 0) {
                            j += 1;
                        }
                        if (num2 - i  > 9) {
                            i += 1;
                        }
                        if (st - p + j - q > 9) {
                            q += 1;
                        }
                        if (field[st - p + j - q][num2 - i + k] == 'O') {
                            c = 1;
                        }
                    }
                }
                if (c == 0) {
                    for (int i = 0; i < shipN1.length; i++) {
                        shipN1[i] = coo.charAt(0) + Integer.toString(num1 + i);
                    }
                    num1 -= 1;
                    num2 -= 1;
                    while(f != num1) {
                        field[st - 65][num2] = 'O';
                        num2--;
                        f--;

                    }
                    System.out.print(numbers);
                    for (int i = 0; i < field.length; i++) {
                        System.out.println();
                        System.out.print(letter[i] + " ");
                        for (int j = 0; j < field[i].length; j++) {
                            System.out.print(field[i][j] + " ");
                        }
                    }
                    System.out.println();
                    stop = false;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else {
                System.out.println("Error! Wrong ship location! Try again:");
            }
        }

    }
    public void verticalShip(int len, char[][] field, String[] shipN1) throws ArrayIndexOutOfBoundsException{
        char n = '0';
        for(int i = 1; i < strL.length; i++) {
            for (int j = 0; j < letter.length; j++) {
                if (Character.toString(strL[i]).equals(letter[j])) {
                    n = strL[i];
                }
            }
        }
        char k = strL[0];
        int num1 = strL[0];
        int num2 = n;
        int h = num1;
        int u = num2;
        double sum = 0;
        String c1 = c.replace(String.valueOf(n), "");
        String c2 = c1.replace(String.valueOf(k), "");
        if (c2.equals("1010")) {
            sum = 20;
        } else {
            for (int i = 0; i < c2.length(); i++) {
                sum += Integer.parseInt(String.valueOf(c2.charAt(i)));
            }
        }
        if(num1 > num2) {
            if (num1 - num2 == len - 1) {
                if (sum / 2 == Integer.parseInt(String.valueOf(c2.charAt(0))) || c2.equals("1010")) {
                    int c = 0;
                    for (int i = 0; i < len + 2; i++) {
                        for (int j = 0; j < 3; j++) {
                            int p = 64;
                            int q = 2;
                            if (num1 - p - i < 0) {
                                p -= 1;
                            }
                            if ((int) (sum / 2) - q + j < 0) {
                                j += 1;
                            }
                            if (num1 - p - i > 9) {
                                p += 1;
                            }
                            if ((int) (sum / 2) - q + j > 9) {
                                q += 1;
                            }
                            if (field[num1 - p - i][(int) (sum / 2) - q + j] == 'O') {
                                c = 1;
                            }
                        }
                    }
                    if (c == 0) {
                        for (int i = 0; i < shipN1.length; i++) {
                            shipN1[i] = Character.toString(n + i) + (int) sum;
                        }
                        System.out.print(numbers);
                        for (int i = 0; i < field.length; i++) {
                            System.out.println();
                            System.out.print(letter[i] + " ");
                            for (int j = 0; j < field[i].length; j++) {
                                if (num2 <= h) {
                                    field[num1 - 65][(int) (sum / 2) - 1] = 'O';
                                    num1--;
                                    h--;
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 0) {
                                        field[0][0] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 1) {
                                        field[0][1] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 2) {
                                        field[0][2] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 3) {
                                        field[0][3] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 4) {
                                        field[0][4] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 5) {
                                        field[0][5] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 6) {
                                        field[0][6] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 7) {
                                        field[0][7] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 8) {
                                        field[0][8] = 'O';
                                    }
                                    if (num2 == 65 && (int) (sum / 2) - 1 == 9) {
                                        field[0][9] = 'O';
                                    }
                                }
                                System.out.print(field[i][j] + " ");
                            }
                        }
                        System.out.println();
                        stop = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                    }
                }
                else {
                    System.out.println("Error! Wrong ship location! Try again:");
                }
            }
             else {
                 System.out.println("Error! Wrong ship location! Try again:");
            }
        } else {
            if (num2 - num1 == len - 1) {
                temp(h, num1, num2, sum, len, c2, k, shipN1);
            }
            else {
                System.out.println("Error! Wrong ship location! Try again:");
            }
        }
    }
    public void temp (int h, int num1, int num2, double sum, int len, String c2, char n, String[] shipN1) {
        if (sum / 2 == Integer.parseInt(String.valueOf(c2.charAt(0))) || c2.equals("1010")) {
            int c = 0;
            for (int i = 0; i < len + 2; i++) {
                for (int j = 0; j < 3; j++) {
                    int p = 66;
                    int q = 2;
                    if (num1 - p + i < 0) {
                        i += 1;
                    }
                    if ((int) (sum / 2) - q + j < 0) {
                        j += 1;
                    }
                    if (num1 - p + i > 9) {
                        p += 1;
                    }
                    if ((int) (sum / 2) - q + j > 9) {
                        q += 1;
                    }
                    if (field[num1 - p + i][(int) (sum / 2) - q + j] == 'O') {
                        c = 1;
                    }
                }
            }
            if (c == 0) {
                for (int i = 0; i < shipN1.length; i++) {
                    shipN1[i] = Character.toString(n + i) + (int) sum;
                }
                System.out.print(numbers);
                for (int i = 0; i < field.length; i++) {
                    System.out.println();
                    System.out.print(letter[i] + " ");
                    for (int j = 0; j < field[i].length; j++) {
                        if (h <= num2) {
                            field[num1++ - 65][(int) (sum / 2) - 1] = 'O';
                            h++;
                        }
                        System.out.print(field[i][j] + " ");
                    }
                }
                System.out.println();
                stop = false;
            } else {
                System.out.println("Error! You placed it too close to another one. Try again:");
            }
        }
        else {
            System.out.println("Error! Wrong ship location! Try again:");
        }
    }
    public void createShot(char[][] field, char[][] fakeField, int number, char[][] fieldN2, String[] shipN1,
                           String[] shipN2, String[] shipN3, String[] shipN4, String[] shipN5) {
        fakeField(fakeField);
        System.out.println("---------------------");
        fakeField(fieldN2);
        System.out.println("Player " + number + ", it's your turn:");
        stop2 = true;
        while (stop2) {
            int count = 0;
            String shot = scanner.nextLine();
            int num1 = shot.charAt(0);
            int num2 = Integer.parseInt(shot.replace(Character.toString(shot.charAt(0)), ""));
            for (int i = 0; i < letter.length; i ++) {
                if (Character.toString(shot.charAt(0)).equals(letter[i])) {
                    count = 1;
                }
            }
            if (num2 <= 10 && num2 > 0) {
                count += 1;
            }
            if (count == 2) {
                if (field[num1 - 65][num2 - 1] == 'O') {
                    field[num1 - 65][num2 - 1] = 'X';
                    fakeField[num1 - 65][num2 - 1] = 'X';
                    checkShip(shipN1, shot);
                    checkShip(shipN2, shot);
                    checkShip(shipN3, shot);
                    checkShip(shipN4, shot);
                    checkShip(shipN5, shot);
                    System.out.println("You hit a ship!");
                    System.out.println("You sank a ship!");
                    stop2 = false;
                } else if (field[num1 - 65][num2 - 1] == 'X') {
                    checkShip(shipN1, shot);
                    checkShip(shipN2, shot);
                    checkShip(shipN3, shot);
                    checkShip(shipN4, shot);
                    checkShip(shipN5, shot);
                    System.out.println("You hit a ship!");
                    System.out.println("You sank a ship!");
                    stop2 = false;
                } else {
                    field[num1 - 65][num2 - 1] = 'M';
                    fakeField[num1 - 65][num2 - 1] = 'M';
                    System.out.println("You missed.");
                    stop2 = false;
                }
            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
            int cc = 0;
            for (int i = 0; i < field.length; i++) {;
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == 'O') {
                        cc = 1;
                    }
                }
            }
            if (cc == 0) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                kf = 0;
                stop2 = false;
            }
        }
    }

    public void field (char[][] field) {
        System.out.print(numbers);
        for (int i = 0; i < field.length; i++) {
            System.out.println();
            System.out.print(letter[i] + " ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
        }
        System.out.println();
    }
    public void fakeField (char[][] fakeField) {
        System.out.print(numbers);
        for (int i = 0; i < fakeField.length; i++) {
            System.out.println();
            System.out.print(letter[i] + " ");
            for (int j = 0; j < fakeField[i].length; j++) {
                System.out.print(fakeField[i][j] + " ");
            }
        }
        System.out.println();
    }
    public void createFakeField(char[][] fakeField) {
        System.out.print(numbers);
        for (int i = 0; i < fakeField.length; i++) {
            System.out.println();
            System.out.print(letter[i] + " ");
            for (int j = 0; j < fakeField[i].length; j++) {
                fakeField[i][j] = '~';
                System.out.print(fakeField[i][j] + " ");
            }
        }
        System.out.println();
    }
    public static void enterToCont() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%nPress Enter and pass the move to another player");
        scanner.nextLine();
    }
    public void checkShip(String[] shipN1, String shot) {
        int pc = 0;
        for (int i = 0; i < shipN1.length; i++) {
            if (shipN1[i].equals(shot)) {
                shipN1[i] = "X";
            }
            if (!shipN1[i].equals("X")) {
                pc = 1;
            }
        }
        if (pc == 0) {
            System.out.println("You sank a ship!");
            shipN1[0] = "Z1";
        }
    }
}
