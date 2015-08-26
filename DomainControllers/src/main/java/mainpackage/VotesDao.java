package mainpackage;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bajky on 23.8.2015.
 */
@Repository
public interface VotesDao extends GenericDao<Vote>{
    List<VotesVO> getVotesByUser(long userID);
}
