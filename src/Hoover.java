public class Hoover {
    public int positionX = 0;
    public int positionY = 0;
    public Direction direction = Direction.N;

    public int roomYSize = 0;
    public int roomXSize = 0;

    public Hoover(int positionX, int positionY, Direction direction, int roomYSize, int roomXSize) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.roomYSize = roomYSize;
        this.roomXSize = roomXSize;
    }

    public void forward(){
        switch (direction){

            case N -> {
                if(positionY!=roomYSize){
                    positionY++;
                }
            }
            case E -> {
                if(positionX!=roomXSize){
                    positionX++;
                }
            }
            case W -> {
                if(positionX!=0){
                    positionX--;
                }
            }
            case S -> {
                if(positionY!=0){
                    positionY--;
                }
            }
        }
    }

    public void rotate(RotationDirection rotationDirection){
        switch (direction){

            case N -> {
                if(rotationDirection == RotationDirection.G){
                    direction = Direction.W;
                }
                else{
                    direction = Direction.E;
                }
            }
            case E -> {
                if(rotationDirection == RotationDirection.G){
                    direction = Direction.N;
                }
                else{
                    direction = Direction.S;
                }
            }
            case W -> {
                if(rotationDirection == RotationDirection.G){
                    direction = Direction.S;
                }
                else{
                    direction = Direction.N;
                }
            }
            case S -> {
                if(rotationDirection == RotationDirection.G){
                    direction = Direction.E;
                }
                else{
                    direction = Direction.W;
                }
            }
        }
    }
}
