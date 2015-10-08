/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Huy
 */
public class Passwords {

    private String _filePath;
    private ArrayList<String> _passwords;

    public Passwords(String filePath) {
        this._filePath = filePath;
        setPasswords();
    }

    private void setPasswords() {
       _passwords = readPasswordFile();
    }
    
    private ArrayList<String> readPasswordFile() {
        String password;
        ArrayList<String> listOfPasswords = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(_filePath))) {            
            while((password = br.readLine()) != null) {
                listOfPasswords.add(password);
            }            
            return listOfPasswords;
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<String> getPasswords() {
        return _passwords;
    }    
}
