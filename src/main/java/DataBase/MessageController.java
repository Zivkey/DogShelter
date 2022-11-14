package DataBase;

import Entities.Message;
import Enums.MessageType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageController {
    public static Connection connection;

    public static void addMessage(Message message) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO message (user_id, message_type, message_title, message_text)" +
                    " VALUES (?, ?, ?, ?)");
            stmt.setInt(1, message.getUserId());
            stmt.setString(2, String.valueOf(message.getMessageType()));
            stmt.setString(3, message.getTitle());
            stmt.setString(4, message.getText());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Message> readMessager() {
        List<Message> messageList = new ArrayList<>();
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM message");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("message_id"));
                message.setUserId(rs.getInt("user_id"));
                message.setMessageType(MessageType.valueOf(rs.getString("message_type")));
                message.setTitle(rs.getString("message_title"));
                message.setText(rs.getString("message_text"));
                messageList.add(message);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messageList;
    }

    public static void deleteMessage(Message message) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM message WHERE message_id = ?");
            stmt.setInt(1, message.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
