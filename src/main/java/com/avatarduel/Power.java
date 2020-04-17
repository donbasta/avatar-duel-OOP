public class Power{
    private int fire;
    private int water;
    private int air;
    private int earth;

    public Power(int fire, int water, int air, int earth){
        this.fire = fire;
        this.water = water;
        this.air = air;
        this.earth = earth;
    }

    public int getPower(String s){
        if (s.equals("FIRE")){
            return this.fire;
        }
        else if (s.equals("WATER")){
            return this.water;
        }
        else if (s.equals("AIR")){
            return this.air;
        }
        else if(s.equals("EARTH")){
            return this.earth;
        }
        else{
            System.out.println("errorrr input");
            return 0;
        }
    }

    public void setPower(String s, int x){
        if (s.equals("FIRE")){
            this.fire = x;
        }
        else if (s.equals("WATER")){
            this.water = x;
        }
        else if (s.equals("AIR")){
            this.air = x;
        }
        else if(s.equals("EARTH")){
            this.earth = x;
        }
        else{
            System.out.println("errorrr input");
        }
    }
}