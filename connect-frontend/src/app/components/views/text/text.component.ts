import { Component } from '@angular/core';
import { Post } from '../../../models/post';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-text',
  imports: [FormsModule],
  templateUrl: './text.component.html',
  styleUrls: ['./text.component.css'],
})
export class TextComponent {
  newPostMessage: string = '';
  posts: Post[] = [
    {
      username: 'john_doe',
      profilePicture: 'https://www.w3schools.com/w3images/avatar2.png',
      message: 'This is a test post',
      likes: 15,
      comments: 5,
      reposts: 2,
      views: 50,
      favorited: false,
      showCommentBox: false,
      newComment: '',
    },
    {
      username: 'jane_smith',
      profilePicture: 'https://www.w3schools.com/w3images/avatar6.png',
      message: 'This is another post',
      likes: 20,
      comments: 8,
      reposts: 3,
      views: 80,
      favorited: true,
      showCommentBox: false,
      newComment: '',
    },
  ];

  addPost() {
    if (this.newPostMessage.trim() !== '') {
      const newPost: Post = {
        username: 'new_user', // For now, using a static username
        profilePicture: 'https://www.w3schools.com/w3images/avatar1.png',
        message: this.newPostMessage,
        likes: 0,
        comments: 0,
        reposts: 0,
        views: 0,
        favorited: false,
        showCommentBox: false,
        newComment: '',
      };
      this.posts.unshift(newPost);
      this.newPostMessage = '';
    }
  }

  toggleFavorite(post: Post) {
    post.favorited = !post.favorited;
  }

  incrementLikes(post: Post) {
    post.likes += 1;
  }

  incrementComments(post: Post) {
    post.comments += 1;
  }

  incrementReposts(post: Post) {
    post.reposts += 1;
  }

  incrementViews(post: Post) {
    post.views += 1;
  }

  // Toggle comment box visibility
  toggleComment(postIndex: number) {
    const post = this.posts[postIndex];
    post.showCommentBox = !post.showCommentBox;
  }

  // Add comment to the post
  addComment(post: Post, postIndex: number) {
    if (post.newComment.trim() !== '') {
      post.comments += 1;
      post.newComment = ''; // Reset the new comment
      post.showCommentBox = false; // Hide the comment box after submitting
    }
  }
}
