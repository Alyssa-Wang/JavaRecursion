public class Factorial
{  
  static int factorial(int n)
  {    
    if (n == 0)    
      return 1;    
    else    
      return(n * factorial(n-1));    
 }   
  
  public static void main(String [] args)
  {  
    int answer=0;  
    int number=4;//The number that we will be calculating factorial with    
    answer = factorial(number);   
    System.out.println("The factorial of "+number+" is: "+answer);    
  }  
}  
