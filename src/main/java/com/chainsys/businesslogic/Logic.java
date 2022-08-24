package com.chainsys.businesslogic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.Post;

public class Logic{
	private Logic() {
	    throw new IllegalStateException("Utility class");
	  }
	public static List<Friend> getRequestList(List<Friend> friendList) {
		List<Friend> requestList = new ArrayList<>();
		for(int i=0;i<friendList.size();i++) {
			Friend friend=friendList.get(i);
			if(friend.getRequestStatus().equalsIgnoreCase("request")) {
				requestList.add(friend);
			}
		}
		return requestList;
	}
	
	public static List<Friend> getAcceptList(List<Friend> friendList) {
		List<Friend> requestList = new ArrayList<>();
		for(int i=0;i<friendList.size();i++) {
			Friend friend=friendList.get(i);
			if(friend.getRequestStatus().equalsIgnoreCase("accept")) {
				requestList.add(friend);
			}
		}
		return requestList;
	}
		
	public static List<Post> getPublicPosts(List<Post> postList){
		return postList.stream().filter(post->post.getVisibility().equalsIgnoreCase("public")).collect(Collectors.toList());
		
	}
	
	public static List<Post> getPostForUsers(List<Post> friendPost, List<Post> publicPost){
		return Stream.concat(friendPost.stream(), publicPost.stream()).collect(Collectors.toList());
	}
	
	public static LocalDate  getInstanceDate() {
		return java.time.LocalDate.now();
	}
}
