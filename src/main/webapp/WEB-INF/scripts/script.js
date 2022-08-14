
function name() {
	var x = document.getElementById("").username;
	document.getElementById("demo").innerHTML = x;
}

	var clicks = 0;
    function click() {
        clicks += 1;
        document.getElementById("clicks").innerHTML = clicks;
    };

function like(){
	const likeBtn = document.querySelector(".like_btn");
	let likeIcon= document.querySelector("#icon"); 
	let count = document.querySelector("#count");
	let clicked = false;

	likeBtn.addEventListener("click", () => {
	if (!clicked) {
	clicked = true;
	likeIcon.innerHTML = `<i class="fas fa-thumbs-up"></i>`;
	count.textContent++;
	}else{
	clicked = false;
	likeIcon.innerHTML = `<i class="far fa-thumbs-up"></i>`;
	count.textContent--;
	}
	});
	}

function like1() {
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


/*$('#foo').click(function() {
	    var button = $(this),
	        commentField = $('<textarea/>');
	        .val(button.data('textContent') || 'This is my comment field\'s text')
	        .keypress(function(e) {
	            if (e.which === 13) {
	                e.preventDefault();
	                button.data('textContent', this.value);
	                $(this).remove();
	            }
	        })
	        .appendTo(document.body);
	});*/