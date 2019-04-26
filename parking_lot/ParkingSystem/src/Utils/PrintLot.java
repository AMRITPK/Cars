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
		System.out.println("Slot No.  Registration No  Colour    ");
		for (int i=0;i<this.lot.length;++i) {
			if(this.lot[i]!=null) {
				System.out.println(Helper.fixedLengthString(""+(i+1),10)+Helper.fixedLengthString(this.lot[i].getRegistraionNO(),17)+Helper.fixedLengthString(this.lot[i].getColor()+"",17));
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
					System.out.print(", ");
				}
				counter++;			
			}	
			System.out.println("");
		}else if(type=="LOT") {
			int counter=1;
			for(Object o:findByColor) {
				int index=(int)o;
				System.out.print(index+1);
				if(counter!=findByColor.size()) {
					System.out.print(", ");
				}
				counter++;			
			}
			System.out.println("");
		}
	}
}
