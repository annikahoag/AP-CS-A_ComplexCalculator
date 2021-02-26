
public class ComplexNumber implements Number  {

	//instance variables
	private double real1, imag1, real2, imag2;
	public double realFinal, imagFinal;
	private boolean hasZeroR=false, hasZeroI=false;
	
	//constructor
	public ComplexNumber(double r1, double i1, double r2, double i2) {
		this.real1=r1;
		this.imag1=i1;
		this.real2=r2;
		this.imag2=i2;
	}
	
	
	//constructor 
	public ComplexNumber (double r, double i, boolean zR, boolean zI) {
		this.realFinal = r;
		this.imagFinal = i;
		this.hasZeroR = zR;
		this.hasZeroI = zI;
	}
	
	
	//add method
	public ComplexNumber add(Number n) {
		
		realFinal = real1 + real2;
		imagFinal = imag1 + imag2;
		
		this.findZeros();
		ComplexNumber com = new ComplexNumber(realFinal, imagFinal, hasZeroR, hasZeroI); 
		return com;

	}
	
		
		
	//subtract method
	public ComplexNumber subtract(Number n) {
		
		realFinal = real1 - real2;
		imagFinal = imag1 - imag2;
		
		this.findZeros();
		
		ComplexNumber com = new ComplexNumber(realFinal, imagFinal, hasZeroR, hasZeroI);
		return com;
	}
		
		
	//multiply method
	public ComplexNumber multiply(Number n) {
		double term1, term2, term3, term4;
		
		term1 = real1 * real2;
		term2 = real1 * imag2;
		term3 = imag1 * real2;
		term4 = (imag1 * imag2) * -1;
		
		realFinal = term1 + term4;
		imagFinal = term2 + term3;
		
		this.findZeros();
		ComplexNumber com = new ComplexNumber(realFinal, imagFinal, hasZeroR, hasZeroI); 
		return com;
	}
		
		
	//divide method
	public ComplexNumber divide(Number n) {
		double conjugateReal, conjugateImag;
		double t1, t2, t3, t4;
		double numReal, numImag, denReal, denImag;
		
		conjugateReal = real2;
		conjugateImag = imag2 * -1;
		
		//numerator
		t1 = real1 * conjugateReal;
		t2 = real1 * conjugateImag;
		t3 = imag1 * conjugateReal;
		t4 = (imag1 * conjugateImag) * -1;
		
		numReal = t1 + t4;
		numImag = t2 + t3;
		
		//denominator
		t1 = real2 * conjugateReal;
		t2 = real2 * conjugateImag;
		t3 = imag2 * conjugateReal;
		t4 = (imag2 * conjugateImag) * -1;
		
		denReal = t1 + t4;
		denImag = t2 + t3;
		
		//final division
		if (numReal == 0) {
			imagFinal = numImag / denReal;
		}else {
			realFinal = numReal / denReal;
			imagFinal = numImag / denReal;
		}
		
		
		this.findZeros();
		ComplexNumber com = new ComplexNumber(realFinal, imagFinal, hasZeroR, hasZeroI); 
		return com;
	}
	
	
	//find coefficients of zero, don't print that portion if true 
	private void findZeros() {
		
		if (realFinal == 0) {
			hasZeroR = true;
		} if (imagFinal == 0) {
			hasZeroI = true;
		}
		
	}
	
	//print method
	public void print() {
	
		if (!hasZeroR) {
			System.out.print(realFinal);
			if (imagFinal > 0 ) {
				System.out.print(" + " + imagFinal + "i");
			}else if (imagFinal < 0){
				imagFinal = imagFinal * -1;
				System.out.println(" - " + imagFinal + "i");
			}
			
		}else {
			if (imagFinal > 0 || imagFinal < 0) {
				System.out.print(imagFinal + "i");
			}else {
				System.out.println("0");
			}
		}
		
	}
	
}//end of class
