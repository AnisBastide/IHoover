import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Hello, what is the x length of the room?");
        String roomXString = reader.readLine();
        System.out.println("What is the y length of the room?");
        String roomYString = reader.readLine();

        System.out.println("What is the position x of the hoover?");
        String hooverXString = reader.readLine();
        System.out.println("What is the position y of the hoover?");
        String hooverYString = reader.readLine();
        boolean isPositionsInt = false;
        while (!isPositionsInt) {
            if (checkIsInt(new String[]{roomXString, roomYString, hooverXString, hooverYString})) {
                isPositionsInt = true;
            } else {
                System.out.println("One of the value was not a number, try again please.");
                System.out.println("Hello, what is the x length of the room?");
                roomXString = reader.readLine();
                System.out.println("What is the y length of the room?");
                roomYString = reader.readLine();

                System.out.println("What is the position x of the hoover?");
                hooverXString = reader.readLine();
                System.out.println("What is the position y of the hoover?");
                hooverYString = reader.readLine();
            }
        }
        int hooverX = Integer.parseInt(hooverXString);
        int hooverY = Integer.parseInt(hooverYString);
        int roomX = Integer.parseInt(roomXString);
        int roomY = Integer.parseInt(roomYString);
        System.out.println("What is the direction of the hoover? (N,E,W,S)");
        String hooverDirectionString = reader.readLine();
        boolean isDirectionOk = false;
        while (!isDirectionOk) {
            if (Objects.equals(hooverDirectionString, "N") || Objects.equals(hooverDirectionString, "S") || Objects.equals(hooverDirectionString, "W") || Objects.equals(hooverDirectionString, "E")) {
                isDirectionOk = true;
            }
            else{
                System.out.println("The direction you provided is not in the 4 possibilities");
                System.out.println("What is the direction of the hoover? (N,E,W,S)");
                hooverDirectionString = reader.readLine();
            }
        }
        Direction hooverDirection = Direction.valueOf(hooverDirectionString);

        Hoover hoover = new Hoover(hooverX, hooverY, hooverDirection, roomY, roomX);
        System.out.println(hoover.positionX);
        System.out.println(hoover.positionY);
        System.out.println(hoover.direction);
        System.out.println(hoover.roomXSize);
        System.out.println(hoover.roomYSize);

        System.out.println("What are your instructions? (D,G,A)");
        String instructions = reader.readLine();

        for (int i = 0; i < instructions.length(); i++) {
            char letter = instructions.charAt(i);
            if (letter == 'A') {
                hoover.forward();
            } else if (letter == 'G') {
                hoover.rotate(RotationDirection.G);
            } else if (letter == 'D') {
                hoover.rotate(RotationDirection.D);
            }
        }

        System.out.println(hoover.positionX);
        System.out.println(hoover.positionY);
        System.out.println(hoover.direction);
        System.out.println(hoover.roomXSize);
        System.out.println(hoover.roomYSize);
    }

    public static boolean checkIsInt(String[] userInputs) {
        try {
            for (String userInput : userInputs) {
                parseInt(userInput);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}