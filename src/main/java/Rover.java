public class Rover {
    private int position_x;
    private int position_y;
    private Area area;
    private String forward;

    public static String WEST = "W";
    public static String EAST = "E";
    public static String NORTH = "N";
    public static String SOUTH = "S";

    public Rover() {
    }
    public void land(Area a, int x, int y, String forward){
        this.area = a;
        this.position_x = x;
        this.position_y = y;
        this.forward = forward;
        // 边界校验
        if (area.containPointWithX(x)){
            throw new IllegalArgumentException(String.format("x=%d is out of area width %d", x, area.getMax_x()));
        }
        if (area.containPointWithY(y)){
            throw new IllegalArgumentException(String.format("y=%d is out of area length %d", y, area.getMax_y()));
        }
    }

    public String getPosition(){
        return String.format("%d%d%s", position_x, position_y, forward);
    }

    public void move() {
        // 边界校验
        switch (this.forward.charAt(0)){
            case 'E': this.position_x++;break;
            case 'W': this.position_x--;break;
            case 'N': this.position_y--;break;
            case 'S': this.position_y++;break;
        }
        if (this.area.containPointWithX(this.position_x)){
            throw new IllegalArgumentException(String.format("x=%d is out of area width %d", this.position_x, this.area.getMax_x()));
        }
        if (this.area.containPointWithY(this.position_y)){
            throw new IllegalArgumentException(String.format("y=%d is out of area length %d", this.position_y, this.area.getMax_y()));
        }
    }

    public void changeForward(String turn){
        String NESW = "NESW";
        int now = NESW.indexOf(this.forward);

        if (turn.equals("L")){
            now = now - 1 < 0? NESW.length() - 1 : now - 1;
        }
        else if (turn.equals("R")){
            now = now + 1 > NESW.length() - 1? 0 : now + 1;
        }

        this.forward = String.valueOf(NESW.charAt(now));
    }
}
