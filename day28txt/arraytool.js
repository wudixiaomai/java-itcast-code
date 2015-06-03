// JavaScript Document

function ArrayTool()
{
	this.getMax = function(arr)
	{
		var max = arr[0];
		for(var x=1; x<arr.length; x++)
		{
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
}