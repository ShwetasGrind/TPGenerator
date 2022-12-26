package tpjazz; 
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

class SendMail{
 public static void ReportViaMail(String toUser,String fromUser, String Solu, String TPID, String filePath){

  //String to="shweta.b@cerner.com";//change accordingly
  //String user="chethan.kumarg@cerner.com";//change accordingly
 
  //1) get the session object   
  Properties properties = System.getProperties();
  properties.setProperty("mail.smtp.host", "smtp1.cerner.com");//change accordingly
  Session session = Session.getInstance(properties, null);
  //2) compose message   
  try{
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(fromUser));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(toUser));
    message.setSubject("Automated mail from TestPlanCreator");
   

    //3) create MimeBodyPart object and set your message content    
    BodyPart messageBodyPart1 = new MimeBodyPart();
   // messageBodyPart1.setText("This is message body - Mail from selenium script");
    messageBodyPart1.setContent("<!DOCTYPE html>\r\n" + 
    "<html>\r\n" + 
    "<head>\r\n" + 
    "<style>\r\n" + 
    "table {\r\n" + 
    "  font-family: arial, sans-serif;\r\n" + 
    "  border-collapse: collapse;\r\n" + 
    "  width: 100%;\r\n" + 
    "}\r\n" + 
    "\r\n" + 
    "td, th {\r\n" + 
    "  border: 1px solid #dddddd;\r\n" + 
    "  text-align: left;\r\n" + 
    "  padding: 8px;\r\n" + 
    "}\r\n" + 
    "\r\n" + 
    "tr:nth-child(even) {\r\n" + 
    "  background-color: #dddddd;\r\n" + 
    "}\r\n" + 
    "</style>\r\n" + 
    "</head>\r\n" + 
    "<body>\r\n" + 
    "\r\n" + 
    "<h2>TestPlan Details</h2>\r\n" + 
    "\r\n" + 
    "<table style=\"width:100%\">\r\n" + 
    "  <tr>\r\n" + 
    "    <th>Solution</th>\r\n" + 
    "    <th>TestPlan ID</th>\r\n" + 
    "  </tr>\r\n" + 
    "  <tr>\r\n" + 
    "    <td>"+ Solu + "</td>\r\n" + 
    "    <td>"+ TPID + "</td>\r\n" + 
    "    \r\n" + 
    "  </tr>\r\n" + 
    "  \r\n" + 
    "</table>\r\n" + 
    "\r\n" + 
    "</body>\r\n" + 
    "</html>", "text/HTML");
    //4) create new MimeBodyPart object and set DataHandler object to this object    
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();

    String filename = filePath;//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName("Composition");
   
   
    //5) create Multipart object and add MimeBodyPart objects to this object    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart );
   
    //7) send message
    Transport.send(message);
 
   System.out.println("message sent....");
   }catch (MessagingException ex) {ex.printStackTrace();}
 }
 

}
