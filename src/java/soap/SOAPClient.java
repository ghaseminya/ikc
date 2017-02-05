package soap;

import java.io.*;
import java.net.*;

public class SOAPClient {
    public static void main(String[] args) throws Exception {
        SOAPClient m=new SOAPClient();
//        m.getToket("2060", "1234", "1234");
m.verify("3534534534", "93525457975513877165");
    }
    public String verify(String refid,String token){
//        boolean res=false;
          try{
    	//Get https certificate:
    	System.setProperty("javax.net.ssl.keyStore","/dargah/keystore.jks");
    	System.setProperty("javax.net.ssl.keyStorePassword","keystore");
        System.out.println("!!!!"+System.getProperty("javax.net.ssl.keyStore")+"!!!!!!");
        System.out.println("!!!!"+System.getProperty("javax.net.ssl.keyStore")+"!!!!!!");
        String SOAPUrl      = "‫‪https://ikc.shaparak.ir/TVerify/Verify.svc?wsdl";
//        String xmlFile2Send = "files/data.xml";
		String SOAPAction = "http://tempuri.org/TVerify/Verify";
				
        // Create the connection where we're going to send the file.
        URL url = new URL(SOAPUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        
        String date="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns4286=\"http://tempuri.org\"><SOAP-ENV:Body>"
                + "<Verify xmlns=\"http://tempuri.org/\">"
               
                + "<merchantId>B6A3</merchantId>"
                + "<token>"+token+"</token>"
                + "<‫‪referenceId‬‬>"+refid+"</‫‪referenceId‬‬>"
                
                + "</Verify>"
                + "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
        
        byte[] b = date.getBytes(); //Converted to Byte Array
        
        //Set the appropriate HTTP parameters.
        httpConn.setRequestProperty( "User-Agent", "NuSOAP/0.9.5 (1.123)" );
        httpConn.setRequestProperty( "Content-Length", String.valueOf( SOAPUrl.length() ) );
        httpConn.setRequestProperty("Content-Type","text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        // Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write(b);    
        out.close();

        // Read the response and write it to standard out.
        InputStreamReader isr =
            new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        
        //Output to console
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            token+=(inputLine);
//        String tik=token.substring(token.indexOf("<a:token>")+9,token.indexOf("</a:token>"));
//        System.out.println(tik);
        System.out.println(token);
        in.close();
        return token;
            }catch(Exception s){
                s.printStackTrace();
                return "bug";
            }
//        return res;
    }
        public String getToket(String amount,String invoice,String paymentid){
            try{
    	//Get https certificate:
    	System.setProperty("javax.net.ssl.keyStore","/dargah/keystore.jks");
    	System.setProperty("javax.net.ssl.keyStorePassword","keystore");
        System.out.println("!!!!"+System.getProperty("javax.net.ssl.keyStore")+"!!!!!!");
        System.out.println("!!!!"+System.getProperty("javax.net.ssl.keyStore")+"!!!!!!");
        String SOAPUrl      = "https://ikc.shaparak.ir/TToken/Tokens.svc?wsdl";
//        String xmlFile2Send = "files/data.xml";
		String SOAPAction = "http://tempuri.org/ITokens/MakeToken";
				
        // Create the connection where we're going to send the file.
        URL url = new URL(SOAPUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        
        String date="<?xml version=\"1.0\" encoding=\"UTF-8\"?><SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns4286=\"http://tempuri.org\"><SOAP-ENV:Body><MakeToken xmlns=\"http://tempuri.org/\"><amount>"+amount+"</amount><merchantId>B6A3</merchantId><invoiceNo>"+invoice+"</invoiceNo><paymentId>"+paymentid+"</paymentId><revertURL>http://javahosting.ir:8080/ikc/back.jsp</revertURL></MakeToken></SOAP-ENV:Body></SOAP-ENV:Envelope>";
        
        byte[] b = date.getBytes(); //Converted to Byte Array
        
        //Set the appropriate HTTP parameters.
        httpConn.setRequestProperty( "User-Agent", "NuSOAP/0.9.5 (1.123)" );
        httpConn.setRequestProperty( "Content-Length", String.valueOf( SOAPUrl.length() ) );
        httpConn.setRequestProperty("Content-Type","text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        // Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write(b);    
        out.close();

        // Read the response and write it to standard out.
        InputStreamReader isr =
            new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        
        String token="";
        //Output to console
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            token+=(inputLine);
        String tik=token.substring(token.indexOf("<a:token>")+9,token.indexOf("</a:token>"));
        System.out.println(tik);
        System.out.println(token);
        in.close();
        return tik;
        
            }catch(Exception s){
                s.printStackTrace();
                System.out.println("#################mamal");
                return s.getMessage()+"/dargah/keystore.jks";
            }
            
    }
}