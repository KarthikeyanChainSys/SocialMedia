package com.chainsys.socialmedia.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.dto.PostCommentDTO;
import com.chainsys.socialmedia.dto.PostLikeDTO;
import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.repository.CommentsRepository;
import com.chainsys.socialmedia.repository.LikesRepository;
import com.chainsys.socialmedia.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentsRepository commentRepository;
	@Autowired
	private LikesRepository likeRepository;
	
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
	
	public PostLikeDTO getPostAndLike(int id) {
		PostLikeDTO postLikeDto = new PostLikeDTO();
		postLikeDto.setPost(getPosts().get(id));
		List<Like> like = likeRepository.findByPostPostId(id);
		postLikeDto.addLike(like);
		return postLikeDto;
	}
}
 