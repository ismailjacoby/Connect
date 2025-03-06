export interface Post {
  username: string;
  profilePicture: string;
  message: string;
  likes: number;
  comments: number;
  reposts: number;
  views: number;
  favorited: boolean;
  showCommentBox: boolean;
  newComment: string;
}
