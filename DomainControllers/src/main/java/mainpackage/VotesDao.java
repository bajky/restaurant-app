package mainpackage;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */

public interface VotesDao extends GenericDao<Vote>{
    List<VotesVO> getVotesByUser(long userID);
}
