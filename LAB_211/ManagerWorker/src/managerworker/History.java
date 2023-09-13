/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerworker;

/**
 *
 * @author quann
 */
public class History extends Worker {
    private String status;
    private String date;

    public History(String status, String date) {
        this.status = status;
        this.date = date;
    }

    public History(String id, String name, int age, double salary, String workLocation, String status, String date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
