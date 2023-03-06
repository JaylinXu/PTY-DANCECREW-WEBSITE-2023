// Load comment data from localStorage.
var comments = JSON.parse(localStorage.getItem('comments')) || [];

// Add comment
function addComment() {
  var username = document.getElementById("username").value;
  var comment = document.getElementById("comment").value;
  if (username && comment) {
    comments.push({username: username, comment: comment, likes: 0});
    saveComments(); // 存储评论数据到 localStorage
    showComments();
  }
}

// Delete comment
function deleteComment(index) {
  comments.splice(index, 1);
  saveComments(); // 存储评论数据到 localStorage
  showComments();
}

// Like a comment
function likeComment(index) {
  if (comments[index].likes == 0) {
    comments[index].likes = 1;
    saveComments(); // 存储评论数据到 localStorage
    showComments();
  }
}

// Store comment data to localStorage.
function saveComments() {
  localStorage.setItem('comments', JSON.stringify(comments));
}

// show comment
function showComments() {
  var commentList = document.getElementById("commentList");
  commentList.innerHTML = "";
  for (var i = 0; i < comments.length; i++) {
    var commentDiv = document.createElement("div");
    commentDiv.className = "comment";
    commentDiv.innerHTML = "<strong>" + comments[i].username + ":</strong> " + comments[i].comment + "<button onclick=\"likeComment(" + i + ")\">Like &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</button>" 
    + "<button onclick=\"deleteComment(" + i + ")\">Delete</button>" + "<span class=\"likes\">" + comments[i].likes + "&ensp;likes</span>";
    commentList.appendChild(commentDiv);
  }
}


saveComments();
showComments();
