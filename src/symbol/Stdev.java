package symbol;
import java.math.BigDecimal;

import parser.Token;
/**
 * @author Santisco
 * @version 1.0
 * stdev的种别码为26
 */
public class Stdev extends Token{
      
	String value;
	public Stdev()
	{
		value = "stdev";
		type = 26;
	}
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	 public String getValue()
	  {
	    return value;
	  }

	@Override
	public double get_value() {
		// TODO Auto-generated method stub
		double d = 0.0;
		return d;
	}

	@Override
	public void set_value(double t) {
		// TODO Auto-generated method stub
		t = t + 1;
	}
	
	public void set_value(BigDecimal t)
	{
		;
	}

	
}
