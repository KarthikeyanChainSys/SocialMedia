package com.chainsys.socialmedia.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.businesslogic.Logic;
import com.chainsys.socialmedia.dto.PostCommentDTO;
import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.repository.CommentsRepository;
import com.chainsys.socialmedia.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentsRepository commentRepository;
	
	public Post save(Post ur) {
		return postRepository.save(ur);
	}
	
	public Post findById(int id) {
		return postRepository.findById(id);
	}
	
	public void deleteById(int id) {
		postRepository.deleteById(id);
	}
	
	public List<Post> getPosts(){
		List<Post> listPost = postRepository.findAll();
		return listPost;
	}
	
	public PostCommentDTO getPostAndComment(int id) {
		PostCommentDTO postCommentDto = new PostCommentDTO();
		postCommentDto.setPost(getPosts().get(id));
		List<Comment> comment = commentRepository.findByPostId(id);
		Iterator<Comment> commentItr = comment.iterator();
		while(commentItr.hasNext()) {
			postCommentDto.addComment((Comment) commentItr.next());
		}
		return postCommentDto;
	}
	
	public List<Post> findByUserId(int id){
		return postRepository.findByUserId(id);
	}
	
	public byte[] getPostImageByteArray(int id) {
		Post post = postRepository.findById(id);
		byte[] imageBytes = null;
			
			if(post != null)
			{
				imageBytes = post.getPosts();
			}
			else
			{	
				System.out.println("debug:" + this.getClass().getName() + " image is null " + id);
			}	
		return imageBytes;
	}
	
	public List<Post> getPostByFriendId(List<Friend> friendList) {
		List<Friend> acceptFriendList = friendList.stream().filter(friend->friend.getRequestStatus().equalsIgnoreCase("accept")).collect(Collectors.toList());
		List<Integer>postId=new ArrayList<>();
		for(int i=0;i<acceptFriendList.size();i++) {
			Friend friend=acceptFriendList.get(i);
			postId.add(friend.getFriendId());
			System.out.println(friend.getFriendId());
		}
		List<Post> postList = postRepository.findByPostIdIn(postId);
		postList.forEach(post-> System.out.println(post.getPostId()));
		return postList;
	}
	
	public List<Post> getPost(List<Friend> friendList){
		List<Post> publicPost = Logic.getPublicPosts(postRepository.findAll());
		List<Post> friendPost = getPostByFriendId(friendList);
		return Logic.getPostForUsers(friendPost, publicPost);
	}
}
 