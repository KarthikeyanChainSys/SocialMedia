package com.chainsys.socialmedia.commonutil;

@SuppressWarnings("serial")
public class InvalidInputDataException extends Exception {
	public InvalidInputDataException()
	{
		super("This is not valid data ");
	}
	public InvalidInputDataException(String message)
	{
		super(message);
	}
}

