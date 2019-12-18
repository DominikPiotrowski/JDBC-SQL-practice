package queries;

import models.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ActorInsert {

    public static List<Actor> createActorsToAdd() {
        List<Actor> actors = new ArrayList<>();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Actor actor1 = new Actor();
        actor1.setFirst_name("Zenek");
        actor1.setLast_name("DeNierob");
        actor1.setLast_update(timestamp);
        actors.add(actor1);

        Actor actor2 = new Actor();
        actor2.setFirst_name("Jasiu");
        actor2.setLast_name("Paczino");
        actor2.setLast_update(timestamp);
        actors.add(actor2);

        return actors;
    }

    public static void addActorsInBatch(Connection connection, List<Actor> actors) throws SQLException {
        connection.setAutoCommit(false);

        String query = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        for (Actor actor : actors) {
            statement.setString(1, actor.getFirst_name());
            statement.setString(2, actor.getLast_name());
            statement.setTimestamp(3, actor.getLast_update());
            statement.addBatch();
        }
        int[] results = statement.executeBatch();

        if (results.length == actors.size()) {
            System.out.println("Done.");
        }
        connection.commit();
    }
}
