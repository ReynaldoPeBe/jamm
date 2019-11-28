/*titulo de oçhiver mouse*/
function showTooltip(evt, text) {
    let tooltip = document.getElementById("tooltip");
    text = "<h5>" + text + "</h5>";
    tooltip.innerHTML = text;
    tooltip.style.display = "block";
    tooltip.style.left = evt.pageX + 15 + 'px';
    tooltip.style.top = evt.pageY + 15 + 'px';
}
function hideTooltip() {
    var tooltip = document.getElementById("tooltip");
    tooltip.style.display = "none";
}
/*ajax*/
function getinfopredio(urledif) {
    //alert("hola js");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("infopredio").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/" + urledif, true);
    xhttp.send();
}


function getinfopredioparticular(iidpredio) {
    $.ajax({
        type: "POST",
        url: "/getprediobyid",
        data: {idpredio: iidpredio},
        success: function(response){
            $("#infopredio").html(response)
        }
   })
}