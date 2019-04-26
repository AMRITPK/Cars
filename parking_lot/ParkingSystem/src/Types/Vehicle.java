package Types;

public class Vehicle {
	private String registraionNO;
	private Color color;
	
	public Vehicle(String regNum,String colorString) throws Exception{
		super();
		this.registraionNO=regNum;

		for (Color c : Color.values()) {
		    System.out.println(c);
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
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
