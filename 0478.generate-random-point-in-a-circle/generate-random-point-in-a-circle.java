class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random = new Random();
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double start_x = x_center-radius;
        double start_y = y_center-radius;
        double position_x , position_y;
        do{
            position_x = random.nextDouble()*2*radius + start_x;
            position_y = random.nextDouble()*2*radius + start_y;
        } while(Math.pow(position_x-x_center,2.0)+Math.pow(position_y-y_center,2.0) >= Math.pow(radius,2.0));
        double[] result = new double[2];
        result[0] = position_x;
        result[1] = position_y;
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */