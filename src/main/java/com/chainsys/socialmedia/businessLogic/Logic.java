package com.chainsys.socialmedia.businessLogic;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.Post;

public class Logic{
	public static List<Friend> getRequestList(List<Friend>friendList) {
		List<Friend> requestList=new ArrayList<>();
		for(int i=0;i<friendList.size();i++) {
			Friend friend=friendList.get(i);
			if(friend.getRequestStatus().equalsIgnoreCase("request")) {
				requestList.add(friend);
			}
		}
		return requestList;
	}
}
