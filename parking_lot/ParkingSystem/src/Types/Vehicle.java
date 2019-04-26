package Types;

public class Vehicle {
	private String registraionNO;
	public Color color;
	
	public Vehicle(String regNum,String colorString) throws Exception{
		super();
		this.registraionNO=regNum;

		for (Color c : Color.values()) {

		    if(colorString.equals(c+"")) {
		    		this.color=c;
		    }
	
		}
		if(this.color==null) {
			throw new Exception("invalid color");
		}
		
	}
	public String getRegistraionNO() {
		return this.registraionNO;
	}
	public void setRegistraionNO(String registraionNO) {
		this.registraionNO = registraionNO;
	}
	public Color getColor() {
		return this.color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
