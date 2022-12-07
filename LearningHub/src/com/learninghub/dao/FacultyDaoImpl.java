package com.learninghub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learninghub.exceptions.FacultyException;
import com.learninghub.extrafeatures.PasswordGenerator;
import com.learninghub.extrafeatures.Style;
import com.learninghub.model.Faculty;
import com.learninghub.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao {

	
	/* ---------------------------------------------       Create Faculty       ------------------------------------------------------- */
	@Override
	public String addFaculty(Faculty faculty) throws FacultyException{

		String message = Style.RED+"Data Not Inserted..."+Style.RESET;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			Statement statement = conn.createStatement();
            String sql = "SELECT MAX( facultyId ) FROM faculty";
            
            ResultSet result = statement.executeQuery(sql);
            
            Integer id = 0;
            
            if(result.next()) {
            	id = result.getInt("max( facultyId )");
            }
            
            id = id + 1;
            String text = String.format("%03d", id);
			String fname = faculty.getFname().toLowerCase();
			String username = fname + text;
			String password = PasswordGenerator.genPass(8);
			
			PreparedStatement ps1 = conn .prepareStatement("insert into Faculty(facultyFname, facultyLname, facultyAddress, facultyState, facultyPin, mobile, email, username, password) values(?,?,?,?,?,?,?,?,?)");
			
			ps1.setString(1, faculty.getFname());
			ps1.setString(2, faculty.getLname());
			ps1.setString(3, faculty.getAddress());
			ps1.setString(4, faculty.getState());
			ps1.setString(5, faculty.getPin());
			ps1.setString(6, faculty.getMobile());
			ps1.setString(7, faculty.getEmail());
			ps1.setString(8, username);
			ps1.setString(9, password);
			int x = ps1.executeUpdate();
			
			if(x>0) {		
				message = Style.GREEN_BOLD_BRIGHT+"Faculty Added Successfully"+Style.RESET;	
			}
			
		}catch(SQLException e) {
			
			message = "\n           " + Style.RED_BACKGROUND+e.getMessage() + "          \n" + Style.RESET;			
		}
		
		return message;
	}

	
	/* ---------------------------------------------       Search Faculty By Name       ------------------------------------------------------- */
	@Override
	public List<Faculty> searchFacultyByName(String name) throws FacultyException{
		
		List<Faculty> facultys = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("Select * from Faculty where facultyFname = ?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
		
			while(rs.next()) {		
				int id = rs.getInt("facultyId");
				String fname = rs.getString("facultyFname");
				String lname = rs.getString("facultyLname");
				String address = rs.getString("facultyAddress");
				String state = rs.getString("facultyState");
				String pin = rs.getString("facultyPin");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");

				Faculty faculty = new Faculty(id,fname,lname,address,state,pin,mobile,email,username);
				
				facultys.add(faculty);
			}
			
			if(facultys.size() == 0)
				throw new FacultyException(Style.RED_BOLD_BRIGHT+"Faculty " + name + " does not exist "+Style.RESET);
			
			
		}catch(SQLException e) {			
			throw new FacultyException("\n           " + Style.RED_BACKGROUND + e.getMessage() + "          \n" + Style.RESET);
		}
		
		
		return facultys;
	}

	
	/* ---------------------------------------------       Search Faculty by Id       ------------------------------------------------------- */
	@Override
	public Faculty searchFacultyById(int id) throws FacultyException {
		
		Faculty faculty = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("Select * from Faculty where facultyId = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
		
			if(rs.next()) {		
				int fid = rs.getInt("facultyId");
				String fname = rs.getString("facultyFname");
				String lname = rs.getString("facultyLname");
				String address = rs.getString("facultyAddress");
				String state = rs.getString("facultyState");
				String pin = rs.getString("facultyPin");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");

				faculty = new Faculty(fid,fname,lname,address,state,pin,mobile,email,username);
				
			}else
			
				throw new FacultyException(Style.RED_BACKGROUND+"Faculty "+ id + "Does Not Exists"+Style.RESET);
			
		}catch(SQLException e) {
			throw new FacultyException("\n           " + Style.RED_BACKGROUND + e.getMessage() + "          \n" + Style.RESET);
		}
		
		return faculty;
	}
	
	
	/* ---------------------------------------------       View All Faculty Details       ------------------------------------------------------- */

	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
		
		List<Faculty> facultys = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from faculty");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				int id = rs.getInt("facultyId");
				String fname = rs.getString("facultyFname");
				String lname = rs.getString("facultyLname");
				String address = rs.getString("facultyAddress");
				String state = rs.getString("facultyState");
				String pin = rs.getString("facultyPin");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");

				Faculty faculty = new Faculty(id,fname,lname,address,state,pin,mobile,email,username);
				
				facultys.add(faculty);
			}
			
			if(facultys.size() == 0)
				throw new FacultyException(Style.RED_UNDERLINED+"No Student found."+Style.RESET);

			
		}catch(SQLException e) {
			e.printStackTrace();
			
			throw new FacultyException("\n           " + Style.RED_BACKGROUND + e.getMessage() + "          \n" + Style.RESET);
		}
		
		
		
		return facultys;
	}


	
	/* ---------------------------------------------       Update Faculty Details       ------------------------------------------------------- */
	@Override
	public String updateFacultyDetails(String str, String set, int id) throws FacultyException{

		String message = Style.RED_BOLD_BRIGHT+"Data Not Updated."+Style.RESET;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update faculty set "+ str +" = ? where facultyId = ?");
			
			ps.setString(1, set);
			ps.setInt(2, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = Style.GREEN_BOLD_BRIGHT+"Faculty Details Updated Successfully"+Style.RESET;	
			}
			
		}catch(SQLException e) {
			
			message = "\n           " + Style.RED_BACKGROUND + e.getMessage() + "          \n" + Style.RESET;
			
		}
		
		return message;
	}



	/* ---------------------------------------------       Delete Faculty Details       ------------------------------------------------------- */
	
	@Override
	public String deleteFaculty(int facultyId) throws FacultyException {
		
		String message = Style.RED_BOLD_BRIGHT+"Faculty Data Not Updated"+Style.RESET;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("delete from faculty where facultyId = ?");
			
			ps.setInt(1, facultyId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = Style.RED_BOLD_BRIGHT+"Faculty Deleted Successfully"+Style.RESET;
				
			}else {
				throw new FacultyException(Style.RED_UNDERLINED+"           Faculty Not Exist             "+Style.RESET);
				
			}
			
		} catch (SQLException e) {

			throw new FacultyException("\n           " + Style.RED_BACKGROUND + e.getMessage() + "          \n" + Style.RESET);
		}
		
		return message;
	}


}
