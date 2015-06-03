import java.util.*;

class Die
{
	private int faceValue;
	public void roll()
	{
		Random r = new Random();
		faceValue = r.nextInt(6)+1;
	}
	public int getFaceValue()
	{
		return faceValue;
	}
}



class  DiceGame
{
	private Die die1,die2;

	public void play()
	{
		die1 = new Die();
		die2 = new Die();

		die1.roll();
		die2.roll();

		int x = die1.getFaceValue();
		int y = die2.getFaceValue();

		if((x+y)==7)
			System.out.println("中了，恭喜");
		else
			System.out.println("没中，郁闷");
	}
	
	public static void main(String[] args) 
	{

		new DiceGame().play();
	}
}
