class MealPrep {
    constructor() {
        this.settings = {
            "async": true,
            "crossDomain": true,
            "url": "https://swapistefanskliarovv1.p.rapidapi.com/getFilms",
            "method": "POST",
            success: function(data){
                this.setData(data);
            }.bind(this),
            error: function() {
                console.log("Error personalizado");
            },
            "headers": {
                "x-rapidapi-host": "SwapistefanskliarovV1.p.rapidapi.com",
                "x-rapidapi-key": "49e9a7cb4bmshe0c4a371ccaeac9p1b087ejsnfabb0d1a4810",
                "content-type": "application/x-www-form-urlencoded"
            },
            "data": {}
        }
        this.getFilms();
    }

    getFilms(){
        $.ajax(this.settings);
    }

    setData(data){
        console.log(data);
        let movies = data.contextWrites.to[0].results.sort((a, b) =>  b.episode_id - a.episode_id);
        movies.forEach(element => {
            $('dl').after('<dt>Episode ' + element.episode_id + ", " + element.title + ' (' + element.release_date + ')' +'</dt><dd>' + element.opening_crawl);
        });
        
    }
}

var api = new MealPrep();