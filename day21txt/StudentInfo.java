/*
需求：
通过键盘录入的形式输入学生信息。格式：姓名,数学成绩,语文成绩,英文成绩

将多个学生的总分按照从高到低的次序排序并存储到一个文件中。

思路：
1，键盘录入获取学生信息。
2，对信息进行切割，将信息封装成学生对象。
3，要对信息排序，信息所属于学生，就需要对学生进行存储。
4，对排序后的学生对象的信息写入到文件中。

步骤：
1，键盘录入：
	BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

2，在读到每一行字符串时，使用split(",")对进行数据进行切割，将数据封装到学生对象中。

3，将学生对象存储到哪个容器中，需要排序，所以存储到TreeSet集合中。

4，遍历treeset集合，将treeset集合中的学生信息写入到一个文件中。
	BufferedWriter bufw = new  BufferedWriter(new FileWriter("info.txt"));




*/



import java.io.*;
import java.util.*;
class  StudentInfo
{
	public static void main(String[] args) throws IOException
	{
		Comparator<Student> comp = Collections.reverseOrder();
		
		Set<Student> stuSet = InfoTool.getStudents(comp);

		File destFile = new File("stuInfo.txt");
		InfoTool.write2File(stuSet,destFile);
	}
}
class MyCompare implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		if(s1.getSum()>s2.getSum())
			return -1;
		if(s1.getSum()<s2.getSum())
			return 1;
		return s2.getName().compareTo(s1.getName());
	}
}

class InfoTool
{

	/*
	获取学生对象Set集合。有指定的比较器。
	*/
	public static Set<Student> getStudents()throws IOException
	{
		return getStudents(null);
	}
	/*
	获取键盘录入信息，封装学生对象存储到Set集合中。
	*/
	public static Set<Student> getStudents(Comparator<Student> comp)throws IOException
	{
		Set<Student> stuSet = null;

		if(comp==null)
			stuSet = new TreeSet<Student>();
		else
			stuSet = new TreeSet<Student>(comp);

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		String line = null;

		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;

			String[] arr = line.split(",");
			Student stu = new Student(arr[0],Integer.parseInt(arr[1])
											,Integer.parseInt(arr[2])
											,Integer.parseInt(arr[3]));
			stuSet.add(stu);
		}
		return stuSet;
	}

	/*
	将集合中的信息，写入到一个文件中。
	*/

	public static void write2File(Set<Student> stuSet,File infoFile)throws IOException
	{
		BufferedWriter bufw = new BufferedWriter(new FileWriter(infoFile));

		for(Student stu : stuSet)
		{
			bufw.write(stu.getName()+"\t"+stu.getSum());
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
	}
}
class Student implements Comparable<Student>
{
	private String name;
	private int ma,cn,en;
	private int sum;
	Student(String name,int ma,int cn,int en)
	{
		this.name = name;
		this.ma = ma;
		this.cn = cn;
		this.en = en;
		sum = ma+cn+en;
	}
	public int compareTo(Student s)
	{
		if(this.sum>s.sum)
			return 1;
		if(this.sum<s.sum)
			return -1;
		return this.name.compareTo(s.name);
	}
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(!(obj instanceof Student))
			return false;
		Student s = (Student)obj;

		return this.name.equals(s.name) && ma==s.ma && cn==s.cn && en==s.en;

	}
	public int hashCode()
	{
		return name.hashCode()+sum*28;
	}
	public String getName()
	{
		return name;
	}
	public int getSum()
	{
		return sum;
	}
}
	