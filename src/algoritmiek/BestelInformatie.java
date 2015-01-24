package algoritmiek;

import java.util.Date;

public class BestelInformatie {
    public int KlantId;
    public int BestellingId;
    public boolean isVerwerkt;
    public Date startTijd;
    // duur in miliseconds
    public int Duur;
    public boolean isFinished;
    public boolean isWaiting;

    public BestelInformatie (int klantID, int bestellingID, int duur, boolean isWaiting) {
        this.KlantId = klantID;
        this.BestellingId = bestellingID;
        this.Duur = duur;
        this.isWaiting = isWaiting;
    }
}
