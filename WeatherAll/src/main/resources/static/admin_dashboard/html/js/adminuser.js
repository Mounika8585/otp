// Get the Add User button element
var addUserButton = document.getElementById("addUserButton");

// Get the Add User modal
var addUserModal = document.getElementById("addUserModal");

// Get the Delete User button element
var deleteUserButton = document.getElementById("deleteUserButton");

// Get the Delete User modal
var deleteUserModal = document.getElementById("deleteUserModal");

// Get the <span> element that closes the modals
var closeButtons = document.getElementsByClassName("close");

// Function to open the Add User modal
addUserButton.onclick = function() {
  addUserModal.style.display = "block";
}

// Function to open the Delete User modal
deleteUserButton.onclick = function() {
  deleteUserModal.style.display = "block";
}

// Close the modals when the user clicks on <span> (x)
for (var i = 0; i < closeButtons.length; i++) {
  closeButtons[i].onclick = function() {
    addUserModal.style.display = "none";
    deleteUserModal.style.display = "none";
  }
}

// When the user clicks anywhere outside of the modals, close them
window.onclick = function(event) {
  if (event.target == addUserModal || event.target == deleteUserModal) {
    addUserModal.style.display = "none";
    deleteUserModal.style.display = "none";
  }
}

// Form submission for Add User
document.getElementById("addUserForm").addEventListener("submit", function(e) {
  e.preventDefault();
  var userId = document.getElementById("addUserId").value;
  // Handle submission of user details (addUserForm)
  // ...
  addUserModal.style.display = "none";
});

// Form submission for Delete User
document.getElementById("deleteUserForm").addEventListener("submit", function(e) {
  e.preventDefault();
  var userId = document.getElementById("deleteUserId").value;
  // Handle submission of user details (deleteUserForm)
  // ...
  deleteUserModal.style.display = "none";
});

// Action for the Confirm Delete button
document.getElementById("confirmDeleteButton").addEventListener("click", function() {
  var userId = document.getElementById("deleteUserId").value;
  // Handle the confirmation of user deletion
  // ...
  deleteUserModal.style.display = "none";
});
