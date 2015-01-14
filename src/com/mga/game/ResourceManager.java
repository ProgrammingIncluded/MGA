package com.mga.game;

import java.util.LinkedHashMap;

public abstract class ResourceManager<T>
{
	/* Private Variables */
	private LinkedHashMap<String, Resource> goLHMap; // rsrcName, Resource
	private Resource defRsrc;

	public ResourceManager(String defRsrcName, String defFileName, T defRsrcObj)
	{
		goLHMap = new LinkedHashMap<String, Resource>();
		defRsrc = new Resource();
		defRsrc.name = defRsrcName;
		defRsrc.fileName = defFileName;
		defRsrc.resource = defRsrcObj;
	}

	// DELETE ME NOTE: No need for deconstructor port as it is mainly resource 
	// allocation.
	// Java's garbage collection... :P sorry optimzationists...

	/* Abstract Functions */
	public abstract T loadResource(String name, String filename);
	public abstract boolean unloadResource(String name);
	public abstract boolean updateResource(String name, String filename);
	
	/// Checks the internal map to see whether the name of the resource exists,
	/// if so return false.
	public boolean resourceExists(String nameID)
	{
		return goLHMap.keySet().contains(nameID);
	}

	protected Resource getErrorResource()
	{
		return defRsrc;
	}

	/* Mutators */
	protected boolean addResource(Resource rsrc)
	{
		if (resourceExists(rsrc.name))
		{
			return false;
		}
		goLHMap.put(rsrc.name, rsrc);
		return true;
	}

	protected boolean removeResource(String name)
	{
		if(!resourceExists(name))
		{
			return false;
		}
		goLHMap.remove(name);
		return true;
	}

	protected Resource getResource(String name)
	{
		if(!resourceExists(name))
		{	
			return getErrorResource();
		}
		return goLHMap.get(name);
	}

	/* Helper Class definitions */
	protected class Resource
	{
		Resource()
		{
			name = "";
			fileName = "";
			resource = null;
		}
		
		String name;
		String fileName;
		T resource; // Check if works.
	}
}
