package com.hannes.starwars.data.datasource

import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.model.Species

val dummyMovie: List<Film> = listOf(
    // --- Episode IV ---------------------------------------------------------
    Film(
        title = "A New Hope",
        episode_id = 4,
        opening_crawl = "It is a period of civil war…",          // gekürzt
        director = "George Lucas",
        producer = "Gary Kurtz, Rick McCallum",
        release_date = "1977-05-25",
        characters = listOf(
            "https://swapi.py4e.com/api/people/1/",
            "https://swapi.py4e.com/api/people/2/",
            "https://swapi.py4e.com/api/people/3/",
            /* …weitere… */
        ),
        planets = listOf(
            "https://swapi.py4e.com/api/planets/1/",
            "https://swapi.py4e.com/api/planets/2/",
            "https://swapi.py4e.com/api/planets/3/"
        ),
        starships = listOf(
            "https://swapi.py4e.com/api/starships/2/",
            "https://swapi.py4e.com/api/starships/3/",
            "https://swapi.py4e.com/api/starships/5/",
            /* …weitere… */
        ),
        vehicles = listOf(
            "https://swapi.py4e.com/api/vehicles/4/",
            "https://swapi.py4e.com/api/vehicles/6/",
            "https://swapi.py4e.com/api/vehicles/7/",
            "https://swapi.py4e.com/api/vehicles/8/"
        ),
        species = listOf(
            "https://swapi.py4e.com/api/species/1/",
            "https://swapi.py4e.com/api/species/2/",
            "https://swapi.py4e.com/api/species/3/",
            "https://swapi.py4e.com/api/species/4/",
            "https://swapi.py4e.com/api/species/5/"
        ),
        created = "2014-12-10T14:23:31.880000Z",
        edited  = "2014-12-20T19:49:45.256000Z",
        url     = "https://swapi.py4e.com/api/films/1/",
        filmImage = "https://lumiere-a.akamaihd.net/v1/images/poster-star-wars-episode-4_a29b329a.jpeg"
    ),

    // --- Episode V ----------------------------------------------------------
    Film(
        title = "The Empire Strikes Back",
        episode_id = 5,
        opening_crawl = "It is a dark time for the Rebellion…",
        director = "Irvin Kershner",
        producer = "Gary Kurtz, Rick McCallum",
        release_date = "1980-05-17",
        characters = listOf(
            "https://swapi.py4e.com/api/people/1/",
            "https://swapi.py4e.com/api/people/2/",
            /* … */
        ),
        planets = listOf(
            "https://swapi.py4e.com/api/planets/4/",
            "https://swapi.py4e.com/api/planets/5/",
            "https://swapi.py4e.com/api/planets/6/",
            "https://swapi.py4e.com/api/planets/27/"
        ),
        starships = listOf(
            "https://swapi.py4e.com/api/starships/3/",
            "https://swapi.py4e.com/api/starships/10/",
            /* … */
        ),
        vehicles = listOf(
            "https://swapi.py4e.com/api/vehicles/8/",
            "https://swapi.py4e.com/api/vehicles/14/",
            /* … */
        ),
        species = listOf(
            "https://swapi.py4e.com/api/species/1/",
            "https://swapi.py4e.com/api/species/2/",
            "https://swapi.py4e.com/api/species/3/",
            "https://swapi.py4e.com/api/species/6/",
            "https://swapi.py4e.com/api/species/7/"
        ),
        created = "2014-12-12T11:26:24.656000Z",
        edited  = "2014-12-15T13:07:53.386000Z",
        url     = "https://swapi.py4e.com/api/films/2/",
        filmImage = "https://lumiere-a.akamaihd.net/v1/images/image_24b0a6f0.jpeg"
    ),

    // --- Episode VI ---------------------------------------------------------
    Film(
        title = "Return of the Jedi",
        episode_id = 6,
        opening_crawl = "Luke Skywalker has returned to his home planet…",
        director = "Richard Marquand",
        producer = "Howard G. Kazanjian, George Lucas, Rick McCallum",
        release_date = "1983-05-25",
        characters = listOf(
            "https://swapi.py4e.com/api/people/1/",
            "https://swapi.py4e.com/api/people/2/",
            /* … */
        ),
        planets = listOf(
            "https://swapi.py4e.com/api/planets/4/",
            "https://swapi.py4e.com/api/planets/5/",
            "https://swapi.py4e.com/api/planets/6/",
            "https://swapi.py4e.com/api/planets/27/"
        ),
        starships = listOf(
            "https://swapi.py4e.com/api/starships/3/",
            "https://swapi.py4e.com/api/starships/10/",
            /* … */
        ),
        vehicles = listOf(
            "https://swapi.py4e.com/api/vehicles/8/",
            "https://swapi.py4e.com/api/vehicles/14/",
            /* … */
        ),
        species = listOf(
            "https://swapi.py4e.com/api/species/1/",
            "https://swapi.py4e.com/api/species/2/",
            "https://swapi.py4e.com/api/species/3/",
            "https://swapi.py4e.com/api/species/6/",
            "https://swapi.py4e.com/api/species/7/"
        ),
        created = "2014-12-12T11:26:24.656000Z",
        edited  = "2014-12-15T13:07:53.386000Z",
        url     = "https://swapi.py4e.com/api/films/2/",
        filmImage = "https://lumiere-a.akamaihd.net/v1/images/image_24b0a6f0.jpeg"
    ),

    // --- Episode I ----------------------------------------------------------
    Film(
        title = "The Phantom Menace",
        episode_id = 1,
        opening_crawl = "Turmoil has engulfed the Galactic Republic…",
        director = "George Lucas",
        producer = "Rick McCallum",
        release_date = "1999-05-19",
        characters = listOf(
            "https://swapi.py4e.com/api/people/1/",
            "https://swapi.py4e.com/api/people/2/",
            /* … */
        ),
        planets = listOf(
            "https://swapi.py4e.com/api/planets/4/",
            "https://swapi.py4e.com/api/planets/5/",
            "https://swapi.py4e.com/api/planets/6/",
            "https://swapi.py4e.com/api/planets/27/"
        ),
        starships = listOf(
            "https://swapi.py4e.com/api/starships/3/",
            "https://swapi.py4e.com/api/starships/10/",
            /* … */
        ),
        vehicles = listOf(
            "https://swapi.py4e.com/api/vehicles/8/",
            "https://swapi.py4e.com/api/vehicles/14/",
            /* … */
        ),
        species = listOf(
            "https://swapi.py4e.com/api/species/1/",
            "https://swapi.py4e.com/api/species/2/",
            "https://swapi.py4e.com/api/species/3/",
            "https://swapi.py4e.com/api/species/6/",
            "https://swapi.py4e.com/api/species/7/"
        ),
        created = "2014-12-12T11:26:24.656000Z",
        edited  = "2014-12-15T13:07:53.386000Z",
        url     = "https://swapi.py4e.com/api/films/2/",
        filmImage = "https://lumiere-a.akamaihd.net/v1/images/image_24b0a6f0.jpeg"
    ),
    // --- Episode II ---------------------------------------------------------
    Film(
        title = "Attack of the Clones",
        episode_id = 2,
        opening_crawl = "There is unrest in the Galactic Senate…",
        director = "George Lucas",
        producer = "Rick McCallum",
        release_date = "2002-05-16",
        characters = listOf(
            "https://swapi.py4e.com/api/people/1/",
            "https://swapi.py4e.com/api/people/2/",
            /* … */
        ),
        planets = listOf(
            "https://swapi.py4e.com/api/planets/4/",
            "https://swapi.py4e.com/api/planets/5/",
            "https://swapi.py4e.com/api/planets/6/",
            "https://swapi.py4e.com/api/planets/27/"
        ),
        starships = listOf(
            "https://swapi.py4e.com/api/starships/3/",
            "https://swapi.py4e.com/api/starships/10/",
            /* … */
        ),
        vehicles = listOf(
            "https://swapi.py4e.com/api/vehicles/8/",
            "https://swapi.py4e.com/api/vehicles/14/",
            /* … */
        ),
        species = listOf(
            "https://swapi.py4e.com/api/species/1/",
            "https://swapi.py4e.com/api/species/2/",
            "https://swapi.py4e.com/api/species/3/",
            "https://swapi.py4e.com/api/species/6/",
            "https://swapi.py4e.com/api/species/7/"
        ),
        created = "2014-12-12T11:26:24.656000Z",
        edited  = "2014-12-15T13:07:53.386000Z",
        url     = "https://swapi.py4e.com/api/films/2/",
        filmImage = "https://lumiere-a.akamaihd.net/v1/images/image_24b0a6f0.jpeg"
    ),

    // --- Episode III --------------------------------------------------------
    Film(
        title = "Revenge of the Sith",
        episode_id = 3,
        opening_crawl = "War! The Republic is crumbling under attacks by the ruthless Sith Lord…",
        director = "George Lucas",
        producer = "Rick McCallum",
        release_date = "2005-05-19",
        characters = listOf(
            "https://swapi.py4e.com/api/people/1/",
            "https://swapi.py4e.com/api/people/2/",
            /* … */
        ),
        planets = listOf(
            "https://swapi.py4e.com/api/planets/4/",
            "https://swapi.py4e.com/api/planets/5/",
            "https://swapi.py4e.com/api/planets/6/",
            "https://swapi.py4e.com/api/planets/27/"
        ),
        starships = listOf(
            "https://swapi.py4e.com/api/starships/3/",
            "https://swapi.py4e.com/api/starships/10/",
            /* … */
        ),
        vehicles = listOf(
            "https://swapi.py4e.com/api/vehicles/8/",
            "https://swapi.py4e.com/api/vehicles/14/",
            /* … */
        ),
        species = listOf(
            "https://swapi.py4e.com/api/species/1/",
            "https://swapi.py4e.com/api/species/2/",
            "https://swapi.py4e.com/api/species/3/",
            "https://swapi.py4e.com/api/species/6/",
            "https://swapi.py4e.com/api/species/7/"
        ),
        created = "2014-12-12T11:26:24.656000Z",
        edited  = "2014-12-15T13:07:53.386000Z",
        url     = "https://swapi.py4e.com/api/films/2/",
        filmImage = "https://lumiere-a.akamaihd.net/v1/images/image_24b0a6f0.jpeg"
    )
)


