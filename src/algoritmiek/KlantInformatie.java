/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek;

/**
 *
 * @author geddyS
 */
public class KlantInformatie {
    public int KlantID;
    public String Achternaam;
    public String Tussenvoegsel;
    public String Voornaam;
    public int Leeftijd;
    public String Geslacht;
    public String Plaats;
    public String Email; 
    
    public KlantInformatie(String achternaam,String tussenvoegsel,String voornaam,int leeftijd,String geslacht,String plaats,String email)
    {
        KlantID = leeftijd*Character.getNumericValue(achternaam.charAt(1))*Character.getNumericValue(voornaam.charAt(1))*Character.getNumericValue(email.charAt(1));
        Achternaam = achternaam;
        Tussenvoegsel = tussenvoegsel;
        Voornaam = voornaam;
        Leeftijd = leeftijd;
        Geslacht = geslacht;
        Plaats = plaats;
        Email = email;
    }
    public KlantInformatie(String achternaam,String voornaam,int leeftijd,String geslacht,String plaats,String email)
    {
        KlantID = leeftijd*Character.getNumericValue(achternaam.charAt(1))*Character.getNumericValue(voornaam.charAt(1))*Character.getNumericValue(email.charAt(1));
        Achternaam = achternaam;
        Voornaam = voornaam;
        Leeftijd = leeftijd;
        Geslacht = geslacht;
        Plaats = plaats;
        Email = email;
    }
}
