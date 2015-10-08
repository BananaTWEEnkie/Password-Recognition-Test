/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Huy
 */
public class Log {

    int _count;
    int _indicator;
    String _initials;
    int _age;
    String _gender;
    File file = new File("log.txt");

    public Log(int count) {
        this._count = count;
    }

    public int getCount() {
        return _count;
    }

    public void setCount() {
        _count += 1;
    }

    public void setPassword(int indicator) {
        this._indicator = indicator;
    }

    public int getPassword() {
        return _indicator;
    }

    public void write(String logEntry) {
        Date printDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        if (file.length() != 0){
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
                out.println(sdf.format(printDate) + getInfo() + "\t" + logEntry);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)))) {
                out.println(sdf.format(printDate) + getInfo() + "\t" + logEntry);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void setInfo(String initials, int age, String gender) {
        this._initials = initials;
        this._age = age;
        this._gender = gender;
    }

    private String getInfo() {
        return "\t" + _initials + "+" + _age + "+" + _gender;
    }
}
