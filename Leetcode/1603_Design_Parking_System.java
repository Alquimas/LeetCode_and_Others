class ParkingSystem {
    int[] carType = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        this.carType[0] = big;
        this.carType[1] = medium;
        this.carType[2] = small;
    }
    
    public boolean addCar(int car) {
        if(this.carType[car-1] == 0)
        {
            return false;
        }
        else
        {
            this.carType[car-1]--;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
