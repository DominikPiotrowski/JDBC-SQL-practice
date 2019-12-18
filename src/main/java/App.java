import queries.ActorInsert;
import queries.ActorQueries;
import queries.CityQueries;
import queries.FilmQueries;
import transaction.CustomerUpdate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.establishConnection();

        ActorQueries.showAny10Actors(connection);
        ActorQueries.showActorsNameZero(connection);
        ActorQueries.showActorByGivenFirstName(connection, "Ed");
        ActorQueries.actorsInAlphabeticalOrder(connection);

        ActorInsert.addActorsInBatch(connection, ActorInsert.createActorsToAdd());

//*******************************************************************

        System.out.println("Enter name to lock for actors");
        Scanner scannerNameToFind = new Scanner(System.in);
        String name = scannerNameToFind.nextLine();

        ActorQueries.countActorsByName(connection, name);

//*******************************************************************

        System.out.println("Enter 'before' date: ");
        Scanner scannerDateBefore = new Scanner(System.in);
        Timestamp before = Timestamp.valueOf(scannerDateBefore.nextLine());

        System.out.println("Enter 'after' date: ");
        Scanner scannerDateAfter = new Scanner(System.in);
        Timestamp after = Timestamp.valueOf(scannerDateAfter.nextLine());

        ActorQueries.showActorsUpdatedInGivenTime(connection, before, after);

//*******************************************************************

        System.out.println("Enter last name of actor to find: ");
        Scanner scannerL = new Scanner(System.in);
        String lastNameToFind = scannerL.nextLine();

        System.out.println("Enter first name you want to change into: ");
        Scanner scannerF = new Scanner(System.in);
        String firstNameToUpdate = scannerF.nextLine();

        ActorQueries.uppdateActorFirstNameByGivenLastName(connection, firstNameToUpdate, lastNameToFind);

//*******************************************************************

        System.out.println("Enter first name of actor to delete:");
        Scanner scannerFN = new Scanner(System.in);
        String firstNameToDelete = scannerFN.nextLine();

        System.out.println("Enter last name of actor to delete:");
        Scanner scannerLN = new Scanner(System.in);
        String lastNameToDelete = scannerLN.nextLine();

        ActorQueries.deleteActor(connection, firstNameToDelete, lastNameToDelete);

//*******************************************************************

        CityQueries.citiesInAlphabeticOrder(connection);

        System.out.println("Enter name of country to look for cities: ");
        Scanner scannerC = new Scanner(System.in);
        String countryEntered = scannerC.nextLine();
        CityQueries.getCitiesByCountry(connection, countryEntered);

//*******************************************************************

        System.out.println("Please enter requested rating: 1 = G, 2 = PG, 3 = PG-13, 4 = NC-17, 5 = R" + "\n");
        Scanner scanner2 = new Scanner(System.in);
        int entered = scanner2.nextInt();

        String rating = null;

        if (entered == 1) {
            rating = "G";
        } else if (entered == 2) {
            rating = "PG";
        } else if (entered == 3) {
            rating = "PG-13";
        } else if (entered == 4) {
            rating = "NC-17";
        } else if (entered == 5) {
            rating = "R";
        } else {
            System.out.println("Incorrect choice");
        }

        System.out.println("Results are: " + "\n");
        FilmQueries.getFilmByRating(connection, rating);


        CustomerUpdate.doRollback(connection, "ADAMS", "adams@smada.com");

    }
}
