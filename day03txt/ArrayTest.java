class  ArrayTest
{
	public static void main(String[] args) 
	{
		int[] arr = {4,1,5,2,7,3};
		int x = getMax(arr);
		int y = getMin(arr);
		System.out.println("max="+x);
		System.out.println("min="+y);
	}

	/*
	˼·��
	1������һ�����������ڼ�¼ÿ�αȽ���Ƚϴ��Ԫ�ء���ʼ��Ϊ����������һ��Ԫ�ء�
	2��ͨ��ѭ����ÿһ��Ԫ�ض��͸ñ����е�Ԫ�ؽ��бȽϡ�
	3���ڱ������С��������������Ƚϴ�Ԫ���ñ������м�¼��

	����һ�����ܡ�
	1���ù��ܵĽ����һ��int��
	2��δ֪������һ�����顣
	*/

	public static int getMax(int[] arr)
	{
		int max = arr[0];

		for(int x=1; x<arr.length; x++)
		{
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}

	public static int getMin(int[] arr)
	{
		int min = arr[0];

		for(int x=1; x<arr.length; x++)
		{
			if(arr[x]<min)
				min = arr[x];
		}
		return min;
	}
	/*
	����������ʱ�򣬳�ʼ��Ϊ0����ô����أ�
	*/

	public static int getMax2(int[] arr)
	{
		int max = 0;
		for(int x=1; x<arr.length; x++)
		{
			if(arr[x]>arr[max])
				max = x;
		}
		return arr[max];
	}

	/*
	��ȡdouble������������ֵ��
	*/
	public static double getMax(double[] arr)
	{
		double max = arr[0];

		for(int x=1; x<arr.length; x++)
		{
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
}
