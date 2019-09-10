package MCC_Android_180127;

interface shape {
	public double area();
}

class circle implements shape {
	int n;
	public circle(int n) {
		this.n=n;
	}
	public double area() {
		return n*n*Math.PI;
	}
}
class rectangle implements shape{
	int base;
	int height;
	public rectangle(int base,int height) {
		this.base=base;
		this.height=height;
	}
	public double area() {
		return base*height;
	}
}
public class practice_interface {

	public static void main(String[] args) {
		shape s1=new circle(4);
		System.out.println("cirecle area="+s1.area());
		shape s2=new rectangle(5, 4);
		System.out.println("rectangle area="+s2.area());

	}

}
