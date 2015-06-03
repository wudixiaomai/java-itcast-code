
/*

ถþฮฌสýื้

*/
class  TwoArrayDemo
{
	public static void main(String[] args) 
	{
//		int[][] x = new int[3][2];x[0] = null;
//
//		x[0] = new int[3];
//
//		x[1] = new int[1];
//		x[2] = new int[4];
		//System.out.println(x[0]);

		int[][] arr = {{3,1,5,6},{4,1},{5,1,6}};
		
		int sum = 0;
		for(int x=0; x<arr.length; x++)
		{
			for(int y=0; y<arr[x].length;y++)
			{
				sum = sum + arr[x][y];
			}
		}
		//System.out.println("sum="+sum);

		int[] arra = {1,2,3,4,5,6,7,8};

		int[] arrb = new int[6];

		System.arraycopy(arra,2,arrb,1,3);

		for(int x=0; x<arrb.length; x++)
		{
			System.out.print(arrb[x]+",");
		}


	}
}

