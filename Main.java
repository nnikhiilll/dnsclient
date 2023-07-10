import org.xbill.DNS.*;
//additional package imported to create Record array, and toString method for the data
import org.xbill.DNS.Record;

public class Main {
    public static void main(String[] args) {
        String domain = "example.com"; // change to the desired domain name

        try {
            // query A records
            Record[] aRecords = new Lookup(domain, Type.A).run();
            // if record exists
            if (aRecords != null) {
                //accessing each a record
                for (Record record : aRecords) {
                    System.out.println("A Record: " + record.rdataToString());
                }
            }

            // query MX records
            Record[] mxRecords = new Lookup(domain, Type.MX).run();
            //if record exists
            if (mxRecords != null) {
                //accessing each mx record
                for (Record record : mxRecords) {
                    //outputting said mx record
                    System.out.println("MX Record: " + record.rdataToString());
                }
            }
            } catch (TextParseException e) {
            e.printStackTrace();
        }
    }
}
