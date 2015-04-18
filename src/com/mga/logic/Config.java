package com.mga.logic;

import com.mga.game.engine.State;

public class Config
{
	/*Sound Related*/
	public static final String DEF_SND_NAME = "ERRSND";
	public static final String DEF_SND_FILE_NAME = "audio/ERRSND.mp3";
	
	/*Sprite Related*/
	public static final String DEF_SPR_NAME = "ERRSPRITE";
	
	/*Texture Related*/
	public static final String DEF_TEX_NAME = "ERRTEX";
	public static final String DEF_TEX_FILE_NAME = "texture/ERRTEX.jpg";
	
	/* GO Related */
	public static final String DEF_GO_NAME = "DEFGONAME";
	
	public static final State DEF_STATE = new TitleState();
}
