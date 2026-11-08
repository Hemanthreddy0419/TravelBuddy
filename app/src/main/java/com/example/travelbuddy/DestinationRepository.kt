package com.example.travelbuddy

/**
 * Hard-coded mock data source. In a later version this could be replaced
 * by a Room database or a network call without touching the UI code.
 */
object DestinationRepository {

    val destinations: List<Destination> = listOf(
        Destination(
            id = 1,
            name = "Kyoto",
            country = "Japan",
            emoji = "⛩️",
            tagline = "Temples, tea houses and timeless streets",
            description = "Kyoto was Japan's capital for over a thousand years and it shows. " +
                "Wander through thousands of shrines, stroll the bamboo groves of Arashiyama, " +
                "and spot geisha in the lantern-lit lanes of Gion. Spring cherry blossoms and " +
                "autumn leaves make it unforgettable.",
            bestSeason = "March – May, October – November",
            budget = "$$",
            rating = 4.9f,
            wikiTitle = "Kyoto"
        ),
        Destination(
            id = 2,
            name = "Santorini",
            country = "Greece",
            emoji = "🏝️",
            tagline = "White domes above a deep blue sea",
            description = "Perched on the rim of a volcanic caldera, Santorini is famous for its " +
                "whitewashed villages, blue-domed churches and legendary sunsets in Oia. " +
                "Spend your days on black-sand beaches and your evenings tasting local wine.",
            bestSeason = "April – October",
            budget = "$$$",
            rating = 4.7f,
            wikiTitle = "Santorini"
        ),
        Destination(
            id = 3,
            name = "Machu Picchu",
            country = "Peru",
            emoji = "🏔️",
            tagline = "The lost city of the Incas",
            description = "High in the Andes, this 15th-century citadel sits among misty peaks. " +
                "Hike the classic Inca Trail or take the train from Cusco, and arrive early " +
                "to watch the sunrise light up the ancient terraces.",
            bestSeason = "May – September",
            budget = "$$",
            rating = 4.9f,
            wikiTitle = "Machu_Picchu"
        ),
        Destination(
            id = 4,
            name = "Banff",
            country = "Canada",
            emoji = "🦌",
            tagline = "Turquoise lakes in the Rocky Mountains",
            description = "Banff National Park is a playground of glaciers, emerald lakes and " +
                "wildlife. Canoe on Lake Louise, soak in the hot springs, and ski some of " +
                "the best slopes in North America in winter.",
            bestSeason = "June – August, December – March",
            budget = "$$$",
            rating = 4.8f,
            wikiTitle = "Banff,_Alberta"
        ),
        Destination(
            id = 5,
            name = "Marrakech",
            country = "Morocco",
            emoji = "🕌",
            tagline = "Souks, spices and riads",
            description = "The Red City buzzes with energy. Lose yourself in the maze-like souks, " +
                "watch storytellers and musicians in Jemaa el-Fnaa square, and rest in a quiet " +
                "riad courtyard with a glass of mint tea.",
            bestSeason = "March – May, September – November",
            budget = "$",
            rating = 4.5f,
            wikiTitle = "Marrakesh"
        ),
        Destination(
            id = 6,
            name = "Bali",
            country = "Indonesia",
            emoji = "🌴",
            tagline = "Rice terraces, surf and spirituality",
            description = "The Island of the Gods blends lush jungle, volcanic peaks and beautiful " +
                "beaches. Visit the temples of Ubud, surf at Uluwatu and enjoy the relaxed " +
                "island rhythm and warm hospitality.",
            bestSeason = "April – October",
            budget = "$",
            rating = 4.6f,
            wikiTitle = "Bali"
        ),
        Destination(
            id = 7,
            name = "Reykjavik",
            country = "Iceland",
            emoji = "🌌",
            tagline = "Northern lights and geothermal wonders",
            description = "The world's northernmost capital is the gateway to glaciers, geysers and " +
                "waterfalls. Chase the aurora in winter or enjoy the midnight sun in summer, " +
                "and relax in the famous Blue Lagoon.",
            bestSeason = "June – August, September – March for auroras",
            budget = "$$$",
            rating = 4.7f,
            wikiTitle = "Reykjav%C3%ADk"
        ),
        Destination(
            id = 8,
            name = "Cape Town",
            country = "South Africa",
            emoji = "🦁",
            tagline = "Where mountain meets ocean",
            description = "Overlooked by Table Mountain, Cape Town combines beaches, vineyards and " +
                "vibrant culture. Take the cable car up the mountain, meet penguins at Boulders " +
                "Beach and drive the scenic Cape Peninsula.",
            bestSeason = "November – March",
            budget = "$$",
            rating = 4.6f,
            wikiTitle = "Cape_Town"
        ),
        Destination(
            id = 9,
            name = "Venice",
            country = "Italy",
            emoji = "🚣",
            tagline = "A city built on water",
            description = "Venice is a living museum of canals, bridges and palazzos. Glide down the " +
                "Grand Canal, admire St. Mark's Basilica, and get lost in quiet backstreets " +
                "away from the crowds.",
            bestSeason = "April – June, September – October",
            budget = "$$$",
            rating = 4.5f,
            wikiTitle = "Venice"
        ),
        Destination(
            id = 10,
            name = "Jaipur",
            country = "India",
            emoji = "🏰",
            tagline = "The Pink City of palaces and forts",
            description = "The capital of Rajasthan is famed for its rose-pink old city, the Amber " +
                "Fort and the grand City Palace. Shop for textiles and jewellery in the " +
                "bazaars and sample rich Rajasthani food.",
            bestSeason = "October – March",
            budget = "$",
            rating = 4.6f,
            wikiTitle = "Jaipur"
        ),
        Destination(
            id = 11,
            name = "Sydney",
            country = "Australia",
            emoji = "🦘",
            tagline = "Harbour views and golden beaches",
            description = "Sydney's skyline is crowned by the Opera House and Harbour Bridge. " +
                "Walk the coastal path from Bondi to Coogee, catch a ferry across the harbour " +
                "and enjoy a relaxed outdoor lifestyle.",
            bestSeason = "September – November, March – May",
            budget = "$$$",
            rating = 4.6f,
            wikiTitle = "Sydney"
        ),
        Destination(
            id = 12,
            name = "Paris",
            country = "France",
            emoji = "🗼",
            tagline = "Art, cafés and the City of Light",
            description = "From the Eiffel Tower to the Louvre, Paris is packed with icons. " +
                "Stroll along the Seine, linger in a sidewalk café and browse the " +
                "charming neighbourhoods of Montmartre and Le Marais.",
            bestSeason = "April – June, September – October",
            budget = "$$$",
            rating = 4.7f,
            wikiTitle = "Paris"
        )
    )

    /** Look up a destination by its id, or null if it does not exist. */
    fun findById(id: Int): Destination? = destinations.firstOrNull { it.id == id }
}
