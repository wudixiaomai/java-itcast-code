class ArrayDemo 
{
	public static void main(String[] args) 
	{

		int[] arr = {3,1,6,4,7,9,2};
		ArrayTool tool = new ArrayTool();
		int max = tool.getMax(arr);

		System.out.println("max="+max);

		tool.printArray(arr);
		tool.sort(arr);
		tool.printArray(arr);
	}
}
