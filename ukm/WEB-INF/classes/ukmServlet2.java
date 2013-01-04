   import javax.servlet.*;
   import javax.servlet.http.*;
   import java.io.*;
   import java.sql.*;


   public class ukmServlet2 extends HttpServlet {
    // Use a prepared statement to store a student into the database
    Connection conn = null;
	ResultSet dbResult = null;

		//** Process the HTTP Post request */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

     try {
      // Load the driver
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//out.println("<p>"+"Driver loaded successfully..."+"</p>");

	  // Connect to the database
		conn = DriverManager.getConnection("jdbc:odbc:ukm", "", "");
		//out.println("<p>"+"Connection made successfully..."+"</p>");


         // create statment to read from the database
        Statement dbStatement = conn.createStatement();

        // Execute statment
        dbResult = dbStatement.executeQuery("SELECT* From PerDetail;");

        ResultSetMetaData rsmetaData = dbResult.getMetaData();
		int numberOfColumns = rsmetaData.getColumnCount();


			while(dbResult.next())
				{
				}
     		}

		catch(Exception ex) {
	      ex.printStackTrace();
	    }






 /*     // Obtain PERSONAL DETAIL parameters from the client
      String studentName = request.getParameter("studentName");
      String matric = request.getParameter("matric");
      String ic = request.getParameter("ic");
      String religion = request.getParameter("religion");
      String race = request.getParameter("race");
      String room = request.getParameter("room");
      String phone = request.getParameter("phone");
      String lastIns = request.getParameter("lastIns");
      String programme = request.getParameter("programme");
      String email = request.getParameter("email");
      String street = request.getParameter("street");
      String city = request.getParameter("city");
      String state = request.getParameter("state");
      String zip = request.getParameter("zip");

      // Obtain CURRICULAR EXPERIENCE parameters from the client\
      // ASSOCIATION/CLUB
      String cclub1 = request.getParameter("cclub1");
      String cyear1 = request.getParameter("cyear1");
      String cposition1 = request.getParameter("cposition1");
	      String cclub2 = request.getParameter("cclub2");
	      String cyear2 = request.getParameter("cyear2");
	      String cposition2 = request.getParameter("cposition2");
      String cclub3 = request.getParameter("cclub3");
      String cyear3 = request.getParameter("cyear3");
      String cposition3 = request.getParameter("cposition3");
	      String cclub4 = request.getParameter("cclub4");
	      String cyear4 = request.getParameter("cyear4");
	      String cposition4 = request.getParameter("cposition4");
      String cclub5 = request.getParameter("cclub5");
      String cyear5 = request.getParameter("cyear5");
      String cposition5 = request.getParameter("cposition5");

      // Obtain CURRICULAR EXPERIENCE parameters from the client\
      // ACTIVITIES INVOLVED IN
      String ac1 = request.getParameter("ac1");
      String acyear1 = request.getParameter("acyear1");
      String invol1 = request.getParameter("invol1");
      String ach1 = request.getParameter("ach1");
	      String ac2 = request.getParameter("ac2");
	      String acyear2 = request.getParameter("acyear2");
	      String invol2 = request.getParameter("invol2");
	      String ach2 = request.getParameter("ach2");
	  String ac3 = request.getParameter("ac3");
      String acyear3 = request.getParameter("acyear3");
      String invol3 = request.getParameter("invol3");
      String ach3 = request.getParameter("ach3");
	      String ac4 = request.getParameter("ac4");
	      String acyear4 = request.getParameter("acyear4");
	      String invol4 = request.getParameter("invol4");
	      String ach4 = request.getParameter("ach4");
	  String ac5 = request.getParameter("ac5");
      String acyear5 = request.getParameter("acyear5");
      String invol5 = request.getParameter("invol5");
      String ach5 = request.getParameter("ach5");

      // Obtain CURRICULAR EXPERIENCE parameters from the client\
      // AWARDS RECEIVED
      String awa1 = request.getParameter("awa1");
      String awayear1 = request.getParameter("awayear1");
	      String awa2 = request.getParameter("awa2");
	      String awayear2 = request.getParameter("awayear2");

      // Obtain Skill & Mastery parameters from the client\
      // COMPUTER SKILLS
      String a01 = request.getParameter("001");
      String a02 = request.getParameter("002");
      String a03 = request.getParameter("003");
      String a04 = request.getParameter("004");
      String a05 = request.getParameter("005");
      String a06 = request.getParameter("006");
      String a07 = request.getParameter("007");
      String a08 = request.getParameter("008");
      String a09 = request.getParameter("009");
      String a10 = request.getParameter("010");
      String a11 = request.getParameter("011");
      String a12 = request.getParameter("012");
      String a13 = request.getParameter("013");
      String a14 = request.getParameter("014");
      String a15 = request.getParameter("015");
      String explainSkill = request.getParameter("explainSkill");
      String a16 = request.getParameter("016");
      String a17 = request.getParameter("017");
      String a18 = request.getParameter("018");

      // Obtain Skill & Mastery parameters from the client\
      // LANGUAGE PROFICIENCY
      String a1 = request.getParameter("a1");
      String a2 = request.getParameter("a2");
      String a3 = request.getParameter("a3");
	  String selectionFieldBahasa = request.getParameter("selectionFieldBahasa");
	      String b1 = request.getParameter("b1");
	      String b2 = request.getParameter("b2");
	      String b3 = request.getParameter("b3");
     	  String selectionFieldEnglish = request.getParameter("selectionFieldEnglish");
      String c1 = request.getParameter("c1");
      String c2 = request.getParameter("c2");
      String c3 = request.getParameter("c3");
	  String selectionFieldArab = request.getParameter("selectionFieldArab");
	      String d1 = request.getParameter("d1");
	      String d2 = request.getParameter("d2");
	      String d3 = request.getParameter("d3");
      	  String selectionFieldMandirin = request.getParameter("selectionFieldMandirin");
      String e1 = request.getParameter("e1");
      String e2 = request.getParameter("e2");
      String e3 = request.getParameter("e3");
      String selectionFieldTamil = request.getParameter("selectionFieldTamil");
	      String f1 = request.getParameter("f1");
	      String f2 = request.getParameter("f2");
	      String f3 = request.getParameter("f3");
	      String selectionFieldOther = request.getParameter("selectionFieldOther");
	      String explainLan = request.getParameter("explainLan");

      // Obtain Student Welfare Committee(JAKSA) Secretariat Choices parameters from the client\

      String vice1 = request.getParameter("vice1");
      String vice2 = request.getParameter("vice2");
      String counseling = request.getParameter("counseling");
      String spiritual = request.getParameter("spiritual");
      String academic = request.getParameter("academic");
      String affairs = request.getParameter("affairs");
      String sports = request.getParameter("sports");
      String entrepreneurship = request.getParameter("entrepreneurship");
      String culture = request.getParameter("culture");
      String ict = request.getParameter("ict");
      String integration = request.getParameter("integration");
      String research = request.getParameter("research");
      String security = request.getParameter("security");
      String alumni = request.getParameter("alumni");
*/
			// Comfirmation of Data Before Send To database to store


			out.println("<html>");
			out.println("<head>");
			out.println("<title>New UKM Student Registration System</title>");
			out.println("<link href=\"http://www.ukm.my/portal/templates/yoo_explorer/favicon.ico\" rel=\"shortcut icon\" type=\"image/x-icon\" />");
			out.println("</head>");
			out.println("<body  bgcolor=\"#6699FF\">");
			out.println("<h2 align=\"center\"><img src=\"ukm.png\" /><p><p></p><br /><font size=\"6\">Welcome To Keris Mas Residential College </font><br /><br /></h2>");
			out.println("<h2 align=\"center\"><font size=\"5\"><hr />Your Information Successful Stored, Congratulations...</font><hr /><br /></h2>");
			out.println("<form method = \"post\" action = \"/ukm/ukm.html\">");
		/*	out.println("<p>Name: " + studentName + "</p>");
			out.println("<p>Matric Number: " + matric + "</p>");
			out.println("<p>I/C Number: " + ic + "</p>");
			out.println("<p>Religion: " + religion + "</p>");
			out.println("<p>Race: " + race + "</p>");
			out.println("<p>Room Number: " + room + "</p>");
			out.println("<p>Telephone: " + phone + "</p>");
			out.println("<p>Last Institution: " + lastIns + "</p>");
			out.println("<p>Programme: " + programme + "</p>");
			out.println("<p>Email: " + email + "</p>");
			out.println("<p>Street: " + street + "</p>");
			out.println("<p>City: " + city + "</p>");
			out.println("<p>State: " + state + "</p>");
			out.println("<p>Zip: " + zip + "</p>");
			out.println("<hr />");

			out.println("<p><br /><br /><font size=\"5\">Curricular Experience</font><hr /><br /></p>");

			out.println("<p><table border=\"1\" align=\"left\">	");
			out.println("		  <tr>							");
			out.println("			<td  bgcolor=\"silver\">	");
			out.println("			  <ul>						");
			out.println("				<b>ASSOCIATION/CLUB</b>	");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("			<td bgcolor=\"silver\">		");
			out.println("			  <ul>						");
			out.println("				<b>YEAR</b>				");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("			<td bgcolor=\"silver\">		");
			out.println("			  <ul>						");
			out.println("				<b>POSITION</b>			");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + cclub1 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear1 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cposition1 + "</td>	");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + cclub2 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear2 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cposition2 + "</td>	");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + cclub3 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear3 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cposition3 + "</td>	");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + cclub4 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear4 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cposition4 + "</td>	");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + cclub5 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear5 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cposition5 + "</td>	");
			out.println("		  </tr>							");
			out.println("		  </table>						");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("</p >									");

			out.println("<p><table border=\"1\" align=\"left\">	");
			out.println("		  <tr>							");
			out.println("			<td  bgcolor=\"silver\">	");
			out.println("			  <ul>						");
			out.println("		   <b>ACTIVITIES INVOLVED IN</b>");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("			<td bgcolor=\"silver\">		");
			out.println("			  <ul>						");
			out.println("				<b>YEAR</b>				");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("			<td bgcolor=\"silver\">		");
			out.println("			  <ul>						");
			out.println("				<b>INVOLVEMENT LEVEL</b>");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("			<td bgcolor=\"silver\">		");
			out.println("			  <ul>						");
			out.println("				<b>ACHIEVEMENT</b>		");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + ac1 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear1 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + invol1 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + ach1 + "</td>		");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + ac2 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear2 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + invol2 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + ach2 + "</td>		");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + ac3 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear3 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + invol3 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + ach3 + "</td>		");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + ac4 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear4 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + invol4 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + ach4 + "</td>		");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + ac5 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + cyear5 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + invol5 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + ach5 + "</td>		");
			out.println("		  </tr>							");
			out.println("		  </table>						");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("</p >									");

			out.println("<p><table border=\"1\" align=\"left\">	");
			out.println("		  <tr>							");
			out.println("			<td  bgcolor=\"silver\">	");
			out.println("			  <ul>						");
			out.println("		   <b>AWARDS RECEIVED</b>");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("			<td bgcolor=\"silver\">		");
			out.println("			  <ul>						");
			out.println("				<b>YEAR</b>				");
			out.println("			  </ul>						");
			out.println("			</td>						");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + awa1 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + awayear1 + "</td>	");
			out.println("		  </tr>							");
			out.println("		  <tr>							");
			out.println("			<td bgcolor=\"white\">" + awa2 + "</td>		");
			out.println("			<td bgcolor=\"white\">" + awayear2 + "</td>	");
			out.println("		  </tr>							");
			out.println("		  </table>						");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("<br />									");
			out.println("</p >									");
			out.println("<hr />									");



			out.println("<br /><br /><p><font size=\"5\">Skill & Mastery</font><hr /><br /><br />");

			out.println("<font size=\"4\">Computer Skills</font><br />						  ");

			out.println("	<p>																  ");
			out.println("	<table style=\"text-align: center; width: 70%;\" border=\"1\" cellpadding=\"2\" cellspacing=\"2\">	");
			out.println("		  <tbody>																				");
			out.println("			<tr>																				");
			out.println("			  <td colspan=\"1\" rowspan=\"2\" bgcolor=\"silver\">SOFTWARE</td>					");
			out.println("			  <td colspan=\"3\" rowspan=\"1\" bgcolor=\"silver\">SKILLS LEVEL</td>				");
			out.println("			</tr>																				");
			out.println("			<tr>																				");
			out.println("			  <td bgcolor=\"silver\">VERY GOOD</td>												");
			out.println("			  <td bgcolor=\"silver\">GOOD</td>													");
			out.println("			  <td bgcolor=\"silver\">FAIR</td>													");
			out.println("			</tr>																				");
			out.println("			<tr>																				");
			out.println("			  <td bgcolor=\"silver\">MICROSOFT OFFICE</td>										");
			out.println("			  <td bgcolor=\"white\">" + a01 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a02 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a03 + "</td>																");
			out.println("			</tr>																				");
			out.println("			<tr>																				");
			out.println("			  <td bgcolor=\"silver\">ADOBE PHOTODSHOP</td>										");
			out.println("			  <td bgcolor=\"white\">" + a04 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a05 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a06 + "</td>																");
			out.println("			</tr>																				");
			out.println("			<tr>																				");
			out.println("			  <td bgcolor=\"silver\">ADOBE ILLUSTRATOR</td>										");
			out.println("			  <td bgcolor=\"white\">" + a07 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a08 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a09 + "</td>																");
			out.println("			</tr>																				");
			out.println("			<tr>																				");
			out.println("			  <td bgcolor=\"silver\">ADOBE FLASH PLAYER</td>									");
			out.println("			  <td bgcolor=\"white\">" + a10 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a11 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a12 + "</td>																");
			out.println("			</tr>																				");
			out.println("			<tr>																				");
			out.println("			  <td bgcolor=\"silver\">EDITTING VIDEO</td>										");
			out.println("			  <td bgcolor=\"white\">" + a13 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a14 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a15 + "</td>																");
			out.println("			</tr>																				");
			out.println("			<tr>																				");
			out.println("			  <td bgcolor=\"silver\">OTHERS: " + explainSkill + "</td>	");
			out.println("			  <td bgcolor=\"white\">" + a16 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a17 + "</td>																");
			out.println("			  <td bgcolor=\"white\">" + a18 + "</td>																");
			out.println("			</tr>																				");
			out.println("		  </tbody>																				");
			out.println("		</table>																				");
			out.println("		<br><br /><br />																		");

			out.println("<font size=\"4\">Language Proficiency</font><br />						  						");

			out.println("<p>																	  						");
			out.println("	<table style=\"text-align: center; width: 70%;\" border=\"1\" cellpadding=\"2\" cellspacing=\"2\">  ");
			out.println("		  <tbody>																						");
			out.println("			<tr>																						");
			out.println("			  <td colspan=\"1\" rowspan=\"2\" bgcolor=\"silver\">BAHASA</td>							");
			out.println("			  <td colspan=\"3\" rowspan=\"1\" bgcolor=\"silver\">PROFICIENCY LEVEL</td>					");
			out.println("			  <td colspan=\"1\" rowspan=\"2\" bgcolor=\"silver\">SPM/MUET<P>STPM/STAM</td>				");
			out.println("			</tr>																						");
			out.println("			<tr>																						");
			out.println("			  <td bgcolor=\"silver\">VERY GOOD</td>														");
			out.println("			  <td bgcolor=\"silver\">GOOD</td>															");
			out.println("			  <td bgcolor=\"silver\">FAIR</td>															");
			out.println("			</tr>																						");
			out.println("			<tr>																						");
			out.println("			  <td bgcolor=\"silver\">BAHASA</td>														");
			out.println("			  <td bgcolor=\"white\">" + a1 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + a2 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + a3 + "<br /></td>																	");
			out.println("			  <td bgcolor=\"white\">" + selectionFieldBahasa + "<br /></td></tr>   										");
			out.println("			<tr>																						");
			out.println("			  <td bgcolor=\"silver\">ENGLISH</td>														");
			out.println("			  <td bgcolor=\"white\">" + b1 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + b2 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + b3 + "<br /></td>		   															");
			out.println("			  <td bgcolor=\"white\">" + selectionFieldEnglish + "<br /></td></tr>   										");
			out.println("			<tr>																						");
			out.println("			  <td bgcolor=\"silver\">ARAB</td>															");
			out.println("			  <td bgcolor=\"white\">" + c1 + "<br /></td>  																");
			out.println("			  <td bgcolor=\"white\">" + c2 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + c3 + "<br /></td>		 															");
			out.println("			  <td bgcolor=\"white\">" + selectionFieldArab + "<br /></td></tr>   											");
			out.println("			<tr>																						");
			out.println("			  <td bgcolor=\"silver\">MANDIRIN</td>														");
			out.println("			  <td bgcolor=\"white\">" + d1 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + d2 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + d3 + "<br /></td>		   															");
			out.println("			  <td bgcolor=\"white\">" + selectionFieldMandirin + "<br /></td></tr>   										");
			out.println("			<tr>																						");
			out.println("			  <td bgcolor=\"silver\">TAMIL</td>															");
			out.println("			  <td bgcolor=\"white\">" + e1 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + e2 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + e3 + "<br /></td>		   															");
			out.println("			  <td bgcolor=\"white\">" + selectionFieldTamil + "<br /></td></tr>   										");
			out.println("			<tr>																						");
			out.println("			  <td bgcolor=\"silver\">OTHERS: " + explainLan + "</td>									");
			out.println("			  <td bgcolor=\"white\">" + f1 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + f2 + "<br /></td>   																");
			out.println("			  <td bgcolor=\"white\">" + f3 + "<br /></td>			   														");
			out.println("			  <td bgcolor=\"white\">" + selectionFieldOther + "<br /></td></tr>   										");
			out.println("		  </tbody>																						");
			out.println("		</table>																						");
			out.println("<br />																									");
			out.println("<br />																									");
			out.println("<br />																									");
			out.println("</p >																									");
			out.println("<hr />																									");


			out.println("<br /><br /><p><font size=\"5\">Student Welfare Committee(JAKSA) Secretariat Choices</font><hr /><br /><br />");
			out.println("<table style=\"text-align: center; width: 30%;\" border=\"1\" cellpadding=\"2\" cellspacing=\"2\">     ");
			out.println("	  <tbody>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\" colspan=\"2\" rowspan=\"1\"><font size=\"4\">Choice(s) Selected</font></td>");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Vice President of YDP 1</td>											");
			out.println("		  <td bgcolor=\"white\">" + vice1 + "<br /></td>												");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Vice President of YDP 2</td>											");
			out.println("		  <td bgcolor=\"white\">" + vice2 + "<br /></td>												");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Welfare & Counseling</td>										");
			out.println("		  <td bgcolor=\"white\">" + counseling + "<br /></td>											");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Spiritual</td>													");
			out.println("		  <td bgcolor=\"white\">" + spiritual + "<br /></td>											");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Academic</td>													");
			out.println("		  <td bgcolor=\"white\">" + academic + "<br /></td>											");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Student Affairs (Girls)</td>									");
			out.println("		  <td bgcolor=\"white\">" + affairs + "<br /></td>											");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Sports & Recreation</td>										");
			out.println("		  <td bgcolor=\"white\">" + sports + "<br /></td>												");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Entrepreneurship</td>											");
			out.println("		  <td bgcolor=\"white\">" + entrepreneurship  + "<br /></td>									");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Culture</td>													");
			out.println("		  <td bgcolor=\"white\">" + culture + "<br /></td>											");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of ICT & Publishing</td>											");
			out.println("		  <td bgcolor=\"white\">" + ict + "<br /></td>												");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Integration & Racial Unity</td>								");
			out.println("		  <td bgcolor=\"white\">" + integration + "<br /></td>										");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Research & Innovation</td>										");
			out.println("		  <td bgcolor=\"white\">" + research + "<br /></td>											");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Security & Special Tasks</td>									");
			out.println("		  <td bgcolor=\"white\">" + security + "<br /></td>											");
			out.println("		</tr>																							");
			out.println("		<tr>																							");
			out.println("		  <td bgcolor=\"silver\">Exco of Alumni Relations</td>											");
			out.println("		  <td bgcolor=\"white\">" + alumni + "<br /></td>												");
			out.println("		</tr>																							");
			out.println("	  </tbody>																							");
			out.println("	</table>																							");
			out.println("	<br>																								");
			out.println("<br />																									");
			out.println("<br />																									");
			out.println("</p >																									");
			out.println("<hr />																									");


			out.println("<h2 align=\"center\"><font size=\"5\">Your Data Successful Stored to our Database</font><br /></h2>");

	*/
			out.print("<p align=\"center\"><input type = \"submit\" name = \"Submit\" value = \"Click Here For New Registration\">");
			out.print("<br />");
			out.print("<br />");
			out.print("<br />");
			out.print("<br />");
			out.print("<br />");
			out.print("<br />");
			out.print("<hr />");
			out.print("<hr />");
			out.print("<p align=\"center\">Build and maintain by A134651 Mohd Ilhamidi Bin Shafei</p>");
			out.print("<p align=\"center\">Copyright © DiProfInfiniT Corporate Sdn. Bhd</p>");
			out.print("<p align=\"center\">Tel:014-5131028 | Last Update: 3 Mac 2012</p>");
			out.print("<hr />");
			out.print("<hr />");
			out.println("</body>");
			out.println("</html>");

    }
 }
