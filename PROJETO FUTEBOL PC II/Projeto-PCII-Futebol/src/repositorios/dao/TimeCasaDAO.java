package repositorios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import repositorios.bean.BatedorBean;
import repositorios.bean.TimeCasa;

public class TimeCasaDAO {
	
	public void create(TimeCasa tc) {
		
		Connection con = ConnectionFactory.open();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = con.prepareStatement("INSERT INTO TbTimeCasa VALUES (?, ?)");
			
			pstmt.setString(1, tc.getNmTime());
			pstmt.setString(2, tc.getCidade());
			
			pstmt.executeUpdate();
			
			//JOptionPane.showMessageDialog (null,"Salvo!");
		
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog (null,"ERROR! " + e);
		
		}finally {
			
			ConnectionFactory.closeConnection(con, pstmt);
		}
	}
}
