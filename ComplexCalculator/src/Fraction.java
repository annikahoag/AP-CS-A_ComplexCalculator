
public class Fraction implements Number{

	//instance variables
	private int num1, den1, num2, den2;
	public int numFinal, denFinal;
	public int comDen;
	private boolean isNeg;
	private int numReal1, denReal1, numImag1, denImag1, numReal2, denReal2, numImag2, denImag2;
	private int numRealFinal, denRealFinal, numImagFinal, denImagFinal;
	private boolean isComplex, isReal, isNegR, isNegI;
	
	//constructor 
	public Fraction(int n1, int d1, int n2, int d2) {
		this.num1=n1;
		this.den1=d1;
		this.num2=n2;
		this.den2=d2;
		isComplex=false;
	}
	
	
	//constructor 
	public Fraction (int n, int d) {
		this.numFinal = n;
		this.denFinal = d;
	}
	
	//EXTRA CREDIT- third constructor to do operations with fractions in complex numbers 
	public Fraction (int nR1, int dR1, int nI1, int dI1, int nR2, int dR2, int nI2, int dI2) {
		this.numReal1=nR1;
		this.denReal1=dR1;
		this.numImag1=nI1;
		this.denImag1=dI1;
		this.numReal2=nR2;
		this.denReal2=dR2;
		this.numImag2=nI2;
		this.denImag2=dI2;
		isComplex=true;
	}
	
	
	//EXTRA CREDIT constructor
	public Fraction (int nR, int nI, int dR, int dI, boolean negR, boolean negI) {
		this.numRealFinal = nR;
		this.numImagFinal = nI;
		this.denRealFinal = dR;
		this.denImagFinal = dI;
		this.isNegR = negR;
		this.isNegI = negI;
	}
	
	
	//add method
	public Fraction add (Number n) {
		
		if (isComplex) {
			this.addC();
			Fraction frac = new Fraction(numRealFinal, numImagFinal, denRealFinal, denImagFinal, isNegR, isNegI);
			return frac;
		}else {
			this.addF(num1, den1, num2, den2);
			Fraction frac = new Fraction(numFinal, denFinal);
			return frac;
		}
	}
	
	
	//adding fractions
	private void addF(int n1, int d1, int n2, int d2) {
		
		if (d1 == d2) {
			numFinal = n1 + n2;
			denFinal = d1;
			
		}else {
			comDen = d1 * d2;
			n1 = n1 * d2;
			n2 = n2 * d1;
			d1 = comDen;
			
			numFinal = n1 + n2;
			denFinal = d1;
			
		}
		
		this.findNeg();
		
		this.reduceFraction();
		
	}
	
	
	//EXTRA CREDIT- add complex numbers containing fractions
	private void addC() {
		
		//real portion
		isReal = true;
		if (denReal1 == denReal2) {
			numRealFinal = numReal1 + numReal2;
			denRealFinal = denReal1;
		}else {
			comDen = denReal1 * denReal2;
			numReal1 = numReal1 * denReal2;
			numReal2 = numReal2 * denReal1;
			denReal1 = comDen;
			
			numRealFinal = numReal1 + numReal2;
			denRealFinal = denReal1;
		}
		
		this.findNegCom(numRealFinal, denRealFinal);
		if (isNegR) {
			numFinal = 0;
			denFinal = 0;
		}
		
		this.reduceFractionCom(numRealFinal, denRealFinal);
		numFinal = 0;
		denFinal = 0;
		
		//imaginary portion
		isReal = false;
		if (denImag1 == denImag2) {
			numImagFinal = numImag1 + numImag2;
			denImagFinal = denImag1;
		}else {
			comDen = denImag1 * denImag2;
			numImag1 = numImag1 * denImag2;
			numImag2 = numImag2 * denImag1;
			denImag1 = comDen;
			
			numImagFinal = numImag1 + numImag2;
			denImagFinal = denImag1;
		}
		this.findNegCom(numImagFinal, denImagFinal);
		if (isNegI) {
			numFinal = 0;
			denFinal = 0;
		
		}
		
		this.reduceFractionCom(numImagFinal, denImagFinal);
		numFinal = 0;
		denFinal = 0;
	
	}
	
	
	//subtract method 
	public Fraction subtract (Number n) {
		
		if (isComplex) {
			this.subtractC();
			Fraction frac = new Fraction(numRealFinal, numImagFinal, denRealFinal, denImagFinal, isNegR, isNegI);
			return frac;
		}else {
			this.subtractF();
			Fraction frac = new Fraction(numFinal, denFinal);
			return frac;
		}
	}
	
	
	//subtracting fractions 
	private void subtractF() {
		
		if (den1 == den2) {
			numFinal = num1 - num2;
			denFinal = den1;
			
		}else {
			comDen = den1 * den2;
			num1 = num1 * den2;
			num2 = num2 * den1;
			den1 = comDen;
			
			numFinal = num1 - num2;
			denFinal = den1;
			
		}
		//make fraction with answer
		
		this.findNeg();
		
		this.reduceFraction();
		
	}
	
	
	//EXTRA CREDIT- subtract complex numbers containing fraction
	private void subtractC() {
		
		//real portion
		isReal = true;
		if (denReal1 == denReal2) {
			numRealFinal = numReal1 - numReal2;
			denRealFinal = denReal1;
		}else {
			comDen = denReal1 * denReal2;
			numReal1 = numReal1 * denReal2;
			numReal2 = numReal2 * denReal1;
			denReal1 = comDen;
					
			numRealFinal = numReal1 - numReal2;
			denRealFinal = denReal1;
		}
				
		this.findNegCom(numRealFinal, denRealFinal);
		if (isNegR) {
			numFinal = 0;
			denFinal = 0;
		}
				
		this.reduceFractionCom(numRealFinal, denRealFinal);
		numFinal = 0;
		denFinal = 0;
				
		
		//imaginary portion
		isReal = false;
		if (denImag1 == denImag2) {
			numImagFinal = numImag1 - numImag2;
			denImagFinal = denImag1;
		}else {
			comDen = denImag1 * denImag2;
			numImag1 = numImag1 * denImag2;
			numImag2 = numImag2 * denImag1;
			denImag1 = comDen;
					
			numImagFinal = numImag1 - numImag2;
			denImagFinal = denImag1;
		}
		
		this.findNegCom(numImagFinal, denImagFinal);
			if (isNegI) {
				numFinal = 0;
				denFinal = 0;	
			}
				
			this.reduceFractionCom(numImagFinal, denImagFinal);
			numFinal = 0;
			denFinal = 0;
			
	}
	
	
	
