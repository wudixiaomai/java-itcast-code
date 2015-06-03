// JavaScript Document

Array.prototype.getMax = function()
{
	var max = this[0];
	for(var x=1; x<this.length; x++)
	{
		if(this[x]>max)
			max = this[x];
	}
	return max;
};
/*
key:要找的元素。

该方法返回要找的元素的第一次出现的位置。

注意：该数组必须是有序的。

*/
Array.prototype.binarySearch = function(key)
{
		var min,max,mid;
		
		min = 0;
		max = this.length-1;
		
		while(min<=max)
		{
			mid = parseInt((max+min)/2);
			
			if(key>this[mid])
				min = mid + 1;
			else if(key<this[mid])
				max = mid - 1;
			else
				return mid;
				
		}
		return -1;
		
}



//--------------给String对象添加新功能-------------------

//可以对字符串进行反转。
String.prototype.reverse = function()
{
	
	
	var arr = toArray(this);
	
	for(var start=0,end=this.length-1;  start<=end ; start++,end--)
	{
		swap(arr,start,end);
	}
	
	return arrayToString(arr);
}
//将字符串变成数组。
function toArray(str)
{
	var arr = new Array(str.length);
	for(var x=0; x<arr.length; x++)
	{
		arr[x] = str.charAt(x);	
	}
	return arr;
}

function arrayToString(arr)
{
	var s = "";
	for(var x=0; x<arr.length; x++)
	{
		s+=arr[x];
	}
	return s;
}

function swap(arr,x,y)
{
	var temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
	
	
}
//可以去除字符串两端的空格。

String.prototype.trim = function()
{
	var start=0,end=this.length-1;
	
	while(start<=end && this.charAt(start)==" ")
		start++;
	while(start<=end && this.charAt(end)==" ")
		end--;
		
	return this.substring(start,end+1);
}
























