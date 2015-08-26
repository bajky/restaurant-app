package mainpackage;

import java.io.Serializable;
import java.util.Date;

/**
 * Immotable value object.
 *
 * @author David david.bajko@senacor.com
 */
public class VotesVO implements Serializable{
    final private Date timeFrom;
    final private String tittle;

    public VotesVO(Date timeFrom, String tittle) {
        this.timeFrom = timeFrom;
        this.tittle = tittle;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public String getTittle() {
        return tittle;
    }
}
