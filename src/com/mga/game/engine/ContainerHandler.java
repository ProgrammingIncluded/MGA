package com.mga.game.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Class that should be derived for any container like management.
 * Provides ability to auto point containers to default textures when
 * "deleted" in case someone has a reference to that container.
 * As such, resourceDeleted needs to be manually called.
 * @author Charles Chen
 */
public abstract class ContainerHandler<T>
{
	/* Private Variables  */
	protected LinkedHashMap <String, Container> containers; // name, Container
	private final Container defContainer; // Must have constant Default Texture
	
	ContainerHandler(String defContainerName, String defFileName, T containerObj)
	{
		containers = new LinkedHashMap<String, Container>();
		defContainer =  new Container(defContainerName, 
			defFileName, containerObj);
	}
	
	/**
	 * Function to tell the Handler that a tex. resource has been deleted.
	 * Change all the container classes to point to a default
	 * texture that is unchangeable. Call when textures are deleted from memory
	 * for some reason. TODO: Have manager call resource deleted
	 * when an object is deleted.
	 */
	public abstract boolean resourceDeleted(String resourceFileName);
	
	/// Short hand function to check whether or not
	/// container exists in LinkedHashMap.
	public boolean containerExists(String containerName)
	{
		return containers.keySet().contains(containerName);
	}
	
	public Container getDefContainer()
	{
		return defContainer;
	}
	
	/* Getters and Setters */
	public T addContainer(String containerName, String containerFileName,
		T containerObj)
	{
		if (containerExists(containerName) || containerName.length() == 0 
			|| containerFileName.length() == 0)
		{
			return defContainer.containerObj;
		}
		
		Container cont = new Container(containerName, containerFileName, 
			containerObj);
		containers.put(containerName, cont);
		return cont.containerObj;
	}
	
	public T getContainer(String containerName)
	{
		if (!containerExists(containerName))
		{
			return defContainer.containerObj;
		}
		return containers.get(containerName).containerObj;
	}
	
	/**
	 * Removes the tracking of the given container's name.
	 * Use with caution, once untracked, will not be able to
	 * use resourceDeleted to set contain to a default value.
	 * Call if you want to delete the sprite, but not the texture.
	 */
	public T deleteContainer(String containerName)
	{
		if (!containerExists(containerName))
		{
			return null;
		}
		return containers.remove(containerName).containerObj;
	}
	
	/**
	 * Get's the Container's associated with given resource filename.
	 */
	protected ArrayList<Container> 
		getContainerAssocResource(String resourceFileName)
	{
		ArrayList<Container> cont = new ArrayList<Container>();
		Iterator<Container> it = containers.values().iterator();
		Container containerHolder;
		while(it.hasNext())
		{
			containerHolder = it.next();
			if(containerHolder.fileName.equals(resourceFileName))
			{
				cont.add(containerHolder);
			}
		}
		return cont;
	}
	
	
	/// Helper classes
	protected class Container
	{
		public String name;
		public String fileName;
		public T containerObj;
		
		Container(String name, String fileName, T containerObj)
		{
			this.name = name;
			this.fileName = fileName;
			this.containerObj = containerObj;
		}
	}
}
