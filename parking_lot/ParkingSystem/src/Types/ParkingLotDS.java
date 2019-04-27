package Types;


public class ParkingLotDS {
	private static Car[] parkingLot;
	private  static int  size;
	ParkingLotDS(int size){
		this.size=size;
	}
	public static Car[] getParkingLotDS(){
		if (parkingLot!=null) {
			return parkingLot;
		}else {
			parkingLot= new Car[size];
		}
		return parkingLot;
	}
	public static void setSize(int size2) {
		// TODO Auto-generated method stub
		size=size2;
		parkingLot= new Car[size];
	}
	public static int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
