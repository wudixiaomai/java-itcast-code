import java.io.*;

class  ListFiles
{
	public static void main(String[] args) 
	{
		File dir = new File("f:\\demodir");

		new ListFiles().listDir(dir,0);
	}
	public void listDir(File dir,int level)
	{
		System.out.println(getLevel(level)+dir.getName());
		level++;
		File[] files = dir.listFiles();
		for(int x =0; x<files.length; x++)
		{
			if(files[x].isDirectory())//如果遍历到的是目录。
				listDir(files[x],level);//那么就行该功能的重复使用。递归。
			else
				System.out.println(getLevel(level)+files[x].getName());
		}
	}

	//想要对列出的目录有一些层次关系。
	public String getLevel(int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for(int x=0; x<level; x++)
		{
			sb.insert(0,"|  ");
		}
		return sb.toString();
	}
}