	//multiply method
	public Fraction multiply(Number n) {
		
		if (isComplex) {
			this.multiplyC();
			Fraction frac = new Fraction(numRealFinal, numImagFinal, denRealFinal, denImagFinal, isNegR, isNegI);
			return frac;
		}else {
			this.multiplyF();
			Fraction frac = new Fraction(numFinal, denFinal);
			return frac;
		}
		
		
	}
	
	//multiplying fractions 
	private void multiplyF () {
		numFinal = num1 * num2;
		denFinal = den1 * den2;
		
		this.findNeg();
		
		this.reduceFraction();
	}
	
	
	//EXTRA CREDIT- multiply complex numbers containing fractions 
	private void multiplyC() {
		int t1Num, t1Den, t2Num, t2Den, t3Num, t3Den, t4Num, t4Den;
		
		//foiling 
		t1Num = numReal1 * numReal2;
		t1Den = denReal1 * denReal2;
		t2Num = numReal1 * numImag2;
		t2Den = denReal1 * denImag2;
		t3Num = numImag1 * numReal2;
		t3Den = denImag1 * denReal2;
		t4Num = (numImag1 * numImag2) * -1;
		t4Den = denImag1 * denImag2;
		
		
		//combining like terms:
		
		//real terms
		isReal = true;
		if (t1Den == t4Den) {
			numRealFinal = t1Num + t4Num;
			denRealFinal = t1Den;
		}else {
			comDen = t1Den * t4Den;
			t1Num = t1Num * t4Den;
			t4Num = t4Num * t1Den;
			t1Den = comDen;
					
			numRealFinal = t1Num + t4Num;
			denRealFinal = t1Den;
		}
		this.findNegCom(numRealFinal, denRealFinal);
		if (isNegR) {
			numFinal = 0;
			denFinal = 0;
		}
		
		this.reduceFractionCom(numRealFinal, denRealFinal);
		numFinal = 0;
		denFinal = 0;
		
		//imaginary terms
		isReal = false;
		if (t2Den == t3Den) {
			numImagFinal = t2Num + t4Num;
			denImagFinal = t2Den;
		}else {
			comDen = t2Den * t3Den;
			t2Num = t2Num * t3Den;
			t3Num = t3Num * t2Den;
			t2Den = comDen;
					
			numImagFinal = t2Num + t3Num;
			denImagFinal = t2Den;
		}
		
		this.findNegCom(numImagFinal, denImagFinal);
		if (isNegI) {
			numFinal = 0;
			denFinal = 0;
		}
		
		this.reduceFractionCom(numImagFinal, denImagFinal);
		numFinal = 0;
		denFinal = 0; 
	}
	
	
	//divide method
	public Fraction divide(Number n) {
		if (isComplex) {
			this.divideC();
			Fraction frac = new Fraction(numRealFinal, numImagFinal, denRealFinal, denImagFinal, isNegR, isNegI);
			return frac;
		}else {
			this.divideF();
			Fraction frac = new Fraction(numFinal, denFinal);
			return frac;
		}
	}
	
