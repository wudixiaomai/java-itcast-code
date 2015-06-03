class Outer
{
	static class Inner{}

	public void show()
	{
		new Inner();
	}
	public static void main(String[] args)
	{
		new Inner();	
	}
}

