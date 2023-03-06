// Get the modal, image, and close button.
var modal = document.getElementById("myModal");
var modalImg = document.getElementById("img01");
var closeBtn = document.getElementsByClassName("close")[0];

// Click on image to pop-out modal
var images = document.getElementsByClassName("gallery-image");
for (var i = 0; i < images.length; i++) {
  images[i].onclick = function() {
    modal.style.display = "block";
    modalImg.src = this.src;
  }
}

// Click close button to close modal display
closeBtn.onclick = function() {
  modal.style.display = "none";
}

// Click on area outside of modal to close modal display
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