val dummyPlanets: List<Planet> = listOf(
    Planet(
        name = "Tatooine",
        rotation_period = "23",
        orbital_period = "304",
        diameter = "10465",
        climate = "arid",
        gravity = "1 standard",
        terrain = "desert",
        surface_water = "1",
        population = "200000",
        residents = listOf(
            "https://swapi.dev/api/people/1/",
            "https://swapi.dev/api/people/2/"
        ),
        films = listOf(
            "https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/3/"
        ),
        created = "2014-12-09T13:50:49.641000Z",
        edited = "2014-12-20T20:58:18.411000Z",
        url = "https://swapi.dev/api/planets/1/"
    ),
    Planet(
        name = "Alderaan",
        rotation_period = "24",
        orbital_period = "364",
        diameter = "12500",
        climate = "temperate",
        gravity = "1 standard",
        terrain = "grasslands, mountains",
        surface_water = "40",
        population = "2000000000",
        residents = listOf(
            "https://swapi.dev/api/people/5/"
        ),
        films = listOf(
            "https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/6/"
        ),
        created = "2014-12-10T11:35:48.479000Z",
        edited = "2014-12-20T20:58:18.420000Z",
        url = "https://swapi.dev/api/planets/2/"
    ),
    Planet(
        name = "Hoth",
        rotation_period = "23",
        orbital_period = "549",
        diameter = "7200",
        climate = "frozen",
        gravity = "1.1 standard",
        terrain = "tundra, ice caves, mountain ranges",
        surface_water = "100",
        population = "unknown",
        residents = listOf(),
        films = listOf(
            "https://swapi.dev/api/films/2/"
        ),
        created = "2014-12-10T11:39:13.934000Z",
        edited = "2014-12-20T20:58:18.423000Z",
        url = "https://swapi.dev/api/planets/4/"
    ),
    Planet(
        name = "Dagobah",
        rotation_period = "23",
        orbital_period = "341",
        diameter = "8900",
        climate = "murky",
        gravity = "N/A",
        terrain = "swamp, jungles",
        surface_water = "8",
        population = "unknown",
        residents = listOf(),
        films = listOf(
            "https://swapi.dev/api/films/2/",
            "https://swapi.dev/api/films/6/"
        ),
        created = "2014-12-10T11:42:22.590000Z",
        edited = "2014-12-20T20:58:18.425000Z",
        url = "https://swapi.dev/api/planets/5/"
    ),
    Planet(
        name = "Naboo",
        rotation_period = "26",
        orbital_period = "312",
        diameter = "12120",
        climate = "temperate",
        gravity = "1 standard",
        terrain = "grassy hills, swamps, forests, mountains",
        surface_water = "12",
        population = "4500000000",
        residents = listOf(
            "https://swapi.dev/api/people/3/",
            "https://swapi.dev/api/people/21/"
        ),
        films = listOf(
            "https://swapi.dev/api/films/4/",
            "https://swapi.dev/api/films/5/",
            "https://swapi.dev/api/films/6/"
        ),
        created = "2014-12-10T11:52:31.066000Z",
        edited = "2014-12-20T20:58:18.430000Z",
        url = "https://swapi.dev/api/planets/8/"
    )
)

