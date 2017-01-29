package questioneditor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class util {
	private static String ip;
	private static String user;
	private static String pass;

	static boolean testServerConnection(String i, String u, String p) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + i + "/QuestionWriter", u, p)) {
			if (conn != null) {
				ip = i;
				user = u;
				pass = p;

				return true;
			} else {
				return false;
			}
		}
	}

	private static String[] listColumns(String table) {
		List<String> list = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/QuestionWriter", user, pass)) {
			try (Statement stmt = conn.createStatement()) {
				try (ResultSet rs = stmt.executeQuery("DESC " + table)) {
					while (rs.next()) {
						list.add(rs.getString("Field"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list.toArray(new String[list.size()]);
	}

	static String[] sqlQuery(String query) {
		List<String> list = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/QuestionWriter", user, pass)) {
			try (Statement stmt = conn.createStatement()) {
				try (ResultSet rs = stmt.executeQuery(query)) {
					String[] temp = query.split(" ");

					if (temp[1].equals("*")) {
						String table = "";

						for (int i = 0; i < temp.length; i++) {
							if (temp[i].equals("FROM")) {
								table = temp[i + 1];
								break;
							}
						}

						String[] column = util.listColumns(table);
						while (rs.next()) {
							for (int i = 0; i < column.length; i++) {
								list.add(rs.getString(column[i]));
							}
						}
					} else {
						int i;
						for (i = 0; i < temp.length; i++) {
							if (temp[i].equals("AS")) {
								break;
							}
						}

						while (rs.next()) {
							if (i < temp.length) {
								list.add(rs.getString(temp[i + 1]));
							} else {
								if (temp[1].equals("DISTINCT")) {
									list.add(rs.getString(temp[2]));
								} else {
									list.add(rs.getString(temp[1]));
								}
							}
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list.toArray(new String[list.size()]);
	}

	static boolean sqlUpdate(String update) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/QuestionWriter", user, pass)) {
			try (Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(update);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
