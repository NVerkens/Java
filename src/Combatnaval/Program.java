package Combatnaval;

public class Program {
    public static void main(String[] args) {
        System.out.println("Hello World !\n");
        System.out.println();
        System.out.println("initialisation du jeu\n"); // ";" = fin d'instruction
        // / "{}" contenant de l'instruction

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

    }
}
