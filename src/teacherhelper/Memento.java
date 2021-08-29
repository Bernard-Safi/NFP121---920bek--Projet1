/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

/**
 *
 * @author ViSion
 */
public class Memento {

    private String password;

    public Memento(String password) {
        this.password = password;
    }

    public String getState() {
        return this.password;
    }
}
