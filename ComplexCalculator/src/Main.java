import java.util.Scanner;



public class Main {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		String numType;
		boolean runAgain=true;
		int num1, den1, num2, den2;
		String opType;
		double real1, imag1, real2, imag2;
		int numReal1, denReal1, numImag1, denImag1, numReal2, denReal2, numImag2, denImag2;
		
		while (runAgain) {
			System.out.println();
			scn = new Scanner (System.in);
			
			System.out.println("\nWould you like to enter a fraction or a complex number? "
					+ "\nPlease enter f for fraction, c for complex number, and m for a complex number containing fraction."
					+ "\nPlease enter x if you want to stop the program.");
			numType = scn.nextLine();
			
			if (numType.equals("f")) {
				//fraction
				try {
					System.out.println("Please enter the first fraction's numerator.");
					num1 = scn.nextInt();
					
					System.out.println("Please enter the first fraction's denominator.");
					den1 = scn.nextInt();
					
					System.out.println("Please enter the second fraction's numerator.");
					num2 = scn.nextInt();
					
					System.out.println("Please enter the second fraction's denominator.");
					den2 = scn.nextInt();
					
					
					if (den1!=0 && den2!=0) {
						Number f = new Fraction(num1, den1, num2, den2);
						Number fracAnswer;
						
						scn = new Scanner (System.in);
						System.out.println("What operation do you want to perform on the fractions."
								+ "\nPlease enter +, -, *, or /");
						opType = scn.nextLine();
						
						
						if (opType.equals("+")) {
							fracAnswer = f.add(f);
							fracAnswer.print();
							
						}else if (opType.equals("-")) {
							fracAnswer = f.subtract(f);
							fracAnswer.print();
							
						}else if (opType.equals("*")) {
							fracAnswer = f.multiply(f);
							fracAnswer.print();
							
						}else if (opType.equals("/")) {
							if (num2 ==0) {
								System.out.println("Denominators can not be equal to zero. Program is restarting.");
								runAgain=true;
							}else {
								fracAnswer = f.divide(f);
								fracAnswer.print();
								
							}
							
						}else {
							System.out.println("Please only enter the specified symbols.");
						}
						
					
					}else {
						System.out.println("Denominators can not be equal to zero. Program is restarting.");
						runAgain=true;
					}
					
				}catch (java.util.InputMismatchException e) {
					System.out.println("Please only enter numbers. Program is restarting.");
					runAgain = true;
				}
				
			}else if (numType.equals("c")) {
				//complex number 
				System.out.println("The following statements refer to a complex number in the form a+bi");
				
				try {
					System.out.println("Please enter the a of the first number.");
					real1 = scn.nextDouble();
					
					System.out.println("Please enter the b of the first number.");
					imag1 = scn.nextDouble();
					
					System.out.println("Please enter the a of the second number.");
					real2 = scn.nextDouble();
					
					System.out.println("Please enter the b of the second number.");
					imag2 = scn.nextDouble();
					
					
					ComplexNumber c = new ComplexNumber(real1, imag1, real2, imag2);
					ComplexNumber comAnswer;
						
					scn = new Scanner (System.in);
					System.out.println("What operation do you want to perform on the complex numbers."
							+ "\nPlease enter +, -, *, or /");
					opType = scn.nextLine();
						
						
					if (opType.equals("+")) {
						comAnswer = c.add(c);
						comAnswer.print();
							
					}else if (opType.equals("-")) {
						comAnswer = c.subtract(c);
						comAnswer.print();
						
					}else if (opType.equals("*")) {
						comAnswer = c.multiply(c);
						comAnswer.print();	
						
					}else if (opType.equals("/")) {
						comAnswer = c.divide(c);
						comAnswer.print();
						
					}else {
						System.out.println("Please only enter the specified symbols.");
					}
						
					
				}catch (java.util.InputMismatchException e) {
					System.out.println("Please only enter doubles or integers. Program is restarting.");
					runAgain = true;
				}
				
				
			}else if (numType.equals("m")) {
				//EXTRA CREDIT- complex number containing fractions 
				System.out.println("The following statements refer to a complex number in the form a+bi, where a and b are fractions");
				
				try {
					System.out.println("Please enter the numerator of the first a.");
					numReal1 = scn.nextInt();
					
					System.out.println("Please enter the denominator of the first a.");
					denReal1 = scn.nextInt();
					
					System.out.println("Please enter the numerator of the first b.");
					numImag1 = scn.nextInt();
					
					System.out.println("Please enter the denominator of the first b.");
					denImag1 = scn.nextInt();
					
					System.out.println("Please enter the numerator of the second a.");
					numReal2 = scn.nextInt();
					
					System.out.println("Please enter the denominator of the second a.");
					denReal2 = scn.nextInt();
					
					System.out.println("Please enter the numerator of the second b.");
					numImag2 = scn.nextInt();
					
					System.out.println("Please enter the denominator of the second b.");
					denImag2 = scn.nextInt();
					
					
					if (denReal1 != 0 && denImag1 != 0 && denReal2 != 0 && denImag2 != 0) {
						
						Fraction m = new Fraction (numReal1, denReal1, numImag1, denImag1, 
								numReal2, denReal2, numImag2, denImag2);
						Fraction fracComAnswer;
						
						scn = new Scanner (System.in);
						System.out.println("What operation do you want to perform on the complex numbers."
								+ "\nPlease enter +, -, *, or /");
						opType = scn.nextLine();
							
							
						if (opType.equals("+")) {
							fracComAnswer = m.add(m);
							fracComAnswer.printCom();
								
						}else if (opType.equals("-")) {
							fracComAnswer = m.subtract(m);
							fracComAnswer.printCom();
							
						}else if (opType.equals("*")) {
							fracComAnswer = m.multiply(m);
							fracComAnswer.printCom();
								
						}else if (opType.equals("/")) {
							fracComAnswer = m.divide(m);
							fracComAnswer.printCom();
								
						}else {
							System.out.println("Please only enter the specified symbols.");
						}
							
					}
					
				}catch (java.util.InputMismatchException e) {
					System.out.println("Please only integers. Program is restarting.");
					runAgain = true;
				}
				
				
			}else if (numType.equals("x")) {
				System.out.println("Program is ending.");
				runAgain = false;
				
			}else {
				System.out.println("Please only enter f, c, or m. Program will run again.");
				runAgain = true;
			}
		
		}//end of while
		
		scn.close();
	}
}
