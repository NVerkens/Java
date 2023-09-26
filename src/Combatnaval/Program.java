package Combatnaval;

import jdk.jshell.EvalException;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println("Hello World !\n");
        System.out.println();
        System.out.println("Initialisation du jeu\n"); // ";" = fin d'instruction
        // / "{}" contenant/bloc de l'instruction

        // Déclarations et initialisation de J1_Points
        var J1_Points = 0f;
        /*
            Idem pour J2_Points
            Nombre de joueur 2
         */
        var J2_Points = J1_Points; // commentaire dans une ligne de code

        /* pas de programme avec accent + chaque caractère de string est encodé sur 2 byte */

        // Déclaration de constante
        final var MAX_POINTS = 5 + 4 + 3 + 3 + 2;

        // Création d'un tableau pour la grille d'attaque
        var GrilleAttaque = new char[100];

        // Création d'une tableau de caractères pour la grille des bateaux
        var GrilleBateaux = new char[100];

        // Remplissage de la ligne d'attaque avec des '.'
        // for ( initialisation de variabe; conditions d'arret de la boucle ;
        // l'instruction post itération );
        for (var x = 0; x < GrilleAttaque.length; x++) {
            // return
            // break : conditions de sortie
            GrilleAttaque[x] = '.';
        }

        // remplissage de la grilles de nos bateaux avec des '.'
        Arrays.fill(GrilleBateaux, '.');


        // affichage du tableaux
        // System.out.println(Arrays.toString(GrilleBateaux));

        // Affichage du tableau par ligne de 10 colonnes pour la grille d'attaque
        System.out.println("Grille d'attaque");
        displayGrid(GrilleAttaque);

        // Affichage du tableau par ligne de 10 colonnes pour la grille de bateaux
        System.out.println("Grille Bateaux");

        // on affiche les lettres
        displayGrid(GrilleBateaux);
    }

    // création d'une fonction

    /**
     * Cette fonction permet d'afficher une grille avec les entêtes
     *
     * @param tableau Le tableau à afficher
     */
    static void displayGrid(char[] tableau) { // premier mot toujours en minuscule et camel case
        System.out.print("\t"); // placement d'une tabulation
        for (char lettre = 'A'; lettre < 'A' + 10; System.out.print(lettre++ + " "))
            ; // ou sout(" " + lettre), lettre++);
        System.out.println();
        for (var i = 0; i < tableau.length; i++) {
            if (i % 10 == 0) {
//                if (i < 90) System.out.print(" ");
                //               System.out.print(i / 10 + 1);
                System.out.printf(" %2d ", i / 10 + 1); // formatage equivalent de f en python
            }
            System.out.print(tableau[i] + " ");
            if (i % 10 == 9)
                System.out.println();
        }
    }
}

        // les opérateurs binaires
        // var a = 0;
        // var b = O;
        // a = b++; // a = b, b = b + 1 donc a = 0,  b = 1
        // a = ++b; // b = b + 1, a = b donc a et b = 1

