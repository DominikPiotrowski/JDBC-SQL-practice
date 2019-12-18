package mappers;

import models.Actor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper {

    public static Actor map(ResultSet resultSet) throws SQLException {
        Actor actor = new Actor();

        actor.setActor_id(resultSet.getInt(1));
        actor.setFirst_name(resultSet.getString(2));
        actor.setLast_name(resultSet.getString(3));
        actor.setLast_update(resultSet.getTimestamp(4));

        return actor;
    }
}
