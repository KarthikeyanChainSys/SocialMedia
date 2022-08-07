
function name() {
	var x = document.getElementById("").username;
	document.getElementById("demo").innerHTML = x;
}

function like() {
	let likebutton = document.querySelector('#likebutton');
	let input = document.querySelector('#input');
	likebutton.addEventListener('click',()=>{
		input.value = parseInt(input.value) + 1;
		input.style.color = "#12ff00";
	})
}