	//dividing
	private void divideF() {
		int numTemp=num2; 
		
		num2 = den2;
		den2 = numTemp;
		
		numFinal = num1 * num2;
		denFinal = den1 * den2;
		
		this.findNeg();
		
		this.reduceFraction();
	}
	
	//EXTRA CREDIT- divide complex numbers containing fractions
	private void divideC() {
		int numRealCon, denRealCon, numImagCon, denImagCon;
		int term1NumN, term1DenN, term2NumN, term2DenN, term3NumN, term3DenN, term4NumN, term4DenN;
		int term1NumD, term1DenD, term2NumD, term2DenD, term3NumD, term3DenD, term4NumD, term4DenD;
		int numRealFinalN, denRealFinalN, numImagFinalN, denImagFinalN;
		int numRealFinalD, denRealFinalD, numImagFinalD, denImagFinalD;
		
		//complex conjugate 
		numRealCon = numReal2;
		denRealCon = denReal2;
		numImagCon = numImag2 * -1;
		denImagCon = denImag2;
		
		//foiling first number and conjugate numerator
		term1NumN = numReal1 * numRealCon;
		term1DenN = denReal1 * denRealCon;
		term2NumN = numReal1 * numImagCon;
		term2DenN = denReal1 * denImagCon;
		term3NumN = numImag1 * numRealCon;
		term3DenN = denImag1 * denRealCon;
		term4NumN = numImag1 * numImagCon;
		term4DenN = (denImag1 * denImagCon) * -1;

		
		//foiling second number and conjugate denominator
		term1NumD = numReal2 * numRealCon;
		term1DenD = denReal2 * denRealCon;
		term2NumD = numReal2 * numImagCon;
		term2DenD = denReal2 * denImagCon;
		term3NumD = numImag2 * numRealCon;
		term3DenD = denImag2 * denRealCon;
		term4NumD = numImag2 * numImagCon;
		term4DenD = (denImag2 * denImagCon) * -1;
		
		
		//combining real terms in numerator
		isReal = true;
		if (term1DenN == term4DenN) {
			numRealFinalN = term1NumN + term4NumN;
			denRealFinalN = term1DenN;
		}else {
			comDen = term1DenN * term4DenN;
			term1NumN = term1NumN * term4DenN;
			term4NumN = term4NumN * term1DenN;
			term1DenN = comDen;
					
			numRealFinalN = term1NumN + term4NumN;
			denRealFinalN = term1DenN;
		}
		this.findNegCom(numRealFinalN, denRealFinalN);
		if (isNegR) {
			numFinal = 0;
			denFinal = 0;
		}
		this.reduceFractionCom(numRealFinalN, denRealFinalN);
		numFinal = 0;
		denFinal = 0; 
		
		
		//combining imaginary terms in numerator
		isReal = false;
		if (term2DenN == term3DenN) {
			numImagFinalN = term2NumN + term3NumN;
			denImagFinalN = term2DenN;
		}else {
			comDen = term2DenN * term3DenN;
			term2NumN = term2NumN * term3DenN;
			term3NumN = term3NumN * term2DenN;
			term2DenN = comDen;
					
			numImagFinalN = term2NumN + term3NumN;
			denImagFinalN = term2DenN;
		}
		this.findNegCom(numImagFinalN, denImagFinalN);
		if (isNegI) {
			numFinal = 0;
			denFinal = 0;
		}
		this.reduceFractionCom(numImagFinalN, denImagFinalN);
		numFinal = 0;
		denFinal = 0; 
		
		//combining real terms in denominator
		isReal = true;
		if (term1DenD == term4DenD) {
			numRealFinalD = term1NumD + term4NumD;
			denRealFinalD = term1DenD;
		}else {
			comDen = term1DenD * term4DenD;
			term1NumD = term1NumD * term4DenD;
			term4NumD = term4NumD * term1DenD;
			term1DenD = comDen;
					
			numRealFinalD = term1NumD + term4NumD;
			denRealFinalD = term1DenD;
		}
		this.findNegCom(numRealFinalD, denRealFinalD);
		if (isNegR) {
			numFinal = 0;
			denFinal = 0;
		}
		this.reduceFractionCom(numRealFinalD, denRealFinalD);
		numFinal = 0;
		denFinal = 0; 
		
		
		//combining imaginary terms in denominator
		isReal = false;
		if (term2DenD == term3DenD) {
			numImagFinalD = term2NumD + term3NumD;
			denImagFinalD = term2DenD;
		}else {
			comDen = term2DenD * term3DenD;
			term2NumD = term2NumD * term3DenD;
			term3NumD = term3NumD * term2DenD;
			term2DenD = comDen;
					
			numImagFinalD = term2NumD + term3NumD;
			denImagFinalD = term2DenD;
		}
		this.findNegCom(numImagFinalD, denImagFinalD);
		if (isNegI) {
			numFinal = 0;
			denFinal = 0;
		}
		this.reduceFractionCom(numImagFinalD, denImagFinalD);
		numFinal = 0;
		denFinal = 0; 
		
		
		//error check for division by 0
		if (numRealFinalD != 0) {
			//create reciprocal
			int numRealTemp = numRealFinalD;
			
			numRealFinalD = denRealFinalD;
			denRealFinalD = numRealTemp;
			
			
			//multiply 
			isReal = true;
			numRealFinal = numRealFinalN * numRealFinalD;
			denRealFinal = denRealFinalN * denRealFinalD;
			
			this.findNegCom(numRealFinal, denRealFinal);
			if (isNegR) {
				numFinal = 0;
				denFinal = 0;
			}
			this.reduceFractionCom(numRealFinal, denRealFinal);
			numFinal = 0;
			denFinal = 0; 
			
			
			
			isReal=false;
			numImagFinal = numImagFinalN * numRealFinalD;
			denImagFinal = denImagFinalN * denRealFinalD;
			
			this.findNegCom(numImagFinal, denImagFinal);
			if (isNegI) {
				numFinal = 0;
				denFinal = 0;
			}
			this.reduceFractionCom(numImagFinal, denImagFinal);
			numFinal = 0;
			denFinal = 0; 
		
			
			
		}
		
	}
	
