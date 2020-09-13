
// SIDEBAR
$(document).ready(function() {
	$('.button-collapse').sideNav({
		menuWidth : 300, // Default is 300
		edge : 'left', // Choose the horizontal origin
		closeOnClick : false, // Closes side-nav on <a> clicks, useful for
								// Angular/Meteor
		draggable : true
	// Choose whether you can drag to open on touch screens
	});
	// START OPEN
	// $('.button-collapse').sideNav('show');

});

function toast() {
    Materialize.toast('Update successful!', 10000);  
}

function validatePhoneNumber(evt) {
	var theEvent = evt || window.event;
  
	// Handle paste
	if (theEvent.type === 'paste') {
		key = event.clipboardData.getData('text/plain');
	} else {
		// Handle key press
		var key = theEvent.keyCode || theEvent.which;
		key = String.fromCharCode(key);
	}
	var regex = /[0-9]/;
	if( !regex.test(key) ) {
	  theEvent.returnValue = false;
	  if(theEvent.preventDefault) theEvent.preventDefault();
	}
}