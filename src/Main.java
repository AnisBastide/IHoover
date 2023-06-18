import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Hello, what is the x length of the room?");
        int roomX = Integer.parseInt(reader.readLine());
        System.out.println("What is the y length of the room?");
        int roomY = Integer.parseInt(reader.readLine());

        System.out.println("What is the position x of the hoover?");
        int hooverX = Integer.parseInt(reader.readLine());
        System.out.println("What is the position y of the hoover?");
        int hooverY = Integer.parseInt(reader.readLine());
        System.out.println("What is the direction of the hoover? (N,E,W,S)");
        Direction hooverDirection = Direction.valueOf(reader.readLine());

        Hoover hoover = new Hoover(hooverX,hooverY,hooverDirection,roomY,roomX);
        System.out.println(hoover.positionX);
        System.out.println(hoover.positionY);
        System.out.println(hoover.direction);
        System.out.println(hoover.roomXSize);
        System.out.println(hoover.roomYSize);

        System.out.println("What are your instructions? (D,G,A)");
        String instructions = reader.readLine();

        for (int i = 0; i < instructions.length(); i++) {
            char letter = instructions.charAt(i);
            if(letter == 'A'){
                hoover.forward();
            } else if (letter == 'G')
            {
            hoover.rotate(RotationDirection.G);
            }
            else if (letter == 'D')
            {
                hoover.rotate(RotationDirection.D);
            }
        }

        System.out.println(hoover.positionX);
        System.out.println(hoover.positionY);
        System.out.println(hoover.direction);
        System.out.println(hoover.roomXSize);
        System.out.println(hoover.roomYSize);
    }
}