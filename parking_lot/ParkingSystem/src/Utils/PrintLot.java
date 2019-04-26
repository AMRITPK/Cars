package Utils;

import java.util.ArrayList;
import java.util.List;

import Types.Car;
import Types.ParkingLotDS;

public class PrintLot {
	private Car[]lot;
	public PrintLot(Car[] lot){
		this.lot=lot;
	}
	public void print() {
		System.out.println("Slot No. \t Registration No \t Colour");
		for (int i=0;i<this.lot.length;++i) {
			if(this.lot[i]!=null) {
				System.out.println(i+1+"\t"+this.lot[i].getRegistraionNO()+"\t"+this.lot[i].getColor());
			}
			
		}
	}
	public void print(String type, List findByColor) {
		// TODO Auto-generated method stub
		if(type=="REG") {
			int counter=1;
			for(Object o:findByColor) {
				int index=(int)o;
				Car[] lot=ParkingLotDS.getParkingLotDS();
				System.out.print(lot[index].getRegistraionNO());
				if(counter!=findByColor.size()) {
					System.out.print(",");
				}
				counter++;			
			}	
		}else if(type=="LOT") {
			int counter=1;
			for(Object o:findByColor) {
				int index=(int)o;
				System.out.print(index+1);
				if(counter!=findByColor.size()) {
					System.out.print(",");
				}
				counter++;			
			}	
		}
	}
}
