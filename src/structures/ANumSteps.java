package structures;

public class ANumSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
			System.out.println("result with "+i+"="+num_Steps(i));
		
		for(int i=0;i<10;i++)
			System.out.println("result with "+i+"="+num_StepsBetter(i));
	}
	
	public static int num_Steps(int n) {
		if (n==0||n==1)
			return 1;
		else 
			return num_Steps(n-1)+num_Steps(n-2);
	}
	
	/*wiht dinamic programing */
	public static int num_StepsBetter(int n) {
		if (n==0||n==1)
			return 1;
		int previosResults[] = new int[n+1];
		
		previosResults[0]=1;
		previosResults[1]=1;
		
		for(int i =2; i<n+1 ;i++)
			previosResults[i]=previosResults[i-1]+previosResults[i-2];
		return previosResults[n];
	}
}