	//reduce fraction
	private void reduceFraction() {
		int smallest;
		int gcf;
		
		
		smallest = this.smallest();
		gcf = smallest;

		if ( (gcf<=numFinal) && (gcf<=denFinal) ) {
			for (int i = smallest; i>=1; i--) {
				gcf = i;
				if ( (numFinal % gcf == 0) && (denFinal % gcf == 0) ) {
					gcf = i;
					break;
				}else{
					gcf = i;
				}
			}
			
			try {
				numFinal = numFinal / gcf;
				denFinal = denFinal / gcf;
				
			}catch (ArithmeticException e) {
				numFinal = 0;
			}
			
		}
		
	}
	
	
	//find smallest
	private int smallest() {
		
		if (numFinal > denFinal) {
			return denFinal;
		}else {
			return numFinal;
		}
		
	}
	
	//prints fraction
	public void print() {
		if (isNeg) {
			System.out.print("-");
		}
		
		if (denFinal == 1) {
			System.out.print(numFinal);
			
		}else if (numFinal == 0) {
			System.out.print("0");
			
		}else {
			System.out.print(numFinal + "/" + denFinal);
		}
	
		System.out.println();
	}
	
	
	//find if fraction is negative
	private void findNeg () {
		if ((numFinal < 0 || denFinal < 0) && (numFinal > 0 || denFinal > 0)) {
			isNeg = true;
			if (numFinal < 0) {
				numFinal = numFinal * -1;
			}else {
				denFinal = denFinal * -1;
			}
		}else if (numFinal < 0 && denFinal < 0) {
			isNeg = false;
			numFinal = numFinal * -1;
			denFinal = denFinal * -1;
		}else {
			isNeg = false;
		}
	}
	
	
	/*The following are similar methods that are for the extra credit:
	 * 
	 */
	