val dummyCharacters: List<Character> = listOf(
    Character(
        name = "luke skywalker",
        height = "172",
        mass = "77",
        hair_color = "blond",
        skin_color = "fair",
        eye_color = "blue",
        birth_year = "19BBY",
        gender = "male",
        homeworld = "https://swapi.dev/api/planets/1/", // Tatooine
        films = listOf(
            "https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/2/",
            "https://swapi.dev/api/films/3/",
            "https://swapi.dev/api/films/6/"
        ),
        species = listOf(),
        vehicles = listOf(
            "https://swapi.dev/api/vehicles/14/", // Snowspeeder
            "https://swapi.dev/api/vehicles/30/"  // Imperial Speeder Bike
        ),
        starships = listOf(
            "https://swapi.dev/api/starships/12/", // X-wing
            "https://swapi.dev/api/starships/22/"  // Imperial shuttle
        ),
        created = "2014-12-09T13:50:51.644000Z",
        edited = "2014-12-20T21:17:56.891000Z",
        url = "https://swapi.dev/api/people/1/"
    ),
    Character(
        name = "leia organa",
        height = "150",
        mass = "49",
        hair_color = "brown",
        skin_color = "light",
        eye_color = "brown",
        birth_year = "19BBY",
        gender = "female",
        homeworld = "https://swapi.dev/api/planets/2/", // Alderaan
        films = listOf(
            "https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/2/",
            "https://swapi.dev/api/films/3/",
            "https://swapi.dev/api/films/6/"
        ),
        species = listOf(),
        vehicles = listOf(),
        starships = listOf(),
        created = "2014-12-10T15:20:09.791000Z",
        edited = "2014-12-20T21:17:50.315000Z",
        url = "https://swapi.dev/api/people/5/"
    ),
    Character(
        name = "han solo",
        height = "180",
        mass = "80",
        hair_color = "brown",
        skin_color = "fair",
        eye_color = "brown",
        birth_year = "29BBY",
        gender = "male",
        homeworld = "https://swapi.dev/api/planets/22/", // Corellia (nicht in SWAPI direkt, aber lore-korrekt)
        films = listOf(
            "https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/2/",
            "https://swapi.dev/api/films/3/"
        ),
        species = listOf(),
        vehicles = listOf(),
        starships = listOf("https://swapi.dev/api/starships/10/"), // Millennium Falcon
        created = "2014-12-10T16:49:14.582000Z",
        edited = "2014-12-20T21:17:50.334000Z",
        url = "https://swapi.dev/api/people/14/"
    ),
    Character(
        name = "obi-wan kenobi",
        height = "182",
        mass = "77",
        hair_color = "auburn, white",
        skin_color = "fair",
        eye_color = "blue-gray",
        birth_year = "57BBY",
        gender = "male",
        homeworld = "https://swapi.dev/api/planets/20/", // Stewjon
        films = listOf(
            "https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/2/",
            "https://swapi.dev/api/films/3/",
            "https://swapi.dev/api/films/4/",
            "https://swapi.dev/api/films/5/",
            "https://swapi.dev/api/films/6/"
        ),
        species = listOf(),
        vehicles = listOf(),
        starships = listOf("https://swapi.dev/api/starships/48/"),
        created = "2014-12-10T16:16:29.192000Z",
        edited = "2014-12-20T21:17:50.325000Z",
        url = "https://swapi.dev/api/people/10/"
    ),
    Character(
        name = "chewbacca",
        height = "228",
        mass = "112",
        hair_color = "brown",
        skin_color = "unknown",
        eye_color = "blue",
        birth_year = "200BBY",
        gender = "male",
        homeworld = "https://swapi.dev/api/planets/14/", // Kashyyyk
        films = listOf(
            "https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/2/",
            "https://swapi.dev/api/films/3/",
            "https://swapi.dev/api/films/6/"
        ),
        species = listOf("https://swapi.dev/api/species/3/"), // Wookiee
        vehicles = listOf("https://swapi.dev/api/vehicles/19/"), // AT-ST
        starships = listOf("https://swapi.dev/api/starships/10/"), // Millennium Falcon
        created = "2014-12-10T16:42:45.066000Z",
        edited = "2014-12-20T21:17:50.332000Z",
        url = "https://swapi.dev/api/people/13/"
    )
)

