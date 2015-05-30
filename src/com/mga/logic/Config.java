package com.mga.logic;

import java.io.BufferedReader;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.mga.game.engine.State;

/**
 * Function to deal with configuration of the engine and it's default files.
 * Must make sure that a config.txt exists inside desktop folder with first line
 * with directory to error sound and second to texture.
 * @author Charles
 *
 */
public class Config
{
	/**
	 * Loads the config.txt found in the desktop/bin folder.
	 */
	public static boolean loadConfigFile()
	{
		FileHandle file = Gdx.files.internal("config.txt");
		if(file.exists())
		{
			BufferedReader reader = file.reader(256);
			try
			{
				DEF_SND_FILE_NAME = reader.readLine();
				DEF_TEX_FILE_NAME = reader.readLine();
			}
			catch(IOException e)
			{
				return false;
			}

			return true;
		}
		return false;
	}
	
	public static String getERRSND()
	{
		return DEF_SND_FILE_NAME;
	}
	
	public static String getERRTEX()
	{
		return DEF_TEX_FILE_NAME;
	}
	
	/*Sound Related*/
	public static final String DEF_SND_NAME = "ERRSND";
	private static String DEF_SND_FILE_NAME = "";
	
	/*Sprite Related*/
	public static final String DEF_SPR_NAME = "ERRSPRITE";
	
	/*Texture Related*/
	public static final String DEF_TEX_NAME = "ERRTEX";
	private static String DEF_TEX_FILE_NAME = "";
	
	/* GO Related */
	public static final String DEF_GO_NAME = "DEFGONAME";
}
