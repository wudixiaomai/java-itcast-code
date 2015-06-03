import java.io.*;
import java.util.*;

/*
练习：
通过键盘录入学生信息。
信息包括：姓名，语文成绩，数学成绩，英文成绩，

将这些信息按照从高到低的顺序存放在一个文件中。


思路：
1，获取键盘录入信息。
2，将获取到一条记录，为了方便与操作，
	将该记录中的信息，封装成Student对象。
3，将学生对象存入集合中便于操作。需要排序。
4，将集合中的信息存入到文件中。

步骤：
1，描述学生。
	建立学生的唯一性的判断。
	该学生对象会存入哪个集合不确定，需要定义equals hashCode compareTo。
2，通过BufferedReader+System.in.不断获取键盘录入。
3，将每读到的一行数据split切割，并封装成Student对象。
4，将对象存入TreeSet集合。
5，遍历该集合，将信息写入到文件中。FileWriterBufferedWriter。


lisi,20,20,20

*/

class Student implements Comparable<Student>
{
	private String name;
	private int cn,en,ma;
	private int sum;
	Student(String name,int cn,int en,int ma)
	{
		this.name = name;
		this.cn = cn;
		this.en = en;
		this.ma = ma;
		sum = cn+en+ma;
	}

	public boolean euqals(Object obj)
	{
		if(this==obj)
			return true;
		if(!(obj instanceof Student))
			return false;
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.sum==s.sum;
	}
	public int hashCode()
	{
		return name.hashCode()+sum*34;

	}
	
	public int compareTo(Student s)
	{
		if(this.sum>s.sum)
			return 1;
		if(this.sum==s.sum)
			return this.name.compareTo(s.name);
		return -1;
	}
	public int getSum()
	{
		return sum;
	}
	public String getName()
	{
		return name;
	}
}

class InfoTool
{
	public static Set<Student> getInfoSet()throws IOException
	{
		return getInfoSet(null);
	}
	

	public static Set<Student> getInfoSet(Comparator<Student> comp)throws IOException
	{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));


		TreeSet<Student> ts = null;
		if(comp==null)
			ts = new TreeSet<Student>();
		else
			ts = new TreeSet<Student>(comp);

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			String[] arr = line.split(",");
			Student s = new Student(arr[0],Integer.parseInt(arr[1])
				,Integer.parseInt(arr[2])
				,Integer.parseInt(arr[3]));

			ts.add(s);
		}
		return ts;
	}

	public static void write2File(Set<Student> infoSet)throws IOException
	{
		BufferedWriter bufw = 
			new BufferedWriter(new FileWriter("stuinfo.txt"));

		Iterator<Student> it = infoSet.iterator();
		while(it.hasNext())
		{
			Student stu = it.next();
			bufw.write(stu.getName()+"\t"+stu.getSum());
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}


class  StudentInfo
{
	public static void main(String[] args) throws IOException
	{

		Comparator<Student> comp = Collections.reverseOrder();
		Set<Student> infoSet = InfoTool.getInfoSet(comp);

		InfoTool.write2File(infoSet);
	}
}
