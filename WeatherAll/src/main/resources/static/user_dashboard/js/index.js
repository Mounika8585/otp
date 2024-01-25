$(document).ready(function() {
    $('#profile-dropdown').click(function(e) {
        e.preventDefault();
        $('#profile-dropdown-menu').toggle();
    });

    // Close the dropdown when clicking outside of it
    $(document).click(function(e) {
        if (!$(e.target).closest('#profile-dropdown').length && !$(e.target).closest('#profile-dropdown-menu').length) {
            $('#profile-dropdown-menu').hide();
        }
    });
});
