/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runcommand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanL
 */
public class RunCommand {

    static String pgDump = "\"C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump.exe\"";
    static String dumpFile = "\"C:\\Users\\JuanL\\Desktop\\Backup postgres\\dbasefinalpro2.sql\"";
    /**
     * @param args the command line arguments
     */
    public static void prn(String message){
        System.out.println(message);
    }
    
    public static void main(String[] args) throws IOException {
      
        String sql = pgDump+ " -h localhost -U postgres  -d dbtest -f "+dumpFile;
        prn(sql);
        Runtime r = Runtime.getRuntime();
        Process p;
        ProcessBuilder pb;
        r = Runtime.getRuntime();
        pb = new ProcessBuilder(sql);
        pb.environment().put( "PGPASSWORD", "JuanLH@20" );
        pb.redirectErrorStream(true);
        p = pb.start();
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        String ll;
        
        while ((ll = input.readLine()) != null) {
         System.out.println(ll);
        }      
         
         
    }
}
