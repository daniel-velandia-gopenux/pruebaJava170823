package com.example.movies.data.model;

import com.example.movies.R;

import java.util.ArrayList;
import java.util.List;

public class MovieProvider {

    public static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie("THE GODFATHER", R.drawable.the_godfather, "In the summer of 1945, the wedding of Connie (Talia Shire) and Carlo Rizzi (Gianni Russo) takes place. Connie is the only daughter of Don Vito Corleone (Marlon Brando), head of one of the families that command the Cosa Nostra in New York City. Don Vito also has three other children: his eldest son Sonny (James Caan), the puny Fredo (John Cazale) and the youngest of all, Michael (Al Pacino), a Marine decorated for his fight in World War II who has just finished. return home to New York. By designs of fortune, Michael will end up leading the life he did not want, taking the reins of the family business, changing his morals and his values, to defend his family at all costs."));
        movies.add(new Movie("SCHINDLER'S LIST", R.drawable.schindlers_list, "September 1939. The Nazis invade Poland. Jews are interned in ghettos and sent to concentration camps. German businessman Oskar Schindler (Liam Neeson), an opportunistic dandy with a talent for public relations, takes advantage of this situation to prosper financially. Thus, he begins an interested relationship with the most powerful Nazi military to start a factory in Krakow, whose workforce will be Jewish workers from concentration camps."));
        movies.add(new Movie("THE GODFATHER. PART II", R.drawable.the_godfather_part_ii, "After the death of Don Vito Corleone (Marlon Brando), his son Michael (Al Pacino, 'Jack and his twin') becomes the head of the family. Having to negotiate with the Jewish mob, he loses the support of one of his men, Frankie Pentageli (Michael V. Gazzo, 'Last Action Hero'). After narrowly escaping an attack, Michael tries to find the culprit, the biggest suspect being Hyman Roth (Lee Strasberg, 'The Godfather. Part III'), the head of the Jewish mafia."));
        movies.add(new Movie("LIFE IMPRISONMENT", R.drawable.life_imprisonment, "In 1947, Andy Dufresne (Tim Robbins), a young banker, is sentenced to life in prison for murdering his wife and her lover. Despite pleading not guilty, he is incarcerated in Shawshank, the toughest penitentiary in the state of Maine. There he will meet Red Redding (Morgan Freeman), a disillusioned man, imprisoned for more than twenty years. It is when a great story of friendship between the two men begins, without a past, a present and a future. Andy Dufresne will have no choice but to get used to his terrible situation, where, at least, his partner Redding will be of great help."));
        movies.add(new Movie("FORREST GUMP", R.drawable.forrest_gump, "Al tener el coeficiente intelectual de un niño, Forrest Gump siempre ha sido considerado el “tonto” de clase. Bajo las faldas de su madre se siente protegido y junto a su amiga Jenny es feliz, aunque en su propio mundo. Un problema en su columna vertebral no le impide convertirse en un ágil corredor. Ya más mayor, Forrest luchará en la guerra de Vietnam y conocerá al mismísimo presidente de los Estados Unidos. Llegará a ser muy rico, pero para Forrest hay algo que no cambia: el amor de su vida es y será Jenny."));
        movies.add(new Movie("LIFE IS BEAUTIFUL", R.drawable.life_is_beautiful, "World War II is about to break out in Europe. Meanwhile, Guido arrives in an Italian town with the intention of opening a bookstore. There he falls in love with the girlfriend of an Italian fascist, Dora. She will succumb to his charms and Guido gets her to marry him."));
        movies.add(new Movie("THE LION KING", R.drawable.the_lion_king, "Recovery of the 1994 Disney classic, adapted to the new generations thanks to 3-D technology. The animation production company thus follows the path it undertook with 'Beauty and the Beast' of adapting its most popular films to this technology so that new viewers can enjoy it better (and get performance, now that we are in a time of crisis, to the safe bets of his wardrobe)."));
        movies.add(new Movie("GLADIATOR", R.drawable.gladiator, "In the year 180 the Roman Empire controlled the entire world known to date. Maximus, played by the well-known Russell Crowe, is a very important Roman General for the Emperor Marcus Aurelius, since only he has achieved victory after victory, standing out for his courage, dedication and loyalty to the Empire. Commodus, the son of Marcus Aurelius, is jealous of Máximo's prestige and his father's love for him, so when he unexpectedly assumes power, he orders the general's arrest and execution. Máximo manages to escape from his oppressors, but he cannot prevent them from murdering his family. Later, he is captured by a slave trader and becomes a gladiator, preparing for his revenge."));
        movies.add(new Movie("ONE OF OURS", R.drawable.one_of_ours, "'Goodfellas is a movie based on the book by Nicholas Pileggi called \"Wiseguy.\" Henry Hill, is an aspiring mobster who tries to make his way along with his friends, Jimmy Conway and Tommy De Vito, in the difficult hierarchy of the mob. To do this, they must strike several blows, entering increasingly dangerous businesses. Henry eventually ends up in the FBI's witness protection program after testifying against his former associates."));
        movies.add(new Movie("THE DARK KNIGHT", R.drawable.the_dark_knight, "After defeating the Order of Shadows and thwarting mob boss Carmine Falcone in 'Batman Begins,' Bruce Wayne dons the Batman suit again to fight crime in Gotham.\n" + "\n" + "With Falcone gone, mobster Salvatore Maroni has taken control of the city and it seems that Batman's fight against criminals will be endless. Luckily, the city now has Harvey Dent, a new District Attorney characterized by his strong hand against crime, which gives an air of hope to Gotham and allows Bruce to focus on Rachel Dawes, the love of his life and the only one who knows his true identity."));

        return movies;
    }
}