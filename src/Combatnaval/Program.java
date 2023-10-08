package Combatnaval;

import java.util.Arrays;

public class Program {
    /**
     * Point de démarrage du programme
     * @param args Arguments reçus depuis la ligne de commande
     */
    public static void main(String[] args) {
        System.out.println("Premier programme en Java : touché-coulé !");
        System.out.println();
        System.out.println("Initialisation du jeu... \n");

        // Déclaration et initialisation de J1_Points (nombre de points du joueur 1)
        var J1_Points = 0;
        /*
            Idem pour J2_Points
            Nombre de points du joueur 2
         */
        var J2_Points = J1_Points; // J2_Points est initialisé à la même valeur que J1_Points

        char[] J1_Grid;
        char[] J2_Grid;

        J1_Grid = setGrid("Joueur 1");
        System.out.println();
        J2_Grid = setGrid("Joueur 2");


    }


    static char[] setGrid(String player){
        // Déclaration des types de bateau et leur taille
        final var CARRIER =  5;
        final int BATTLESHIP; // = 4;
        final int DESTROYER; // = 3;
        final int SUBMARINE; // = 3;
        final int PATROL; // = 2;

        final var BOATS = new int[] {CARRIER , BATTLESHIP = 4, DESTROYER = 3, SUBMARINE = 3, PATROL = 2};
        // BOATS[0] += 7;

        // Déclaration d'une constante
        // final var MAX_POINTS = CARRIER + BATTLESHIP + DESTROYER + SUBMARINE + PATROL;
        final var MAX_POINTS = computeSum(BOATS);

        // Création d'un tableau de caractères pour la grille d'attaque
        var grilleAttaque = new char[100];

        // Création d'un tableau de caractères pour la grille des bateaux
        var grilleBateaux = new char[100];

        // Remplissage de la grille d'attaque avec des '.'
        for (var x = 0 ; x < grilleAttaque.length; x++ ) {
            grilleAttaque[x] = '.';
        }

        // Remplissage de la grille de nos bateaux avec des '.'
        Arrays.fill(grilleBateaux, '.');

        // Affichage du tableau par ligne de 10 colonnes pour la grille d'attaque
        System.out.printf("Grille d'attaque de %s\n", player);
        displayGrid(grilleAttaque);
        // System.out.println();

        // Affichage du tableau par ligne de 10 colonnes pour la grille des bateaux
        // System.out.println("Grille des bateaux");
        // displayGrid(grilleBateaux);

        // Placement des bateaux
        // System.out.println("\nPlacement des bateaux...");
        for (var bateau : BOATS)
            setBoats(grilleBateaux, bateau);

        System.out.printf("\nGrille des bateaux de %s\n", player);
        displayGrid(grilleBateaux);
        return grilleBateaux;
    }



    /**
     * Cette fonction permet de placer les bateaux sur la grille.
     * Les bateaux ne peuvent pas se croiser
     * @param tableau La grille sur laquelle on va placer le bateau
     * @param taille Taille du bateau à placer
     */
    static void setBoats(char[] tableau, int taille) {
        boolean isBoatSet;
        do {
            var cell = -1;
        /*
        do {
            cell = (int) (Math.random() * tableau.length);
        } while (tableau[cell] != '.');
         */
            while (tableau[cell = (int) (Math.random() * tableau.length)] != '.') ;
            //var direction = (int) (Math.random() * 4);
            var direction = DIRECTION.values()[(int) (Math.random() * 4)];
            // System.out.printf("Cell : %2d | Taille : %1d | Direction : %s%n", cell, taille, direction);
            isBoatSet = false;
            switch (direction) {
                case UP -> {
                    if (cell >= (taille - 1) * 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell - (taille - 1) * 10, cell, 10);
                    }
                }
                case LEFT -> {
                    if (cell > 9 && (cell - taille + 1) % 10 < cell % 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell - taille + 1, cell, 1);
                    }
                }
                case RIGHT -> {
                    if (cell < 90 && (cell + taille - 1) % 10 > cell % 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell, cell + taille - 1, 1);
                    }
                }
                case BOTTOM -> {
                    if (cell < 100 - (taille - 1) * 10) {
                        isBoatSet = isBoatSet(tableau, taille, cell, cell + (taille - 1) * 10, 10);
                    }
                }
            }
        } while (! isBoatSet);
    }

    /**
     * Cette fonction vérifie que le bateau peut être placé comme souhaité et si c'est le cas, le bateau est encodé dans la grille
     * @param tableau La grille sur laquelle on va placer le bateau
     * @param taille Nombre de cases pour le bateau
     * @param start Case de départ pour le placement du bateau
     * @param end Case d'arrivée pour le placement sdu bateau
     * @param step Pas pour le calcul de la prochaine case
     * @return True si le bateau a pu être placé comme demandé
     */
    static boolean isBoatSet(char[] tableau, int taille, int start, int end, int step) {
        // On vérifie que toutes les cases nécessaires pour mettre le bateau soient disponibles
        for (var cell = start; cell <= end; cell += step) {
            if (tableau[cell] != '.')
                return false;
        }
        // On place le bateau dans le tableau
        for (var cell = start; cell <= end; cell += step) {
            tableau[cell] = (char) ('0' + taille);
        }
        return true;
    }

    /**
     * Calcule la somme des valeurs dans le tableau
     * @param tableau Le tableau qui contient les valeurs
     * @return La somme des valeurs dans le tableau
     */
    static int computeSum(int[] tableau) {
        var retour = 0;
        // for-each
        for (var valeur : tableau)
            retour += valeur;
        return retour;
    }

    // byte, short, char, int, long, float, double, boolean
    // Byte, Short, Character, Integer, Long, Float, Double, Boolean

    /**
     * Cette fonction permet d'afficher une grille avec les entêtes
     * @param tableau Le tableau à afficher
     */
    static void displayGrid (char[] tableau) {
        System.out.print("\t"); // Placement d'une tabulation
        for (char lettre = 'A'; lettre < 'A' + 10; System.out.print(lettre + " "), lettre++); // On affiche les lettres des colonnes
        System.out.println();
        for (var i = 0; i < tableau.length; i++) {
            if (i % 10 == 0) {
                System.out.printf(" %2d ", i / 10 + 1);
            }
            System.out.print(tableau[i] + " ");
            if (i % 10 == 9)
                System.out.println();
        }
    }
}
