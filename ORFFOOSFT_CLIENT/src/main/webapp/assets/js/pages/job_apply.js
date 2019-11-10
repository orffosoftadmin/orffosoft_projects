/* ------------------------------------------------------------------------------
*
*  # Job search - apply
*
*  Specific JS code additions for job search page kit - apply
*
*  Version: 1.0
*  Latest update: Jan 10, 2017
*
* ---------------------------------------------------------------------------- */

$(function() {


    // Select2 select
    // ------------------------------

    // With search
    $('.select').select2();

    // Without search
    $('.select-simple').select2({
        minimumResultsForSearch: Infinity
    });


    // Date picker
    // ------------------------------

    // Default functionality
    $(".datepicker").datepicker();


    // Styled form components
    // ------------------------------

    // Checkboxes, radios
    $(".styled").uniform({ radioClass: 'choice' });

    // File input
    $(".file-styled").uniform({
        fileButtonClass: 'action btn bg-pink-400'
    });
  
});




$(document).ready(function(){

    // Smart Wizard events
    
    
    // This event should initialize before initializing smartWizard
    // Otherwise this event wont load on first page load 
    $("#smartwizard").on("showStep", function(e, anchorObject, stepNumber, stepDirection, stepPosition) {
        $("#message-box").append(" > <strong>showStep</strong> called on " + stepNumber + ". Direction: " + stepDirection+ ". Position: " + stepPosition);
    });
    
    $("#smartwizard").on("beginReset", function(e) {
        $("#message-box").append("<br /> > <strong>beginReset</strong> called");
    });
    
    $("#smartwizard").on("endReset", function(e) {
        $("#message-box").append(" > <strong>endReset</strong> called");
    });  
    
    $("#smartwizard").on("themeChanged", function(e, theme) {
        $("#message-box").append("<br /> > <strong>themeChanged</strong> called. New theme: " + theme);
    });
    
    // Toolbar extra buttons
    
    var btnCancel = $('<button></button>').text('Cancel')
    .addClass('btn btn-danger')
    .on('click', function(){ $('#smartwizard').smartWizard("reset"); });      
    var btnFinish = $('<button></button>').text('Submit')
                                     .addClass('btn btn-success m-r-5')
                                     .on('click', function(){ alert('Finish Clicked'); });
                       
    
    // Smart Wizard initialize
    $('#smartwizard').smartWizard({ 
            selected: 0, 
            theme: 'dots',
            transitionEffect:'fade',
            toolbarSettings: {toolbarPosition: 'bottom',
                              toolbarExtraButtons: [btnFinish, btnCancel]
                            }
         });           
    
    // External Button Events
    $("#reset-btn").on("click", function() {
        // Reset wizard
        $('#smartwizard').smartWizard("reset");
        return true;
    });
    
    $("#prev-btn").on("click", function() {
        // Navigate previous
        $('#smartwizard').smartWizard("prev");
        return true;
    });
    
    $("#next-btn").on("click", function() {
        // Navigate next
        $('#smartwizard').smartWizard("next");
        return true;
    });
    
    $("#theme_selector").on("change", function() {
        // Change theme
        $('#smartwizard').smartWizard("theme", $(this).val());
        return true;
    });
    
});   

