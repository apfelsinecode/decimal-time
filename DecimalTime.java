import java.time.*;
public class DecimalTime {

	public static double standardToDecimal(LocalTime t){
	double d = 0;
	long nanoS = t.toNanoOfDay();
	long totalNanos = LocalTime.MAX.toNanoOfDay() + 1;
	
	d += ( (double) nanoS / (double) totalNanos );
	d *= 10;
	
	return d;
	}
	
	public static LocalTime decimalToStandard(double d) {
		LocalTime t = LocalTime.MIDNIGHT;
		//24 * d/10
		//t = t.plusNanos((long)d);
		return t;
	}
	
	
	public static LocalTime createTime(int h, int min, int s){
		return createTime(h, min, (double) s);
	}
	
	public static LocalTime createTime(int h, int min, double s){
		LocalTime time = LocalTime.MIDNIGHT;
		time = time.plusHours((long) h);
		time = time.plusMinutes((long) min);
		time = time.plusSeconds((long) s);
				
		return time;
	}
	
	public static void main(String[] args) {
		LocalTime t = createTime(10,120,0);
		System.out.println(LocalTime.now());
		System.out.println(standardToDecimal(LocalTime.now()));
		System.out.println(standardToDecimal(LocalTime.NOON) + standardToDecimal(LocalTime.MIDNIGHT));
		System.out.println(standardToDecimal(t));
	}
}
