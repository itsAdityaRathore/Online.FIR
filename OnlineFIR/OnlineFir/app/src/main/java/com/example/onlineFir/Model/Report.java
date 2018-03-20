package com.example.onlineFir.Model;

/**
 * Created by MY PC on 10-Mar-18.
 */

public class Report {
    private String Adhaar;
    private String Informant_name;
    private String Informant_fname;
    private String Informant_age;
    private String Informant_phone;
    private String Informant_occupation;

    private String Offence_place;
    private String Offence_area;
    private String Offence_date;
    private String Offence_day;
    private String Offence_description;
    private String Offence_time;

    private String Registration_date;
    private String Suspect_name;
    private String Suspect_fname;
    private String Suspect_address;



    public Report() {
    }

    public Report(String adhaar, String informant_name, String informant_fname, String informant_age, String informant_phone, String informant_occupation, String offence_place, String offence_area, String offence_date, String offence_day, String offence_description, String offence_time, String registration_date, String suspect_name, String suspect_fname, String suspect_address) {
        Adhaar = adhaar;
        Informant_name = informant_name;
        Informant_fname = informant_fname;
        Informant_age = informant_age;
        Informant_phone = informant_phone;
        Informant_occupation = informant_occupation;
        Offence_place = offence_place;
        Offence_area = offence_area;
        Offence_date = offence_date;
        Offence_day = offence_day;
        Offence_description = offence_description;
        Offence_time = offence_time;
        Registration_date = registration_date;
        Suspect_name = suspect_name;
        Suspect_fname = suspect_fname;
        Suspect_address = suspect_address;
    }

    public String getOffence_time() {
        return Offence_time;
    }

    public void setOffence_time(String offence_time) {
        Offence_time = offence_time;
    }

    public String getAdhaar() {
        return Adhaar;
    }

    public void setAdhaar(String adhaar) {
        Adhaar = adhaar;
    }

    public String getInformant_name() {
        return Informant_name;
    }

    public void setInformant_name(String informant_name) {
        Informant_name = informant_name;
    }

    public String getInformant_fname() {
        return Informant_fname;
    }

    public void setInformant_fname(String informant_fname) {
        Informant_fname = informant_fname;
    }

    public String getInformant_age() {
        return Informant_age;
    }

    public void setInformant_age(String informant_age) {
        Informant_age = informant_age;
    }

    public String getInformant_phone() {
        return Informant_phone;
    }

    public void setInformant_phone(String informant_phone) {
        Informant_phone = informant_phone;
    }

    public String getInformant_occupation() {
        return Informant_occupation;
    }

    public void setInformant_occupation(String informant_occupation) {
        Informant_occupation = informant_occupation;
    }

    public String getOffence_place() {
        return Offence_place;
    }

    public void setOffence_place(String offence_place) {
        Offence_place = offence_place;
    }

    public String getOffence_area() {
        return Offence_area;
    }

    public void setOffence_area(String offence_area) {
        Offence_area = offence_area;
    }

    public String getOffence_date() {
        return Offence_date;
    }

    public void setOffence_date(String offence_date) {
        Offence_date = offence_date;
    }

    public String getOffence_day() {
        return Offence_day;
    }

    public void setOffence_day(String offence_day) {
        Offence_day = offence_day;
    }

    public String getOffence_description() {
        return Offence_description;
    }

    public void setOffence_description(String offence_description) {
        Offence_description = offence_description;
    }

    public String getRegistration_date() {
        return Registration_date;
    }

    public void setRegistration_date(String registration_date) {
        Registration_date = registration_date;
    }

    public String getSuspect_name() {
        return Suspect_name;
    }

    public void setSuspect_name(String suspect_name) {
        Suspect_name = suspect_name;
    }

    public String getSuspect_fname() {
        return Suspect_fname;
    }

    public void setSuspect_fname(String suspect_fname) {
        Suspect_fname = suspect_fname;
    }

    public String getSuspect_address() {
        return Suspect_address;
    }

    public void setSuspect_address(String suspect_address) {
        Suspect_address = suspect_address;
    }
}
