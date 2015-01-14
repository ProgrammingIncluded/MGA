package com.mga.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

/**
 * SoundHandler class for managing sound files.
 * Main thing to note is, default sound can be accidently
 * deleted via dispose method. DO NOT CALL THAT.
 * @author Charles
 *
 */
public class SoundHandler extends ContainerHandler<Sound>
{
	static final String DEF_CONT_NAME = Config.DEF_SND_NAME;
	static final String DEF_FILE_NAME = Config.DEF_SND_FILE_NAME;
	
	SoundHandler()
	{
		this(DEF_CONT_NAME, DEF_FILE_NAME, 
			Gdx.audio.newSound(Gdx.files.internal(DEF_FILE_NAME)));
	}
	
	SoundHandler(String defContainerName, String defFileName,
		Sound containerObj)
	{
		super(defContainerName, defFileName, containerObj);
	}

	// Let the SoundHandler know that sound has been deleted.
	// 
	public boolean resourceDeleted(String resourceFileName)
	{
		ArrayList<Container> deletedVect = 
				getContainerAssocResource(resourceFileName);
		Iterator<Container> it = deletedVect.iterator();
		while(it.hasNext())
		{
			Container cont = it.next();
			cont.fileName = getDefContainer().fileName;
			cont.containerObj = getDefContainer().containerObj;
		}
		return true;
	}
	
	// Helper function for directly calling getContainer
	// in extended class. 
	public Sound getSound(String containerName)
	{
		return getContainer(containerName);
	}
	
	public Sound createSound(String containerName, String containerFileName)
	{
		if(containerExists(containerName))
		{
			return getContainer(containerName);
		}
		
		FileHandle file = Gdx.files.internal(containerFileName);
		if(file.exists() == false)
		{
			return getDefContainer().containerObj;
		}

		return Gdx.audio.newSound(file);
	}
}
