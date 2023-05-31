class UndergroundSystem {
    Map<Integer, CheckInInfo> checkIn;
    Map<String, TravelInfo> travelTime;

    public UndergroundSystem() {
        this.checkIn = new HashMap<>();
        this.travelTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo Out = checkIn.remove(id);
        String travel = Out.stationName + "," + stationName;
        int time = t - Out.checkInTime;

        if(travelTime.containsKey(travel))
        {
            TravelInfo info = travelTime.get(travel);
            info.totalTime += time;
            info.count++;
        }
        else
        {
            travelTime.put(travel, new TravelInfo(time, 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String travel = startStation + "," + endStation;
        TravelInfo info = travelTime.get(travel);
        return (double) info.totalTime / info.count;
    }

    private class CheckInInfo {
        String stationName;
        int checkInTime;

        public CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private class TravelInfo {
        int totalTime;
        int count;

        public TravelInfo(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
