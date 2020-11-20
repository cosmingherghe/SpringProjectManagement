var projStats = new Chart(document.getElementById("projectsChart"), {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#ff3000", "#5fd4ff", "#74fd38"],
            borderColor: 'rgb(255,99,132)',
            data: [2, 10, 5]
        }]
    },
    // Configuration options go here
    options: {}
});