val dummySpecies: List<Species> = listOf(
    // --- Species 1 ----------------------------------------------------------
    Species(
        name = "Human",
        classification = "mammal",
        designation = "sentient",
        average_height = "180",
        skin_colors = "caucasian, black, asian, hispanic",
        hair_colors = "blonde, brown, black, red",
        eye_colors = "brown, blue, green, hazel, grey, amber",
        average_lifespan = "120",
        homeworld = "https://swapi.py4e.com/api/planets/9/",
        language = "Galactic Basic",
        people = listOf(                         // gekürzt!
            "https://swapi.py4e.com/api/people/1/",
            "https://swapi.py4e.com/api/people/4/",
            "https://swapi.py4e.com/api/people/5/"
        ),
        films = listOf(
            "https://swapi.py4e.com/api/films/1/",
            "https://swapi.py4e.com/api/films/2/",
            "https://swapi.py4e.com/api/films/3/",
            "https://swapi.py4e.com/api/films/4/",
            "https://swapi.py4e.com/api/films/5/",
            "https://swapi.py4e.com/api/films/6/",
            "https://swapi.py4e.com/api/films/7/"
        ),
        created = "2014-12-10T13:52:11.567000Z",
        edited  = "2014-12-20T21:36:42.136000Z",
        url     = "https://swapi.py4e.com/api/species/1/"
    ),

    // --- Species 2 ----------------------------------------------------------
    Species(
        name = "Droid",
        classification = "artificial",
        designation = "sentient",
        average_height = "n/a",
        skin_colors = "n/a",
        hair_colors = "n/a",
        eye_colors = "n/a",
        average_lifespan = "indefinite",
        homeworld = null,                       // laut API
        language = "n/a",
        people = listOf(
            "https://swapi.py4e.com/api/people/2/",
            "https://swapi.py4e.com/api/people/3/",
            "https://swapi.py4e.com/api/people/8/"
        ),
        films = listOf(
            "https://swapi.py4e.com/api/films/1/",
            "https://swapi.py4e.com/api/films/2/",
            "https://swapi.py4e.com/api/films/3/",
            "https://swapi.py4e.com/api/films/4/",
            "https://swapi.py4e.com/api/films/5/",
            "https://swapi.py4e.com/api/films/6/",
            "https://swapi.py4e.com/api/films/7/"
        ),
        created = "2014-12-10T15:16:16.259000Z",
        edited  = "2014-12-20T21:36:42.139000Z",
        url     = "https://swapi.py4e.com/api/species/2/"
    ),

    // --- Species 3 ----------------------------------------------------------
    Species(
        name = "Wookiee",
        classification = "mammal",
        designation = "sentient",
        average_height = "210",
        skin_colors = "gray",
        hair_colors = "black, brown",
        eye_colors = "blue, green, yellow, brown, golden, red",
        average_lifespan = "400",
        homeworld = "https://swapi.py4e.com/api/planets/14/",
        language = "Shyriiwook",
        people = listOf(
            "https://swapi.py4e.com/api/people/13/",
            "https://swapi.py4e.com/api/people/80/"
        ),
        films = listOf(
            "https://swapi.py4e.com/api/films/1/",
            "https://swapi.py4e.com/api/films/2/",
            "https://swapi.py4e.com/api/films/3/",
            "https://swapi.py4e.com/api/films/6/",
            "https://swapi.py4e.com/api/films/7/"
        ),
        created = "2014-12-10T16:44:31.486000Z",
        edited  = "2014-12-20T21:36:42.142000Z",
        url     = "https://swapi.py4e.com/api/species/3/"
    ),

    // --- Species 4 ----------------------------------------------------------
    Species(
        name = "Rodian",
        classification = "sentient",
        designation = "reptilian",
        average_height = "170",
        skin_colors = "green, blue",
        hair_colors = "n/a",
        eye_colors = "black",
        average_lifespan = "unknown",
        homeworld = "https://swapi.py4e.com/api/planets/23/",
        language = "Galatic Basic",
        people = listOf(
            "https://swapi.py4e.com/api/people/15/"
        ),
        films = listOf(
            "https://swapi.py4e.com/api/films/1/"
        ),
        created = "2014-12-10T17:05:26.471000Z",
        edited  = "2014-12-20T21:36:42.144000Z",
        url     = "https://swapi.py4e.com/api/species/4/"
    )
)
