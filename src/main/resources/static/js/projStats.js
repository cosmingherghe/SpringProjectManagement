var projStatsStr = decodeChartProjStageCount(chartProjStageCount);
var chartJsonArray = JSON.parse(projStatsStr);
var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].total;
    labelData[i] = chartJsonArray[i].stage;
}

new Chart(document.getElementById("projectsChart"), {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#74fd38", "#5fd4ff", "#ff3000"],
            data: numericData
        }]
    },
    // Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

function decodeChartProjStageCount(html) {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}