	//EXTRA CREDIT- reduces complex number fractions
	private void reduceFractionCom(int numFinal, int denFinal) {
		int smallest;
		int gcf;
		
		smallest = this.smallestCom(numFinal, denFinal);
		gcf = smallest;

		if ( (gcf<=numFinal) && (gcf<=denFinal) ) {
			for (int i = smallest; i>=1; i--) {
				gcf = i;
				if ( (numFinal % gcf == 0) && (denFinal % gcf == 0) ) {
					gcf = i;
					break;
				}else{
					gcf = i;
				}
			}
			
			try {
				numFinal = numFinal / gcf;
				denFinal = denFinal / gcf;
				 
			}catch (ArithmeticException e) {
				numFinal = 0;
			}
			
		}
		
		if (isReal) {
			numRealFinal = numFinal;
			denRealFinal = denFinal;
		}else {
			numImagFinal = numFinal;
			denImagFinal = denFinal;
		}
	}
	
	//EXTRA CREDIT - negatives for complex number fraction
	private void findNegCom (int numFinal, int denFinal) {
		if ((numFinal < 0 || denFinal < 0) && (numFinal > 0 || denFinal > 0)) {
			isNeg = true;
			if (numFinal < 0) {

				if (isReal) {
					numRealFinal = numFinal*-1;
					denRealFinal = denFinal;
				}else {
					numImagFinal = numFinal*-1;
					denImagFinal = denFinal;
				}
			}else {

				if (isReal) {
					numRealFinal = numFinal;
					denRealFinal = denFinal*-1;
				}else {
					numImagFinal = numFinal;
					denImagFinal = denFinal*-1;
				}
			}
		}else if (numFinal < 0 && denFinal < 0) {
			isNeg = false;
			numFinal = numFinal * -1;
			denFinal = denFinal * -1;
			if (isReal) {
				numRealFinal = numFinal;
				denRealFinal = denFinal;
			}else {
				numImagFinal = numFinal;
				denImagFinal = denFinal;
			}
		}else {
			isNeg = false;
		}
		
		if (isReal) {
			isNegR = isNeg;
		}else {
			isNegI = isNeg;
		}
	}
	
	//EXTRA Credit 
	private int smallestCom(int numFinal, int denFinal) {
		if (numFinal > denFinal) {
			return denFinal;
		}else {
			return numFinal;
		}
	}
	
	
	//EXTRA CREDIT print 
	public void printCom() {
		
		//real portion 
		if (isNegR && numRealFinal != 0) {
			System.out.print("-");
		}
		
		if (numRealFinal != 0) {
			
			if (denRealFinal == 1) {
				System.out.println(numRealFinal);
			}else {
				System.out.print(numRealFinal + "/" + denRealFinal);
			}
		}
		
		
		//imaginary portion
		if (isNegI && numImagFinal != 0) {
			System.out.print(" - ");
			if (numImagFinal<0) {
				numImagFinal = numImagFinal * -1;
			}else if (denImagFinal<0) {
				denImagFinal = denImagFinal * -1;
			}
			
		}
		
		if (numImagFinal != 0) {
			if (!isNegI && numRealFinal!=0) {
				System.out.print(" + ");
			}
			
			if (denImagFinal == 1) {
				System.out.println(numImagFinal);
			}else {
				System.out.println(numImagFinal + "/" + denImagFinal + "i");
			}
		}
		

		System.out.println();
		
	}
	

	
}//end of class
