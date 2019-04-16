package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

public class ICICIAccGenerator extends IdentityGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor s, Object obj) {
		// TODO Auto-generated method stub
		
		String name = "ICICI";
		// get next seq
		// append to ICICI STRING
		// send to table
		try {
			
		
		Connection c = s.connection();
		Statement st = c.createStatement();
		
		ResultSet rs = st.executeQuery("select * from iciciacc");
		System.out.println(rs.getString(1));
		if(rs.next())
		{
			name+=rs.getInt(1);
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return super.generate(s, obj);
	}
}
