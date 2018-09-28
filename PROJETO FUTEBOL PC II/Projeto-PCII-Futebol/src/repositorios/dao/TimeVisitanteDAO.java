package repositorios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import repositorios.bean.TimeVisitante;

public class TimeVisitanteDAO {
	
	public void create(TimeVisitante tv) {
			
			Connection con = ConnectionFactory.open();
			PreparedStatement pstmt = null;
			
			try {
				
				pstmt = con.prepareStatement("INSERT INTO TbTimeVisitante VALUES (?, ?)");
				
				pstmt.setString(1, tv.getNmTime());
				pstmt.setString(2, tv.getCidade());
				
				pstmt.executeUpdate();
				
				//JOptionPane.showMessageDialog (null,"Salvo!");
			
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog (null,"ERROR! " + e);
			
			}finally {
				
				ConnectionFactory.closeConnection(con, pstmt);
			}
		}
}
