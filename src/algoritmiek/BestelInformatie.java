/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek;

import java.util.Date;

/**
 *
 * @author geddyS
 */
public class BestelInformatie {
    public int KlantId;
    public int BestellingId;
    public boolean isVerwerkt;
    public Date startTijd;
    // duur in miliseconds
    public int Duur;
    public boolean isFinished;
    public boolean isWaiting;

    public BestelInformatie (int klantID, int bestellingID, int duur) {
        this.KlantId = klantID;
        this.BestellingId = bestellingID;
        this.Duur = duur;
    }
}
