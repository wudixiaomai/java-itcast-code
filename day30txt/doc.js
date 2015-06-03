// JavaScript Document

var doc = document;

function byId(id)
{
	return doc.getElementById(id);	
}
function byTag(tagName)
{
	return doc.getElementsByTagName(tagName);
}
function byName(name)
{
	return doc.getElementsByName(name);
}