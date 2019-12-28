public class RoverController {
    Rover rover;

    public RoverController() {
    }

    public RoverController (Rover rover){
        this.rover = rover;
    }

    public String excute(String mission){
        String[] strs = mission.split(",");
        Area area = new Area(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        this.rover.land(area, Integer.parseInt(strs[2]), Integer.parseInt(strs[3]), strs[4]);
        for (int i = 5; i < strs.length; i++){
            excuteOneCommand(strs, i);
        }
        return this.rover.getPosition();
    }

    private void excuteOneCommand(String[] strs, int i) {
        if (strs[i].charAt(0) == 'M'){
            this.rover.move();
        }
        else{
            this.rover.changeForward(strs[i]);
        }
    }
}