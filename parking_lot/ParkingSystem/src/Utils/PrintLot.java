package Utils;

import Types.Car;

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
}
