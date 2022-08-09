
function name() {
	var x = document.getElementById("").username;
	document.getElementById("demo").innerHTML = x;
}

function like() {
	let likebutton = document.querySelector('#likebutton');
	let input = document.querySelector('#input');
	likebutton.addEventListener('click', () => {
		input.value = parseInt(input.value) + 1;
		input.style.color = "#12ff00";
	})
}

$("#profileImage").click(function() {
	$("#imageUpload").click();
});

function fasterPreview(uploader) {
	if (uploader.files && uploader.files[0]) {
		$('#profileImage').attr('src',
			window.URL.createObjectURL(uploader.files[0]));
	}
}

$("#imageUpload").change(function() {
	fasterPreview(this);
});