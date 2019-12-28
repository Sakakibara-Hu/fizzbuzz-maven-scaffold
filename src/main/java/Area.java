public class Area {
    private int max_x;
    private int max_y;

    public int getMax_x() {
        return max_x;
    }

    public void setMax_x(int max_x) {
        this.max_x = max_x;
    }

    public int getMax_y() {
        return max_y;
    }

    public void setMax_y(int max_y) {
        this.max_y = max_y;
    }

    public Area() {
    }

    public Area(int x, int y){
        this.max_x = x;
        this.max_y = y;
    }

    public boolean containPointWithX (int x){
        return x <= this.max_x;
    }

    public boolean containPointWithY (int y){
        return y <= this.max_y;
    }
}