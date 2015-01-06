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
public class BestelInformatie {
    public int KlantId;
    public int BestellingId;
    public boolean isVerwerkt;
    public String startTijd;
    public String Duur;
    public boolean isFinished;
    public boolean isWaiting;

    public BestelInformatie (int klantID, int bestellingID, String startTijd, String duur) {
        this.KlantId = klantID;
        this.BestellingId = bestellingID;
        this.startTijd = startTijd;
        this.Duur = duur;
    }
}
